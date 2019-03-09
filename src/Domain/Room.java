package Domain;

public class Room {
    private int id, numberOfPersons, days, roomNumber,rating;
    private String feedback;
    private boolean available;

    public Room(int id,int roomNumber, int numberOfPersons, int days) {
        this.id = id;
        this.numberOfPersons = numberOfPersons;
        this.days = days;
        this.roomNumber = roomNumber;
        this.available = false;
    }
    public Room(int id, int numberOfPersons, int days, int roomNumber, int rating, String feedback, boolean available) {
        this.id = id;
        this.numberOfPersons = numberOfPersons;
        this.days = days;
        this.roomNumber = roomNumber;
        this.rating = rating;
        this.feedback = feedback;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", numberOfPersons='" + numberOfPersons + '\'' +
                ", days=" + days +
                ", available=" + available +
                //", feedback='" + feedback + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
