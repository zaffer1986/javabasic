public class Dog extends Animal implements IAnimal {
    public Dog(String name, String color, int age) {
        super(name, color, age);

    }
        @Override
        public String voice() {
            return "gav-gav";
        }
}
