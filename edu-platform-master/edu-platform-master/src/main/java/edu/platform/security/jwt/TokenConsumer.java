package edu.platform.security.jwt;

import edu.platform.security.jwt.payload.Payload;
import edu.platform.security.jwt.util.JwtClaimKey;
import org.jose4j.jwt.consumer.InvalidJwtException;

import java.security.PublicKey;
import java.util.Map;

public final class TokenConsumer {
    private String audience;
    private JWTParser parser;


    public TokenConsumer(String audience, PublicKey publicKey) {
        this.audience = audience;
        this.parser = new JWTParser(publicKey);
    }

    public Payload consume(String token) throws InvalidJwtException {
        Map<String, Object> claims = parser.parseToken(token, audience);

        Payload payload = new Payload();

        payload.setId((Long) claims.get(JwtClaimKey.ID.getValue()));
        payload.setEmail((String) claims.get(JwtClaimKey.EMAIL.getValue()));
        payload.setPhoneNumber((String) claims.get(JwtClaimKey.PHONE_NUMBER.getValue()));
        payload.setAccount((String) claims.get(JwtClaimKey.ACCOUNT.getValue()));
        payload.setRole((String) claims.get(JwtClaimKey.ROLE.getValue()));

        return payload;
    }
}
