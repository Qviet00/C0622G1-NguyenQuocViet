package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    String[] arr1 = {"i", "is", "yes","this","that"};
    String[] arr2 = {"toi", "la", "co", "day","kia"};

    @Override
    public String search(String word) {
        String result = "Không tìm thấy";
        for (int i = 0; i < arr1.length; i++) {
            if (word.toLowerCase(Locale.ROOT).equals(arr1[i])) {
                result = arr2[i];
            }
        }
        return result;
    }
}
