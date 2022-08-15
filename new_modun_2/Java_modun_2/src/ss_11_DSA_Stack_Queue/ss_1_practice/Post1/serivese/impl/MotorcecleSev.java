package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.serivese.impl;

import ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model.Motorcycle;
import ss_11_DSA_Stack_Queue.ss_1_practice.Post1.serivese.IsMotorcycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MotorcecleSev implements IsMotorcycle {
    private final Scanner src = new Scanner(System.in);
    private static final List<Motorcycle> motorcycles = new ArrayList<>();

    @Override
    public void displayMotorcycle() {
        for (Motorcycle motorcycle : motorcycles
        ) {
            System.out.println(motorcycle);
        }

    }

    @Override
    public void addMotorcycle() {
        Motorcycle motorcycle = this.infoMotorcycle();
        motorcycles.add(motorcycle);
        System.out.println("Add Truck ok");
        for (Motorcycle motorcycleOne : motorcycles
        ) {
            System.out.println(motorcycleOne);
        }

    }

    @Override
    public void removeMotorcycle() {
        Motorcycle motorcycle = this.findMotorcycle();
        if (motorcycle == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Delete ok  " + motorcycle.getLicensePlate());
            System.out.println("1 .OK");
            System.out.println("2 .Cancel");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                motorcycles.remove(motorcycle);
                System.out.println("Delete ok");
            }
        }

    }

    private Motorcycle findMotorcycle() {
        System.out.print("Enter licensePlate delete: ");
        String licensePlate = src.nextLine();
        for (Motorcycle motorcycleOne : motorcycles) {
            if (Objects.equals(motorcycleOne.getLicensePlate(), licensePlate)) {
                return motorcycleOne;
            }
        }
        return null;
    }

    public Motorcycle infoMotorcycle() {
        System.out.print("Enter licensePlate: ");
        String licensePlate = src.nextLine();
        System.out.print("Enter namecompany: ");
        String nameCompany = src.nextLine();
        System.out.print("Enter yearManufacture: ");
        int yearManufacture = Integer.parseInt(src.nextLine());
        System.out.print("Enter owner: ");
        String owner = src.nextLine();
        System.out.print("Enter wattage: ");
        int wattage = Integer.parseInt(src.nextLine());

        return new Motorcycle(licensePlate, nameCompany, yearManufacture, owner, wattage);
    }
}
