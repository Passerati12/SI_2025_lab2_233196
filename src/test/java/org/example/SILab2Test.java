package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyStatementTest() {

        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null,"1234567890123456"));
        assertTrue(ex1.getMessage().contains("allItems list can't be null"));

        RuntimeException ex2 = assertThrows(RuntimeException.class, () -> {
            List<Item> items= List.of(new Item(null,1,100,0));
            SILab2.checkCart(items,"1234567890123456");});
        assertTrue(ex2.getMessage().contains("Invalid item!"));
//7-9-11
        List<Item> items3= List.of(new Item("Item1",5,100,0));
        double result3=SILab2.checkCart(items3,"1234567890123456");
        assertEquals(500,result3);
//7-8-9-10
        List<Item> items5= List.of(new Item("Item3",3,100,0.2));
        double result5=SILab2.checkCart(items5,"1234567890123456");
        assertEquals(210,result5);

        RuntimeException ex6 = assertThrows(RuntimeException.class, () -> {
            List<Item> items= List.of(new Item("Item",1,100,0));
            SILab2.checkCart(items,"1234");});
        assertTrue(ex6.getMessage().contains("Invalid card number!"));

        RuntimeException ex7 = assertThrows(RuntimeException.class, () -> {
            List<Item> items= List.of(new Item("Item",1,100,0));
            SILab2.checkCart(items,"123456789012345X");});
        assertTrue(ex7.getMessage().contains("Invalid character in card number!"));
    }

    @Test
    void multipleConditionTest(){
        // (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)
        //TXX 350 X X
        //FTX 200 0.2 X
        //FFT 100 0 15
        //FFF 100 0 5
        List<Item> items1= List.of(new Item("Item1",2,350,0));
        double result1=SILab2.checkCart(items1,"1234567890123456");
        assertEquals(670, result1);

        List<Item> items2= List.of(new Item("Item2",2,200,0.2));
        double result2=SILab2.checkCart(items2,"1234567890123456");
        assertEquals(290, result2);

        List<Item> items3= List.of(new Item("Item3",15,100,0));
        double result3=SILab2.checkCart(items3,"1234567890123456");
        assertEquals(1470, result3);

        List<Item> items4= List.of(new Item("Item4",5,100,0));
        double result4=SILab2.checkCart(items4,"1234567890123456");
        assertEquals(500, result4);
    }
}