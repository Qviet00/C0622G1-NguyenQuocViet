package com.example.repository;

import com.example.model.Dictionary;

import java.util.List;

public interface IDictionaryRepository {
    List<Dictionary> searchAll();
}
