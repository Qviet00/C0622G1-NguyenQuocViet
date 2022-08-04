package ss_4_class_and_oject_in_java.ss_2_exercise_java.Post1;

public class QuadraticEquation {
        double a, b, c, dellta;

                public QuadraticEquation(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminant() {
            return dellta = this.b * this.b - (4 * this.a * this.c);
        }

        public double valuaOne() {
            return this.c / this.b;
        }

        public double valueFout() {
            return -this.b / (2 * this.a);
        }

        public double valueTwo() {
            return (-this.b * this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
        }

        public double valueThere() {
            return (-this.b * this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
        }
    }

