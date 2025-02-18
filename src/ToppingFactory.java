public class ToppingFactory {
    public static YogurtTopping getTopping(String type){
        switch (type.toLowerCase()){
            case "sprinkles":
                return new Sprinkles();
            case "mixed chopped nuts":
                return new MixedChoppedNuts();
            case "crushed gingerbread":
                return new CrushedGingerbread();
            case "fresh strawberries":
                return new FreshStrawberries();
            default:
                throw new IllegalArgumentException("Sorry,This topping doesn't exist.");
        }
    }
}
