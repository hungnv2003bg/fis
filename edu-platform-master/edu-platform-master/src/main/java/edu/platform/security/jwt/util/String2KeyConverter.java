package edu.platform.security.jwt.util;

import edu.platform.application.exceptions.BusinessCode;
import edu.platform.application.exceptions.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.IOException;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

@Log4j2
public final class String2KeyConverter {

    private KeyFactory keyFactory;

    public String2KeyConverter() {
        try {
            keyFactory = KeyFactory.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            log.error("String2KeyConverter exception constructor {}", e.getCause().toString());
            throw new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR);
        }
    }

    public PrivateKey getPrivateKey(String privateKey) {

        try (PemReader reader = new PemReader(new StringReader(privateKey))) {
            byte[] content;
            PemObject pemObject = reader.readPemObject();
            if (Objects.nonNull(pemObject)) {
                content = pemObject.getContent();
                PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(content);
                return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            }
            log.error("String2KeyConverter exception getPrivateKey pemObject null");
            throw new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR);
        } catch (IOException | InvalidKeySpecException e) {
            log.error("String2KeyConverter exception getPrivateKey {}", e.getCause().toString());
            throw new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR);
        }
    }

    public PublicKey getPublicKey(String publicKey) {
        try (PemReader reader = new PemReader(new StringReader(publicKey))) {
            byte[] content;
            PemObject pemObject = reader.readPemObject();
            if (Objects.nonNull(pemObject)) {
                content = pemObject.getContent();
                X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(content);
                return keyFactory.generatePublic(x509EncodedKeySpec);
            }
            log.error("String2KeyConverter exception getPublicKey pemobject is null");
            throw new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR);
        } catch (IOException | InvalidKeySpecException e) {
            log.error("String2KeyConverter exception getPublicKey exception {}", e.getCause().toString());
            throw new BusinessException(BusinessCode.INTERNAL_SERVER_ERROR);
        }
    }
}
