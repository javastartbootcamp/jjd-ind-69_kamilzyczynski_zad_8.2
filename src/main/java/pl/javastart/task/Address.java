package pl.javastart.task;

import java.util.Scanner;

public class Address {
    private String place;
    private String city;
    private String street;
    private String homeNumber;

    public Address() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj arenę wydarzenia:");
        this.place = scanner.nextLine();
        System.out.println("Podaj miasto, w którym odbędzie się wydarzenie:");
        this.city = scanner.nextLine();
        System.out.println("Podaj ulicę, na której odbędzie się wydarzenie:");
        this.street = scanner.nextLine();
        System.out.println("Podaj numer budynku, w którym odbędzie się wydarzenie:");
        this.homeNumber = scanner.nextLine();
    }

    public String getPlace() {
        return place;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }
}
