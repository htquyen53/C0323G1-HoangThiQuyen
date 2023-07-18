package com.example.ex02.respository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    private static final Map<String, String> DICTIONARY_MAP = new HashMap<>();
    static {
        DICTIONARY_MAP.put("beautiful","xinh đẹp");
        DICTIONARY_MAP.put("energetic","tràn đầy năng lượng");
        DICTIONARY_MAP.put("house","ngôi nhà");
        DICTIONARY_MAP.put("friendly","thân thiện");
        DICTIONARY_MAP.put("happy", "hạnh phúc");
        DICTIONARY_MAP.put("stupid", "ngốc nghếch");
    }

    @Override
    public Map<String, String> getAll() {
        return DICTIONARY_MAP;
    }

    @Override
    public String getByKey(String key) {
        return DICTIONARY_MAP.get(key);
    }
}
