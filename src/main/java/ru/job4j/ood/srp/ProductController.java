package ru.job4j.ood.srp;

public class ProductController {
    public void addProduct(Product product) {
        /* Логика добавления продукта */
        processOrder(product);
    }

    public void removeProduct(Product product) {
        /* Логика удаления продукта */
        processOrder(product);
    }

    public void updateProduct(Product product) {
        /* Логика обновления продукта */
        processOrder(product);
    }

    public void processOrder(Product product) {
        /* Логика обработки заказа */
        System.out.println("Обработан заказ продукта: " + product.getName());
    }
}