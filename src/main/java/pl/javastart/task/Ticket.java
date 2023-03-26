package pl.javastart.task;

import java.util.Scanner;

public class Ticket {
    public static final String TYPE_ONLINE = "online";
    public static final String TYPE_STANDARD = "standard";
    public static final String TYPE_GIFT = "gift";
    private String event;
    private Address address;
    private String category;
    private double regularPrice;
    private double discount;
    private int ticketNumber;
    private static int counter;

    public Ticket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wydarzenie na które chcesz kupić bilet:");
        this.event = scanner.nextLine();

        this.address = new Address();

        System.out.printf("Podaj kategorię biletu, który chcesz kupić: %s, %s czy %s\n", TYPE_ONLINE, TYPE_STANDARD,
                TYPE_GIFT);
        this.category = scanner.nextLine();

        System.out.println("Podaj cenę biletu:");
        this.regularPrice = scanner.nextDouble();

        System.out.println("Podaj wysokość zniżki: (przedział 0-1)");
        this.discount = scanner.nextDouble();

        counter++;
        this.ticketNumber = counter;
    }

    private double calculatePrice() {

        switch (category.toLowerCase()) {
            case TYPE_ONLINE -> {
                return regularPriceWithDiscount();
            }
            case TYPE_STANDARD -> {
                return standardPrice();
            }
            case TYPE_GIFT -> {
                return giftPrice();
            }
            default -> {
                System.out.println("Podano błędną kategorię");
                return 0;
            }
        }
    }

    private double giftPrice() {
        return standardPrice() + (regularPriceWithDiscount() * discount);
    }

    private double standardPrice() {
        return regularPriceWithDiscount() + 5;
    }

    private double regularPriceWithDiscount() {
        return regularPrice * (1 - discount);
    }

    void showTicketInfo() {
        System.out.printf("Wydarzenie: %s\nArena wydarzenia: %s\nMiasto: %s\nUlica: %s\nNumer: %s\n",
                event, address.getPlace(), address.getCity(), address.getStreet(), address.getHomeNumber());
        System.out.printf("Bilet numer: %d\n", ticketNumber);
        System.out.printf("Bilet %s: cena podstawowa %.0fzł, zniżka %.0f%%, cena finalna wyniesie %.2fzł\n",
                        category, regularPrice, (discount * 100), calculatePrice());
    }
}
