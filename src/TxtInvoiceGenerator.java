import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtInvoiceGenerator implements InvoiceGenerator{
    @Override
    public void generateInvoice(Order order,ContainerPricingPolicy pricingPolicy) {
        String filename="invoice.txt";

        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filename))){

            writer.write("Yogurt Shop Invoice\n");

            for (var entry : order.getFlavors().entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + " scoop(s): $"
                        + String.format("%.2f", entry.getKey().getPricePerScoop() * entry.getValue()) + "\n");
            }


            for (var entry : order.getToppings().entrySet()) {
                writer.write(entry.getKey() + " - " + entry.getValue() + " times: $"
                        + String.format("%.2f", entry.getKey().getPrice() * entry.getValue()) + "\n");
            }


            writer.write("Subtotal: $" + String.format("%.2f", OrderPriceCalculator.calculateSubTotalPrice(order,pricingPolicy)) + "\n");
            writer.write("Tax: $" + String.format("%.2f", OrderPriceCalculator.calculateTax(order,pricingPolicy)) + "\n");
            writer.write("Total Amount Due: $" + String.format("%.2f", OrderPriceCalculator.calculateTotalPrice(order,pricingPolicy)) + "\n");

            System.out.println("Invoice saved as invoice.txt");


        } catch (IOException e) {
            System.out.println("Error generating invoice.");
        }

    }
}
