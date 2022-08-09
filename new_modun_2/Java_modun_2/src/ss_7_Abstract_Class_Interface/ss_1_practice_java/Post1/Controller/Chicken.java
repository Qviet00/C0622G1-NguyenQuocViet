package ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller;

import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller.Animal;

public class Chicken extends Animal {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck";
    }
}
