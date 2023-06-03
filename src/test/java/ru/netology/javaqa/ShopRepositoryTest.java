package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void shouldFindProductByID() {
        ShopRepository shop = new ShopRepository();
        Product bread = new Product(1, "Хлеб", 30);
        Product butter = new Product(2, "Масло", 50);
        Product salt = new Product(3, "Соль", 20);

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        Product expected = salt;
        Product actual = shop.findById(3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindProductByID() {
        ShopRepository shop = new ShopRepository();
        Product bread = new Product(1, "Хлеб", 30);
        Product butter = new Product(2, "Масло", 50);
        Product salt = new Product(3, "Соль", 20);

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        shop.findById(4);
    }

    @Test
    public void shouldRemoveProductByID() {
        ShopRepository shop = new ShopRepository();
        Product bread = new Product(1, "Хлеб", 30);
        Product butter = new Product(2, "Масло", 50);
        Product salt = new Product(3, "Соль", 20);

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        shop.removeById(2);

        Product[] expected = {bread, salt};
        Product[] actual = shop.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTryRemoveFakeProductByID() {
        ShopRepository shop = new ShopRepository();
        Product bread = new Product(1, "Хлеб", 30);
        Product butter = new Product(2, "Масло", 50);
        Product salt = new Product(3, "Соль", 20);

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        try {
            shop.removeById(4);
        } catch (NotFoundException e) {
            System.out.println("Ошибка");
        }
    }
}