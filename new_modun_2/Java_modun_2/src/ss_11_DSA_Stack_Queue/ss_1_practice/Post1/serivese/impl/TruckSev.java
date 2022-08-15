package ss_11_DSA_Stack_Queue.ss_1_practice.Post1.serivese.impl;

import ss_11_DSA_Stack_Queue.ss_1_practice.Post1.model.Truck;
import ss_11_DSA_Stack_Queue.ss_1_practice.Post1.serivese.IsTruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TruckSev implements IsTruck {
    private final Scanner src = new Scanner(System.in);
    private static final List<Truck> trucks = new ArrayList<>();

    @Override
    public void displayTruck() {
        for (Truck truckOne : trucks
        ) {
            System.out.println(truckOne);
        }
    }

    @Override
    public void addTruck() {
        Truck truck1 = this.infoTruck();
        trucks.add(truck1);
        System.out.println("Add Truck ok");
        for (Truck truckOne : trucks
        ) {
            System.out.println(truckOne);
        }

    }

    @Override
    public void removeTruck() {
        Truck truck = this.findTruck();
        if (truck == null) {
            System.out.println("Not found");
        } else {
            System.out.println("Delete ok  " + truck.getLicensePlate());
            System.out.println("1 .OK");
            System.out.println("2 .Cancel");
            int choice = Integer.parseInt(src.nextLine());
            if (choice == 1) {
                trucks.remove(truck);
                System.out.println("Delete ok");
            }
        }

    }

    public Truck infoTruck() {
        System.out.print("Enter licensePlate: ");
        String licensePlate = src.nextLine();
        System.out.print("Enter namecompany: ");
        String nameCompany = src.nextLine();
        System.out.print("Enter yearManufacture: ");
        int yearManufacture = Integer.parseInt(src.nextLine());
        System.out.print("Enter owner: ");
        String owner = src.nextLine();
        System.out.print("Enter tonnage: ");
        int tonnage = Integer.parseInt(src.nextLine());

        return new Truck(licensePlate, nameCompany, yearManufacture, owner, tonnage);

    }
    public Truck findTruck(){
        System.out.print("Enter licensePlate delete: ");
        String licensePlate = src.nextLine();
        for (Truck truck : trucks) {
            if (Objects.equals(truck.getLicensePlate(), licensePlate)) {
                return truck;
            }
        }
        return null;
    }
}
