import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ToppingFactoryTest {

    @Test
    void testGetTopping_ValidToppings() {

        YogurtTopping sprinkles = ToppingFactory.getTopping(1);
        assertNotNull(sprinkles);
        assertEquals("Sprinkles", sprinkles.getName());
        assertEquals(0.30, sprinkles.getPrice(), 0.01);


        YogurtTopping nuts = ToppingFactory.getTopping(2);
        assertNotNull(nuts);
        assertEquals("Mixed Chopped Nuts", nuts.getName());
        assertEquals(0.80, nuts.getPrice(), 0.01);


        YogurtTopping gingerbread = ToppingFactory.getTopping(3);
        assertNotNull(gingerbread);
        assertEquals("Crushed Gingerbread", gingerbread.getName());
        assertEquals(0.75, gingerbread.getPrice(), 0.01);


        YogurtTopping strawberries = ToppingFactory.getTopping(4);
        assertNotNull(strawberries);
        assertEquals("Fresh Strawberries", strawberries.getName());
        assertEquals(1.00, strawberries.getPrice(), 0.01);
    }

    @Test
    void testGetTopping_InvalidTopping() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ToppingFactory.getTopping(5);
        });

        assertEquals("Sorry,This topping doesn't exist.", exception.getMessage());
    }
}
