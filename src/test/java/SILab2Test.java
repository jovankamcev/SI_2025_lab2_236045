package test.java;

import main.java.Item;
import main.java.SILab2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private double checkItems(List<Item> items, String cardNumber) {
        return SILab2.checkCart(items, cardNumber);
    }

    // Тестирање според Every Statement критериум
    @Test
    void testEveryStatement() {
        // 1. Листата е null
        RuntimeException ex1 = assertThrows(RuntimeException.class, () ->
                checkItems(null, "1234567890123456"));
        assertEquals("allItems list can't be null!", ex1.getMessage());

        // 2. Предмет со празно име
        List<Item> items2 = List.of(new Item("", 1, 100, 0));
        RuntimeException ex2 = assertThrows(RuntimeException.class, () ->
                checkItems(items2, "1234567890123456"));
        assertEquals("Invalid item!", ex2.getMessage());

        // 3. Невалидна картичка (помалку од 16 цифри)
        List<Item> items3 = List.of(new Item("Item", 1, 100, 0));
        RuntimeException ex3 = assertThrows(RuntimeException.class, () ->
                checkItems(items3, "1234"));
        assertEquals("Invalid card number!", ex3.getMessage());

        // 4. Предмет со цена > 300 без попуст
        List<Item> items4 = List.of(new Item("Item", 2, 400, 0));
        assertEquals(770.0, checkItems(items4, "1234567890123456")); // 400*2 = 800 - 30 = 770

        // 5. Предмет со попуст
        List<Item> items5 = List.of(new Item("Item", 1, 100, 0.2));
        assertEquals(80.0, checkItems(items5, "1234567890123456")); // 100 * 0.8 = 80

        // 6. Валиден предмет и картичка
        List<Item> items6 = List.of(new Item("Item", 1, 200, 0));
        assertEquals(200.0, checkItems(items6, "1234567890123456"));

        // 7. Картичка со недозволени знаци
        List<Item> items7 = List.of(new Item("Item", 1, 100, 0));
        RuntimeException ex7 = assertThrows(RuntimeException.class, () ->
                checkItems(items7, "12345678901234AB"));
        assertEquals("Invalid character in card number!", ex7.getMessage());
    }

    // Тестирање според Multiple Condition критериум
    @Test
    void testMultipleCondition() {
        String validCard = "1234567890123456";

        // F F F - ниеден услов не е исполнет
        List<Item> items1 = List.of(new Item("Item", 1, 100, 0));
        assertEquals(100.0, checkItems(items1, validCard));

        // F F T - quantity > 10
        List<Item> items2 = List.of(new Item("Item", 11, 100, 0));
        assertEquals(1070.0, checkItems(items2, validCard)); // 100*11 - 30

        // F T F - discount > 0
        List<Item> items3 = List.of(new Item("Item", 1, 100, 0.1));
        assertEquals(60.0, checkItems(items3, validCard)); // 100*0.9 - 30

        // T F F - price > 300
        List<Item> items4 = List.of(new Item("Item", 1, 400, 0));
        assertEquals(370.0, checkItems(items4, validCard)); // 400 - 30

        // T T T - сите услови се точни
        List<Item> items5 = List.of(new Item("Item", 11, 500, 0.2));
        assertEquals(4370.0, checkItems(items5, validCard)); // 500*0.8*11 - 30
    }
}
