public abstract class YogurtFlavour {
    private String name;
    private double pricePerScoop;

    public YogurtFlavour(String name,double pricePerScoop){
        this.name=name;
        this.pricePerScoop=pricePerScoop;
    }

    public String getName() {
        return name;
    }

    public double getPricePerScoop() {
        return pricePerScoop;
    }
}
