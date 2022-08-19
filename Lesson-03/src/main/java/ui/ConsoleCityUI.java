package ui;

import entity.City;

import java.util.Scanner;

public class ConsoleCityUI implements CityUI {
    private final Scanner scanner;

    public ConsoleCityUI(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public City readCity() {
        return new City(scanner.nextLine());
    }

    @Override
    public void print(City city) {
        System.out.println(
                "ID " +
                        city.getId() +
                        " " +
                        "City " +
                        city.getName());
    }

    @Override
    public String stringRequest() {
        printMessage("Enter chars for search");
        return String.format("%s", scanner.nextLine());
    }

    @Override
    public int intRequest() {
        int choice = 0;
        try {
            String s = stringRequest();
            choice = Integer.parseInt(s);
        } catch (Exception e) {
            printMessage("Incorrect, enter another");
            intRequest();
        }
        return choice;
    }

    @Override
    public void printMessage(String s) {
        System.out.println(s);

    }
}
