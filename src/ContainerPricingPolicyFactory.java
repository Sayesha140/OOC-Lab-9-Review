public class ContainerPricingPolicyFactory {
    public static ContainerPricingPolicy getContainerPrice(int containerType){
        switch (containerType){

            case 1:
                return new GlassJarPricing();

            case 2:
                return new PaperCupPricing();

            default:
                throw new IllegalArgumentException("Invalid container type.");
        }
    }
}
