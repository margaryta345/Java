import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<furniture> people = new ArrayList<furniture>();
        furniture furniture = new Sofa("Пані буба", 5000, "Льон");
        System.out.println("Производитель: " + furniture.getManufacturer() + " Стоймость: " + furniture.getPrice() + " Материал: " + furniture.getMaterial());
        Room r1=new Room("ri",30,40);
        furniture furniture1 = new Sofa("Пані буба",5000,"Льон",50);
        furniture furniture2 = new Sofa("Епіцентр",4050,"Шерсть",100);
        furniture wardrobe1 = new Wardrobe("Епіцентр",2305,"Дуб",54,10,100);
        furniture wardrobe2 = new Wardrobe("Епіцентр",24055,"Дуб",54,10,100);
        people.add(furniture1);
        people.add(furniture2);
        people.add(wardrobe1);
        people.add(wardrobe2);


            int c = 0;
            int b=0;
            for(int i = 0; i < people.size(); i++) {
                if (people.get(i) instanceof Sofa) {
                    c++;
                }
                 else {
                    b++;
                }
            }
        System.out.println("Кількість диванів - "+c);
        System.out.println("Кількість шкафів - "+b);
}
    }