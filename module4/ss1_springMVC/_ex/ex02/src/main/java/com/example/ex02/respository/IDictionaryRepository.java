package com.example.ex02.respository;

import java.util.Map;

public interface IDictionaryRepository {
    Map<String, String> getAll();
    String getByKey(String key);
}
