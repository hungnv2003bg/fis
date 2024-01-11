package edu.platform.security;

import edu.platform.security.jwt.TokenConsumer;
import edu.platform.security.jwt.payload.Payload;
import lombok.AllArgsConstructor;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TokenAuthenticator {
    private final TokenConsumer tokenConsumer;

    public UserAuthentication getAuthentication(String token) throws InvalidJwtException {
        UserAuthentication userAuthentication = null;
        if (token != null && !token.isEmpty()) {
            Payload jwtPayload = this.tokenConsumer.consume(token);
            UserDetail userDetails = new UserDetail();
            userDetails.setUser(jwtPayload);
            userAuthentication = new UserAuthentication(userDetails);
        }

        return userAuthentication;
    }
}
