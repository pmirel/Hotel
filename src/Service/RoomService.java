package Service;

import Domain.Room;
import Domain.RoomAverageRating;
import Repository.RoomRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RoomService {

    private RoomRepository repository;

    /**
     * ...
     * @param repository
     */
    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    /**
     * ...
     * @param id
     * @param roomNumber
     * @param numberOfPersons
     * @param days
     */
    public void checkIn(int id, int roomNumber, int numberOfPersons, int days) {

        Room room = new Room(id, roomNumber, numberOfPersons, days);
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isAvailable()) {
                throw new RuntimeException("The room is not available!");
            }
        }
        repository.add(room);
    }

    /**
     *
     * @param roomNumber
     * @param feedback
     * @param rating
     */
    public void checkOut(int roomNumber, String feedback, int rating) {
        Room currentRoom = null;
        List<Room> rooms = repository.getAll();
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber && !r.isAvailable()) {
                currentRoom = r;
            }
        }

        if (currentRoom != null) {
            currentRoom.setFeedback(feedback);
            currentRoom.setRating(rating);
            currentRoom.setAvailable(true);
            repository.update(currentRoom);
        } else {
            throw new RuntimeException("There is no car on the given stand!");
        }
    }

    public List<RoomAverageRating> getRoomRatingAverages() {
        List<RoomAverageRating> results = new ArrayList<>();
        Map<Integer, List<Double>> ratingsForRoom = new HashMap<>();

        for (Room r : repository.getAll()) {
            if (r.isAvailable()) {
                int roomNumber = r.getRoomNumber();
                double rating = r.getRating();

                if (!ratingsForRoom.containsKey(roomNumber)) {
                    ratingsForRoom.put(roomNumber, new ArrayList<>());
                }
                ratingsForRoom.get(roomNumber).add(rating);
            }
        }

        for (int roomNumber : ratingsForRoom.keySet()) {
            List<Double> ratings = ratingsForRoom.get(roomNumber);
            double average = 0;
            for (double p : ratings) {
                average += p;
            }
            average /= ratings.size();
            results.add(new RoomAverageRating(roomNumber, average));
        }

//        results.sort((r1, r2) -> r1.getAveragePrice() > r2.getAveragePrice() ? -1 : 1);
        results.sort((r1, r2) -> {
            if (r1.getAverageRating() > r2.getAverageRating())
                return -1;
            else if (r1.getAverageRating() == r2.getAverageRating())
                return 0;
            else
                return 1;
        });
        return results;
    }

    public List<Room> getAll() {
        return repository.getAll();
    }
}
