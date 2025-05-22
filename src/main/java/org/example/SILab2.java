package org.example;

import java.util.List;

class Item {
    String name;
    int quantity; //numerical
    int price;
    double discount;

    public Item(String name, int quantity, int price, double discount) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}


public class SILab2 {
    public static double checkCart(List<Item> allItems, String cardNumber) {
        if (allItems == null) { // 1
            throw new RuntimeException("allItems list can't be null!"); // 2
        }

        double sum = 0; // 3

        for (int i = 0; i < allItems.size(); i++) { // 4
            Item item = allItems.get(i);
            if (item.getName() == null || item.getName().length() == 0) { // 5
                throw new RuntimeException("Invalid item!"); // 6
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10) { // 7
                sum -= 30; // 8
            }

            if (item.getDiscount() > 0) { // 9
                sum += item.getPrice() * (1 - item.getDiscount()) * item.getQuantity(); // 10
            } else {
                sum += item.getPrice() * item.getQuantity(); // 11
            }

        } // 12
        if (cardNumber != null && cardNumber.length() == 16) { // 13
            String allowed = "0123456789";
            char[] chars = cardNumber.toCharArray(); // 14
            for (int j = 0; j < cardNumber.length(); j++) { // 15
                char c = cardNumber.charAt(j);
                if (allowed.indexOf(c) == -1) { // 16
                    throw new RuntimeException("Invalid character in card number!"); // 17
                }
            } // 18
        } else {
            throw new RuntimeException("Invalid card number!"); // 19
        }

        return sum; // 20

    } // 21
}