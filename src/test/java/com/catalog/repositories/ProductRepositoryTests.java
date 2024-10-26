package com.catalog.repositories;


import com.catalog.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository repository;

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        //preparar dados
        long existingId = 1L;

        //executar ação
        repository.deleteById(existingId);

        //verificar se realmente delete
        Optional<Product> result = repository.findById(existingId);

        //testa se p objeto está presente
        Assertions.assertFalse(result.isPresent());

    }

    @Test
    public void testSaveProduct(){
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(550.0);
        product.setImgUrl("localhost/testimg");
//        product.setDate(Instant.parse("2024-10-25T21:21:00:00+03:00"));
        Product savedProduct = repository.save(product);

        //Asserts são para certificar se tudo deu certo
        assertThat(savedProduct).isNotNull(); //verifica se não é nulo
        assertThat(savedProduct.getName()).isEqualTo("Test Product");

    }

}
