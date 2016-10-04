import java.util.concurrent.Semaphore;

public class SharedVariables {

    public static int pizzaSlicesCount = 0;
    public static final int maxPizzaSlices = 6;
    public static final int numOfStudents = 7;

    // Mutex for the exclusive access og pizza slices count
    public static final Semaphore mutex = new Semaphore(1);
    // Semaphore for signalling pizza delivery
    public static final Semaphore reOrderSem = new Semaphore(0);
    // Semaphore for signalling pizza slice pickups
    public static final Semaphore pizzaPickupSem = new Semaphore(0);

}
