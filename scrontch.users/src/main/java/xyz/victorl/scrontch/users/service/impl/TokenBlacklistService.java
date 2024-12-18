package xyz.victorl.scrontch.users.service.impl;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TokenBlacklistService {

    private final Set<String> blacklistedTokens = new HashSet<>();

    // Add a token to the blacklist
    public void addToBlacklist(String token) {
        blacklistedTokens.add(token);
    }

    // Check if a token is blacklisted
    public boolean isTokenBlacklisted(String token) {
        return blacklistedTokens.contains(token);
    }

    // Clear the blacklist (optional)
    public void clearBlacklist() {
        blacklistedTokens.clear();
    }
}
