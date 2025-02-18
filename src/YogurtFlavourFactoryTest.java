import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class YogurtFlavourFactoryTest {

    @Test
    void testGetYogurtFlavour_ValidFlavors() {

        YogurtFlavour chocolate = YogurtFlavourFactory.getYogurtFlavour(1);
        assertNotNull(chocolate);
        assertEquals("Chocolate Fudge", chocolate.getName());
        assertEquals(3.00, chocolate.getPricePerScoop(), 0.01);


        YogurtFlavour cookies = YogurtFlavourFactory.getYogurtFlavour(2);
        assertNotNull(cookies);
        assertEquals("Cookies & Cream", cookies.getName());
        assertEquals(2.80, cookies.getPricePerScoop(), 0.01);


        YogurtFlavour pistachio = YogurtFlavourFactory.getYogurtFlavour(3);
        assertNotNull(pistachio);
        assertEquals("Pistachio Delight", pistachio.getName());
        assertEquals(3.25, pistachio.getPricePerScoop(), 0.01);
    }

    @Test
    void testGetYogurtFlavour_InvalidFlavour() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            YogurtFlavourFactory.getYogurtFlavour(5); // Invalid flavor
        });

        assertEquals("Sorry,This flavour doesn't exist.", exception.getMessage());
    }
}
