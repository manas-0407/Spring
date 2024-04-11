package com.example.project.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Component( value = "auditAwareImp")
public class AuditImplement implements AuditorAware<String> {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
