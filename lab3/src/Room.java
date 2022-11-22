public  class Room {
    private String name;
    private int height;
    private int weight;



    public Room(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    furniture furniture1 = new Sofa("Пані буба",5000,"Льон",50);
    furniture furniture2 = new Sofa("Епіцентр",4050,"Шерсть",100);
    furniture wardrobe1 = new Wardrobe("Епіцентр",2305,"Дуб",54,10,100);

}

