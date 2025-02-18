import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvInvoiceGenerator implements InvoiceGenerator{
    @Override
    public void generateInvoice(Order order, ContainerPricingPolicy pricingPolicy) {
        String filename="invoice.csv";

        try(BufferedWriter writer=new BufferedWriter(new FileWriter(filename))){
            writer.write("Ingredients,Amount,Price\n");

            for (var entry : order.getFlavors().entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "," + (entry.getKey().getPricePerScoop() * entry.getValue()) + "\n");
            }
            for (var entry : order.getToppings().entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "," + (entry.getKey().getPrice() * entry.getValue()) + "\n");
            }


            writer.write("Subtotal,-," + String.format("%.2f", OrderPriceCalculator.calculateSubTotalPrice(order,pricingPolicy)) + "\n");
            writer.write("Tax,-," + String.format("%.2f", OrderPriceCalculator.calculateTax(order,pricingPolicy)) + "\n");
            writer.write("Total Amount Due,-," + String.format("%.2f", OrderPriceCalculator.calculateTotalPrice(order,pricingPolicy)) + "\n");

            System.out.println("Invoice saved as invoice.csv");

        } catch (IOException e) {
            System.out.println("Error generating invoice.");
        }

    }
}
