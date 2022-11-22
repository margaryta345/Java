public class Sofa extends furniture{

    private int backrestheight;

    public Sofa(String manufacturer, int price, String material) {
        super(manufacturer, price, material);
    }

    public Sofa(String manufacturer, int price, String material, int backrestheight) {
        super(manufacturer, price, material);
        this.backrestheight = backrestheight;
    }

    public Sofa(int price, String material, int backrestheight) {
        super(material, price, material);
        this.backrestheight = backrestheight;
    }

    public int getBackrestheight() {
        return backrestheight;
    }
}