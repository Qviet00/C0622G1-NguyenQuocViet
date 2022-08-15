package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.serivese.impl;

import ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model.Car;
import ss_11_DSA_Stack_Queue.ss_1_practice.Post1.serivese.IsCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CarSev implements IsCar {
    private final Scanner src = new Scanner(System.in);
    private static final List<Car> cars = new ArrayList<>();

    private Car infoCar() {
        System.out.print("Enter licensePlate: ");
        String licensePlate = src.nextLine();
        System.out.print("Enter namecompany: ");
        String nameCompany = src.nextLine();
        System.out.print("Enter yearManufacture: ");
        int yearManufacture = Integer.parseInt(src.nextLine());
        System.out.print("Enter owner: ");
        String owner = src.nextLine();
        System.out.print("Enter seat: ");
        int seat = Integer.parseInt(src.nextLine());
        System.out.print("Enter shape: ");
        String shape = src.nextLine();
        return new Car(licensePlate, nameCompany, yearManufacture, owner, seat, shape);

    }

    public void addCar() {
        Car car = this.infoCar();
        cars.add(car);
        System.out.println("Add car ok");
        for (Car carOne : cars
        ) {
            System.out.println(carOne);
        }
    }


    public void displayCar() {
        for (Car carOne : cars
        ) {
            System.out.println(carOne);
        }
    }

    public void removeCar() {
        Car car = this.findCar();
        if (car == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Delete ok  " + car.getLicensePlate());
            System.out.println("1 .OK");
            System.out.println("2 .Cancel");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                cars.remove(car);
                System.out.println("Delete ok");
            }
        }
    }

    private Car findCar() {
        System.out.print("Enter licensePlate delete: ");
        String licensePlate = src.nextLine();
        for (Car car : cars) {
            if (Objects.equals(car.getLicensePlate(), licensePlate)) {
                return car;
            }
        }
        return null;
    }


}