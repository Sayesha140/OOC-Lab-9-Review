import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private final Map<YogurtFlavour, Integer> flavors = new HashMap<>();
    private final Map<YogurtTopping,Integer> toppings = new HashMap<>();

    public Order(){

    }

    public void addToppings(YogurtTopping topping,int quantity){
        toppings.put(topping, toppings.getOrDefault(topping, 0) + quantity);
    }

    public void addFlavor(YogurtFlavour flavor, int scoops) {
        flavors.put(flavor, flavors.getOrDefault(flavor, 0) + scoops);
    }

    public Map<YogurtTopping, Integer> getToppings() {
        return toppings;
    }

    public Map<YogurtFlavour, Integer> getFlavors() {
        return flavors;
    }
}
