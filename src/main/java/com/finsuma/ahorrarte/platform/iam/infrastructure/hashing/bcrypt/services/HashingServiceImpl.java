package com.FinSuma.AhorrArte.platform.iam.infrastructure.hashing.bcrypt.services;

import com.FinSuma.AhorrArte.platform.iam.infrastructure.hashing.bcrypt.BCryptHashingService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashingServiceImpl implements BCryptHashingService {

    private final BCryptPasswordEncoder passwordEncoder;

    public HashingServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * Encoded a password
     *
     * @param rawPassword the password to encode
     * @return String the encoded password
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Match a raw password with an encoded password using the BCrypt algorithm
     *
     * @param rawPassword     the raw password
     * @param encodedPassword the encoded password
     * @return boolean true if raw password match the encoded password, false otherwise
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

