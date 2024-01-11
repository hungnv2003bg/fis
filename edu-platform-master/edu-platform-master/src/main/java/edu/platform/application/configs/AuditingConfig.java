package edu.platform.application.configs;

import edu.platform.security.UserAuthentication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditingConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("");
        } else {
            try {
                UserAuthentication userAuthentication = (UserAuthentication) SecurityContextHolder.getContext().getAuthentication();
                UserDetails userDetails = (UserDetails) userAuthentication.getDetails();

                return Optional.of(userDetails.getUsername());
            } catch (Exception e) {
                return Optional.of("");
            }
        }
    }
}
