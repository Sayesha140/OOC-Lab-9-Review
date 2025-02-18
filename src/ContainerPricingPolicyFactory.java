public class ContainerPricingPolicyFactory {
    public static ContainerPricingPolicy getContainerPrice(String containerType){
        switch (containerType.toLowerCase()){

            case "glass jar":
                return new GlassJarPricing();

            case "paper cup":
                return new PaperCupPricing();

            default:
                return null;
        }
    }
}
