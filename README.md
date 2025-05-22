# SI_2025_lab2_233196

## Control flow graph
![lab2 cfg](https://github.com/user-attachments/assets/9b6b6189-4df4-46c5-b1e9-481c4b862dc1)

## Цикломатска комплексност
Цикломатската комплексност е 9
Предикатни јазли (P) = 8
P + 1 = 8 + 1 = 9
Ребра (E) = 32
Јазли (N) = 25
E - N + 2
32 - 25 + 2 = 9

## Тест случаи според критериумот Every statement
Минимален број на тестови за да се постигне Every Statement критериумот е 6.
Има 4 тестови за throw runtime exception и два за да се измини if/else изразот if (item.getDiscount() > 0)

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

## Тест случаи според критериумот Multiple Condition
Минимален број на тестови за да се постигне Multiple Condition за условот if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10) е 4.
Четирите тестови со следните исходи: TXX, FTX, FFT, FFF.

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
