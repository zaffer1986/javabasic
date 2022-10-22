public class Cat1 extends Animal implements IAnimal {
    public Cat1(String name, String color, int age) {

        super(name, color, age);
    }
        @Override
        public String voice() {

        return "miaw";
        }
}
