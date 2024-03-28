package classes;

public class PositionFilledException extends Exception {
    public PositionFilledException(String message){
        System.err.println(message);
    }
}
