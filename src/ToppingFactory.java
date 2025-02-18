public class ToppingFactory {
    public static YogurtTopping getTopping(int type){
        switch (type){
            case 1:
                return new Sprinkles();
            case 2:
                return new MixedChoppedNuts();
            case 3:
                return new CrushedGingerbread();
            case 4:
                return new FreshStrawberries();
            default:
                throw new IllegalArgumentException("Sorry,This topping doesn't exist.");
        }
    }
}
