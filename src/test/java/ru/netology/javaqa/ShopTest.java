package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {

    @Test
    public void testException() {
        ShopRepository rep = new ShopRepository();
        Product product1 = new Product(1, "product 1", 10);
        Product product2 = new Product(2, "product 2", 20);
        Product product3 = new Product(3, "product 3", 30);

        rep.add(product1);
        rep.add(product2);
        rep.add(product3);


        Assertions.assertThrows(NotFoundException.class,
                () -> rep.remove(5)
        );

    }

    @Test
    public void testAdd() {
        ShopRepository rep = new ShopRepository();
        Product product1 = new Product(1, "product 1", 10);
        Product product2 = new Product(2, "product 2", 20);
        Product product3 = new Product(3, "product 3", 30);

        rep.add(product1);
        rep.add(product2);
        rep.add(product3);
        rep.remove(2);

        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, rep.findAll());

    }
}
