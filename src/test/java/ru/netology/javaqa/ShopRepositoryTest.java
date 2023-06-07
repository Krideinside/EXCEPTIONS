package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    ShopRepository shop = new ShopRepository();
    Product bread = new Product(1, "Хлеб", 30);
    Product butter = new Product(2, "Масло", 50);
    Product salt = new Product(3, "Соль", 20);

    @Test
    public void shouldFindProductByID() {

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        Product expected = salt;
        Product actual = shop.findById(3);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotFindProductByID() {

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        shop.findById(4);
    }

    @Test
    public void shouldRemoveProductByID(){

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

        shop.add(bread);
        shop.add(butter);
        shop.add(salt);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shop.removeById(4);
        });
    }
}

//    @Test
//    public void souldTrytoAddProductWithSameId() {
//        Product water = new Product(2, "Вода",15);
//
//        shop.add(water);
//    }