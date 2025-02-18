public class YogurtFlavourFactory {
    public static YogurtFlavour getYogurtFlavour(int type){
        switch (type){
            case 1:
                return new ChocolateFudge();
            case 2:
                return new CookiesAndCream();
            case 3:
                return new PistachioDelight();
            default:
                throw new IllegalArgumentException("Sorry,This flavour doesn't exist.");
        }
    }
}
