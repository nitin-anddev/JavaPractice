/**
 * Example child class to show method overriding
 */
public class Athlete extends HumanBeing{
    public Athlete() {
        super("Nitin Kumar");
    }

    @Override
    public int walk(int distance, int time) {
        int speed = distance / time;
        speed = speed * 2;
        return speed;
    }
}
