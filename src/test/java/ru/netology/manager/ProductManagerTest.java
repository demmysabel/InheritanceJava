package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    private Product product1 = new Book(1010, "Harry Potter", 1_000, "J.Rowling");
    private Product product2 = new Book(1111, "`War and Peace`", 3_000, "Tolstoy");
    private Product product3 = new Smartphone(2222, "Samsung", 50_000, "Galaxy");
    private Product product4 = new Smartphone(3333, "Samsung", 15_000, "A7");


    @Test
    public void searchForMoreThanOneResult() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {product3, product4};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void searchForOneResult() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] actual = manager.searchBy("War");
        Product[] expected = {product2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForNoResult() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);


        Product[] actual = manager.searchBy("Stephen King");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }


}