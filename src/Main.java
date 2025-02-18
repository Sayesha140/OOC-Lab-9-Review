import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        Order order=new Order();

        System.out.println("Welcome to the Yogurt Shop!");

        do {

            System.out.println("Choose a yogurt flavor: 1. Chocolate Fudge, 2. Cookies & Cream, 3. Pistachio Delight : ");
            int choice=scanner.nextInt();

            if(choice<1 || choice>3){
                System.out.println("Invalid choice. Try again!");
                continue;
            }
            YogurtFlavour flavour=YogurtFlavourFactory.getYogurtFlavour(choice);

            System.out.println("How many scoops? ");
            int scoops= scanner.nextInt();
            scanner.nextLine();
            order.addFlavor(flavour,scoops);

            System.out.print("Would you like to add another flavor? (Y/N): ");


        }while (scanner.nextLine().equalsIgnoreCase("Y"));


    }
}