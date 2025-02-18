import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderPriceCalculatorTest {
    private Order order;
    private ContainerPricingPolicy glassJarPricing;
    private ContainerPricingPolicy paperCupPricing;

    @BeforeEach
    void setUp() {
        order = new Order();
        glassJarPricing = new GlassJarPricing();
        paperCupPricing = new PaperCupPricing();
    }

    @Test
    void testCalculateSubTotalPrice() {
        YogurtFlavour chocolate = new ChocolateFudge();
        YogurtFlavour pistachio = new PistachioDelight();
        YogurtTopping sprinkles = new Sprinkles();

        order.addFlavor(chocolate, 2);
        order.addFlavor(pistachio, 1);
        order.addToppings(sprinkles, 2);


        double expectedTotalGlass = 5.00 + 6.00 + 3.25 + 0.60;
        assertEquals(expectedTotalGlass, OrderPriceCalculator.calculateSubTotalPrice(order, glassJarPricing), 0.01);


        double expectedTotalPaper = 0.00 + 6.00 + 3.25 + 0.60;
        assertEquals(expectedTotalPaper, OrderPriceCalculator.calculateSubTotalPrice(order, paperCupPricing), 0.01);
    }

    @Test
    void testCalculateTax() {
        order.addFlavor(new ChocolateFudge(), 1);
        order.addToppings(new Sprinkles(), 1);

        double subtotal = 5.00 + 3.00 + 0.30;
        double expectedTax = subtotal * 0.08;
        assertEquals(expectedTax, OrderPriceCalculator.calculateTax(order, glassJarPricing), 0.01);
    }

    @Test
    void testCalculateTotalPrice() {
        order.addFlavor(new ChocolateFudge(), 1);
        order.addToppings(new Sprinkles(), 1);

        double subtotal = 5.00 + 3.00 + 0.30;
        double tax = subtotal * 0.08;
        double expectedTotal = subtotal + tax;

        assertEquals(expectedTotal, OrderPriceCalculator.calculateTotalPrice(order, glassJarPricing), 0.01);
    }
}
