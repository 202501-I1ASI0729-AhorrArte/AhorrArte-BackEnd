package com.FinSuma.AhorrArte.platform.iam.application.internal.outboundservices.hashingService;

/**
 * HashingService interface
 * The interface is used to encode and match password
 */
public interface HashingService {

    /**
     * Encoded a password
     * @param rawPassword the password to encode
     * @return String the encoded password
     */
    String encode(CharSequence rawPassword);

    /**
     * Match a raw password with an encoded password
     * @param rawPassword the raw password
     * @param encodedPassword the encoded password
     * @return boolean true if raw password match the encoded password, false otherwise
     */
    boolean matches(CharSequence rawPassword, String encodedPassword);
}

