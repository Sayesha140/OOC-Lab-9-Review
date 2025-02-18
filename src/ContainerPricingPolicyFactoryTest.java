import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContainerPricingPolicyFactoryTest {

    @Test
    void testGetContainerPrice_ValidContainers() {

        ContainerPricingPolicy glassJar = ContainerPricingPolicyFactory.getContainerPrice(1);
        assertNotNull(glassJar);
        assertTrue(glassJar instanceof GlassJarPricing);
        assertEquals(5.00, glassJar.getPrice(), 0.01);


        ContainerPricingPolicy paperCup = ContainerPricingPolicyFactory.getContainerPrice(2);
        assertNotNull(paperCup);
        assertTrue(paperCup instanceof PaperCupPricing);
        assertEquals(0.00, paperCup.getPrice(), 0.01);
    }

    @Test
    void testGetContainerPrice_InvalidContainer() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ContainerPricingPolicyFactory.getContainerPrice(3);
        });

        assertEquals("Invalid container type.", exception.getMessage());
    }
}
