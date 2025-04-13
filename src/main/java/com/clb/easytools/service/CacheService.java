package com.clb.easytools.service;


public interface CacheService {
    void put(String key, Object vlaue);

    Object get(String key);
}
