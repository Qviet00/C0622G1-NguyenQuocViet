package ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Model;

import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller.Animal;
import ss_7_Abstract_Class_Interface.ss_1_practice_java.Post1.Controller.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "Could be fried";
    }
}

