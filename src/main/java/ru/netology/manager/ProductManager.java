package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Product[] getAll() {
        Product[] products = repository.findAll();
        return products;
    }

    public Product[] searchBy(String text) {
        Product[] item = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[item.length + 1];
                for (int i = 0; i < item.length; i++) {
                    tmp[i] = item[i];
                }
                tmp[tmp.length - 1] = product;
                item = tmp;
            }
        }
        return item;
    }


    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }


}