package com.example.ex02.service;

import java.util.Map;

public interface IDictionaryService {
    Map<String, String> displayAll();
    String search(String key);
}
