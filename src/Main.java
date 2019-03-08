import Domain.RoomValidator;
import Repository.RoomRepository;
import Service.RoomService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        RoomValidator validator = new RoomValidator();
        RoomRepository repository = new RoomRepository(validator);
        RoomService room = new RoomService(repository);
        room.checkIn(1, 1, 2, 2);
        room.checkIn(2, 2, 1, 2);
        room.checkOut(1, "acceptabil", 4);
        room.checkIn(3, 1, 3, 2);
        room.checkOut(2, "se poate mai bine", 2);
        room.checkIn(4, 2, 2, 2);
        room.checkOut(1, "foarte bine", 5);
        room.checkIn(5, 3, 2, 2);
        room.checkOut(2, "urat", 1);
        room.checkIn(6, 2, 4, 2);
        room.checkIn(9, 12, 4, 2);
        Console console = new Console(room);
        console.run();
    }
}
