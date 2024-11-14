package com.wizwolf.component;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

@Component
public class SessionManager {
    private Cache<String, Object> cache;

    public SessionManager() {
        this.cache = Caffeine.newBuilder().build();
    }
}
