package xyz.victorl.scrontch.users.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TokenBlacklistService {
    private final Set<String> blacklistedTokens = new HashSet<>();
    public void addToBlacklist(String token) {
        blacklistedTokens.add(token);
    }
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }
    public void clearBlacklist() {
        blacklistedTokens.clear();
    }
}
