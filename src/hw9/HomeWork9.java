/**
 *Java basic: HomeWork9
 *
 @author Muzaffar Eshonqulov
 @todo 05.10.2022
 @date 9.10.2022
 *
 */
public class HomeWork9 {
    public static void main(String[] args) {
        Cat1 cat = new Cat1("Moshon", "white", 2);
        //System.out.println(cat);
        //System.out.println(cat.voice());
        Dog dog = new Dog("Julbars", "black", 2);
        //System.out.println(dog);
        //System.out.println(dog.voice());
        IAnimal[] animals= {cat, dog};
                for(IAnimal animal : animals){
                    System.out.println(animal);
                    System.out.println(animal.voice());
                }
    }
}
