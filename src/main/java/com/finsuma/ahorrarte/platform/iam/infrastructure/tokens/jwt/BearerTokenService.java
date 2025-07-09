package com.FinSuma.AhorrArte.platform.iam.infrastructure.tokens.jwt;

import com.FinSuma.AhorrArte.platform.iam.application.internal.outboundservices.tokens.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

/**
 * This interface is a market interface for the JWT token service.
 * It extends the {@link TokenService} interface
 * This interface is used to inject the JWT token service in the {@link com.example.inviertelow.platform.iam.infrastructure.tokens.jwt.services.TokenServiceImpl}
 */
public interface BearerTokenService extends TokenService {

    /**
     * This method is responsible for extracting the JWT token HTTP request
     * @param request the HTTP request
     * @return String the JWT token
     */
    String getBearerTokenFrom(HttpServletRequest request);

    /**
     * This method is responsible for extracting the JWT token from HTTP request
     * @param authentication the authentication object
     * @return String the JWT token
     * @see Authentication
     */
    String generateToken(Authentication authentication);
}

