package com.learn.cards.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component(value = "AuditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    /**
     * @return Cards_MS
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Cards_MS");
    }
}
