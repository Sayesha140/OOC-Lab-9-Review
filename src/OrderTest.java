import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;

class OrderTest {
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testAddFlavor() {
        YogurtFlavour chocolate = new ChocolateFudge();
        YogurtFlavour pistachio = new PistachioDelight();


        order.addFlavor(chocolate, 2);
        assertEquals(2, order.getFlavors().get(chocolate));


        order.addFlavor(chocolate, 3);
        assertEquals(5, order.getFlavors().get(chocolate));


        order.addFlavor(pistachio, 1);
        assertEquals(1, order.getFlavors().get(pistachio));


        assertEquals(2, order.getFlavors().size());
    }

    @Test
    void testAddToppings() {
        YogurtTopping sprinkles = new Sprinkles();
        YogurtTopping nuts = new MixedChoppedNuts();


        order.addToppings(sprinkles, 1);
        assertEquals(1, order.getToppings().get(sprinkles));


        order.addToppings(sprinkles, 2);
        assertEquals(3, order.getToppings().get(sprinkles));


        order.addToppings(nuts, 1);
        assertEquals(1, order.getToppings().get(nuts));


        assertEquals(2, order.getToppings().size());
    }


}
