package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private Product product1 = new Book(1010, "Harry Potter", 1_000, "J.Rowling");
    private Product product2 = new Book(1111, "`War and Peace`", 3_000, "Tolstoy");
    private Product product3 = new Smartphone(2222, "Samsung", 50_000, "Galaxy");
    private Product product4 = new Smartphone(3333, "Samsung", 15_000, "A7");

    @BeforeEach
    public void save() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);

    }

    @Test
    public void shouldFindAllProducts() {
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3, product4};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldDeleteProductByIdOneProduct() {
        repo.removeById(1010);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3, product4};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProductByIdTwoProducts() {
        repo.removeById(1010);
        repo.removeById(1111);

        Product[] actual = repo.findAll();
        Product[] expected = {product3, product4};

        assertArrayEquals(expected, actual);
    }


}
