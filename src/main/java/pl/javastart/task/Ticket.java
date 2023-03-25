package pl.javastart.task;

import java.util.Scanner;

public class Ticket {
    String event;
    Address address;
    String category;
    double regularPrice;
    double discount;
    int ticketNumber;
    private static int counter;

    public Ticket(String event, String category) {
        this.event = event;
        this.category = category;
        counter++;
        this.ticketNumber = counter;

        if (event.toLowerCase().equals("ksw")) {
            this.address = new Address("Gdynia Arena", "Gdynia", "ul. Kazimierza Górskiego",
                    "10A");
        }
        if (event.toLowerCase().equals("koncert dżemu")) {
            this.address = new Address("Ergo Arena", "Gdańsk", "ul. Plac Dwóch Miast",
                     "2");
        }
        calculatePrice();
    }

    static Ticket buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wydarzenie na które chcesz kupić bilet: KSW czy Koncert Dżemu?");
        String userEvent = scanner.nextLine();

        System.out.println("Podaj kategorię biletu, który chcesz kupić: online, standard czy gift");
        String userCategory = scanner.nextLine();

        return new Ticket(userEvent, userCategory);
    }

    private double calculatePrice() {

        switch (category.toLowerCase()) {
            case "online" -> {
                regularPrice = 100;
                discount = 0.05;
                return regularPrice * (1 - discount);
            }
            case "standard" -> {
                regularPrice = 100;
                discount = 0.05;
                return regularPrice * (1 - discount) + 5;
            }
            case "gift" -> {
                regularPrice = 100;
                discount = 0.05;
                return regularPrice * (1 - discount) + 5 + ((regularPrice * (1 - discount)) * discount);
            }
            default -> {
                System.out.println("Podano błędną kategorię");
                return 0;
            }
        }
    }

    void showTicketInfo() {
        switch (category.toLowerCase()) {
            case "online":
                System.out.printf("Bilet Online: cena podstawowa %.0fzł, zniżka %.0f%%, cena finalna wyniesie %.0fzł",
                        regularPrice, (discount * 100), calculatePrice());
                System.out.println();
                break;
            case "standard":
                System.out.printf("Bilet Standard: cena podstawowa %.0fzł, zniżka %.0f%%, cena finalna wyniesie %.0fzł",
                        regularPrice, (discount * 100), calculatePrice());
                System.out.println();
                break;
            case "gift":
                System.out.printf("Bilet Gift: cena podstawowa %.0fzł, zniżka %.0f%%, cena finalna wyniesie %.2fzł",
                        regularPrice, (discount * 100), calculatePrice());
                System.out.println();
                break;
        }
    }
}
