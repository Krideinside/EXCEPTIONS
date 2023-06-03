package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
public void shouldDeleteProductByID() {
        ShopRepository shop = new ShopRepository();
        Product bread = new Product(1, "Хлеб", 30);
        Product butter = new Product(2, "Масло", 50);
        Product solt = new Product(3, "Соль", 20);

        shop.add(bread);
        shop.add(butter);
        shop.add(solt);

        Product expected = solt;
        Product actual = shop.remove(3);

        Assertions.assertEquals(expected, actual);

    }
}