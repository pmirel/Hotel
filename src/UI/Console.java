package UI;

import Domain.Room;
import Domain.RoomAverageRating;
import Service.RoomService;

import java.util.Scanner;

public class Console {

    private RoomService service;
    private Scanner scanner;

    public Console(RoomService service) {
        this.service = service;
        scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Check-in");
        System.out.println("2. Check-out");
        System.out.println("3. Rating-ul pe camera");
        System.out.println("a. Afisare toate camerele");
        System.out.println("x. Iesire");
    }

    public void run() {

        while (true) {
            showMenu();
            String option = scanner.nextLine();
            if (option.equals("1")) {
                handleRoomEntry();
            } else if (option.equals("2")) {
                handleRoomExit();
            } else if (option.equals("3")) {
                handleRoomReport();
            } else if (option.equals("a")) {
                handleShowAll();
            } else if (option.equals("x")) {
                break;
            }
        }
    }

    private void handleRoomReport() {
        for (RoomAverageRating roomAverage : service.getRoomRatingAverages())
            System.out.println(roomAverage);
    }

    private void handleRoomExit() {
        try {
            System.out.println("Dati camera:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati feedback-ul:");
            String feedback = scanner.nextLine();
            System.out.println("Dati ratingul:");
            int rating = Integer.parseInt(scanner.nextLine());

            service.checkOut(roomNumber, feedback, rating);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }

    private void handleShowAll() {
        for (Room r : service.getAll())
            System.out.println(r);
    }

    private void handleRoomEntry() {

        try {
            System.out.println("Dati id-ul:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati standul:");
            int roomNumber = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de inmatriculare:");
            int numberOfPersons = Integer.parseInt(scanner.nextLine());
            System.out.println("Dati numarul de zile:");
            int days = Integer.parseInt(scanner.nextLine());

            service.checkIn(id, roomNumber, numberOfPersons, days);
        } catch (RuntimeException runtimeException) {
            System.out.println("Avem erori: " + runtimeException.getMessage());
        }
    }
}
