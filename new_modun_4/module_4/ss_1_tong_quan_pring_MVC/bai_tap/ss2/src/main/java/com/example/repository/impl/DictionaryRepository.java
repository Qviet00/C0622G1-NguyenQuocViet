package com.example.repository.impl;

import com.example.model.Dictionary;
import com.example.repository.IDictionaryRepository;

import java.util.ArrayList;
import java.util.List;

public class DictionaryRepository implements IDictionaryRepository {
    private static List<Dictionary> dictionaries = new ArrayList<>();
    static{
        dictionaries.add(new Dictionary("i","tôi"));
        dictionaries.add(new Dictionary("is","là"));
        dictionaries.add(new Dictionary("yes","có"));
        dictionaries.add(new Dictionary("this","Đây"));
        dictionaries.add(new Dictionary("that","kia"));}
    @Override
    public List<Dictionary> searchAll() {
        return dictionaries;
    }
}
