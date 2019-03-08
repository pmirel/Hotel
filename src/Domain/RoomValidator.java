package Domain;

public class RoomValidator {
    /**
     *
     * @param room
     * throw Runtime exception for validations
     */
    public void validate(Room room){
        if (room.getDays() <= 0) {
            throw new RuntimeException("The number of days cannot be 0 or negative!");
        }
        if(room.isAvailable() && room.getRoomNumber() <= 0){
            throw new RuntimeException("Room dosen't exist");
        }
        String feedback=room.getFeedback();
        if(feedback.isEmpty()){
            throw new RuntimeException("Feedback missing");
        }
        if(room.getRating()<1 && room.getRating()>5) {
        throw new RuntimeException("Rating is between 1 and 5");
        }

    }
}
