package com.FinSuma.AhorrArte.platform.iam.infrastructure.hashing.bcrypt;

import com.FinSuma.AhorrArte.platform.iam.application.internal.outboundservices.hashingService.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This interface is a worker interface for the BCrypt hashing service
 * It extends the {@link HashingService} and {@link PasswordEncoder} interfaces.
 * This interface is used to inject the BCrypt hashing service in the {@link com.example.inviertelow.platform.iam.infrastructure.hashing.bcrypt.services.HashingServiceImpl}
 */
public interface BCryptHashingService extends HashingService, PasswordEncoder {

}

