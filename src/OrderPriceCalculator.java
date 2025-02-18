public class OrderPriceCalculator {
    private static final double TAX_RATE=0.08;


    public static double calculateSubTotalPrice(Order order,ContainerPricingPolicy pricingPolicy){

        double total=pricingPolicy.getPrice();

        for (var entry : order.getFlavors().entrySet()) {
            total += entry.getKey().getPricePerScoop() * entry.getValue();
        }

        for (var entry : order.getToppings().entrySet()) {
            total += entry.getKey().getPrice()* entry.getValue();
        }

        return total;

    }

    public static double calculateTax(Order order,ContainerPricingPolicy pricingPolicy){
        return calculateSubTotalPrice(order,pricingPolicy)*TAX_RATE;
    }

    public static double calculateTotalPrice(Order order,ContainerPricingPolicy pricingPolicy){
        return calculateSubTotalPrice(order,pricingPolicy)+calculateTax(order,pricingPolicy);
    }
}
