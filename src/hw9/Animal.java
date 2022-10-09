 public class Animal {
     protected String name;
     protected String color;
     protected int age;

     public Animal(String name, String color, int age) {
         this.name = name;
         this.color = color;
         this.age = age;
     }

     @Override
     public String toString() {
         return "" +
                 "name='" + name + '\'' +
                 ", color='" + color + '\'' +
                 ", age=" + age +
                 '}';
     }
 }




