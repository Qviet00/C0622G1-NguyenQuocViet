package service.impl;

import model.Category;
import repository.ICategoryRepository;
import repository.impl.CategoryRepository;
import service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {

    ICategoryRepository iCategoryRepository=new CategoryRepository();
    @Override
    public List<Category> seclectAll() {

        return iCategoryRepository.seclectAll();
    }
}
