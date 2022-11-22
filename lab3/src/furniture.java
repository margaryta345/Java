public abstract class furniture {

    private String manufacturer;
    private int price;
    private String material;

    public furniture(String manufacturer, int price, String material) {
        this.manufacturer = manufacturer;/*Іноді в класі Java необхідно звернутися до поточного екземпляру даного класу, який
        в даний момент обробляється методом конструктор*/
        this.price = price;
        this.material = material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getMaterial() {
        return material;
    }

    public int getPrice() {
        return price;
    }

}