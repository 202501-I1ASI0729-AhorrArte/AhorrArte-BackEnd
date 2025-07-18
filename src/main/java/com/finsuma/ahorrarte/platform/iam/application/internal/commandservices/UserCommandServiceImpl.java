package com.finsuma.ahorrarte.platform.iam.application.internal.commandservices;

import com.finsuma.ahorrarte.platform.iam.application.internal.outboundservices.hashingService.HashingService;
import com.finsuma.ahorrarte.platform.iam.domain.model.aggregates.User;
import com.finsuma.ahorrarte.platform.iam.domain.services.UserCommandService;
import com.finsuma.ahorrarte.platform.iam.domain.model.commands.SignInCommand;
import com.finsuma.ahorrarte.platform.iam.domain.model.commands.SignUpCommand;
import com.finsuma.ahorrarte.platform.iam.application.internal.outboundservices.tokens.TokenService;
import com.finsuma.ahorrarte.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.finsuma.ahorrarte.platform.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, RoleRepository roleRepository, HashingService hashingService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (userRepository.existsByUsername(command.username())) {
            throw new RuntimeException("Username already exists");
        }
        var roles = command.roles().stream().map(
                role -> roleRepository.findByName(role.getName()).orElseThrow(
                        () -> new RuntimeException("Role name not found"))).collect(java.util.stream.Collectors.toList());

        var user = new User(command.username(), hashingService.encode(command.password()), roles);

        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty()) throw new RuntimeException("Username not found");
        if (!hashingService.matches(command.password(), user.get().getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }
}
