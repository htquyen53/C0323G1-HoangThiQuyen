package com.example.ex02.service;

import com.example.ex02.respository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository iDictionaryRepository;

    @Override
    public Map<String, String> displayAll() {
        return iDictionaryRepository.getAll();
    }

    @Override
    public String search(String key) {
        return iDictionaryRepository.getByKey(key);
    }
}
