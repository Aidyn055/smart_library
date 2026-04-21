package com.example.smartlibrary.mapper;

import com.example.smartlibrary.dto.CategoryDto;
import com.example.smartlibrary.entity.Category;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
    List<CategoryDto> toDtoList(List<Category> categories);
}
