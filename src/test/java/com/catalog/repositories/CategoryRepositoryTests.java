package com.catalog.repositories;

import com.catalog.entities.Category;
import com.catalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        //preparar dados
        long existingId = 1L;

        //executar ação
        repository.deleteById(existingId);

        //verificar se realmente delete
        Optional<Category> result = repository.findById(existingId);

        //testa se p objeto está presente
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void testSaveCategory(){
        Category category = new Category();
        category.setName("Test Category");
//        product.setDate(Instant.parse("2024-10-25T21:21:00:00+03:00"));
        Category savedCategory = repository.save(category);

        //Asserts são para certificar se tudo deu certo
        assertThat(savedCategory).isNotNull(); //verifica se não é nulo
        assertThat(savedCategory.getName()).isEqualTo("Test Category");

    }
}
