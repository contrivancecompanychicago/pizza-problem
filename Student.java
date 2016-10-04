/**
 * Thread for Students
 */
public class Student implements Runnable {

    private int index;
    private static boolean orderedPizza = false;

    public Student(int index) {
        this.index = index;
    }

    @Override
    public void run() {
            try {
                while (!Thread.interrupted()) {
                    // Accessing remaining pizza count
                    SharedVariables.mutex.acquire();
                    // First student to find pizza slices are 0, re orders
                    if (SharedVariables.pizzaSlicesCount == 0 && !orderedPizza) {
                        this.reOrderPizzas();
                        // Allowing the pizza delivery thread to proceed
                        SharedVariables.reOrderSem.release();
                        orderedPizza = true;
                    }
                    SharedVariables.mutex.release();

                    // Waiting on the pizza pickup semaphore
                    SharedVariables.pizzaPickupSem.acquire();
                    orderedPizza = false;

                    // Picking up pizza slices
                    SharedVariables.mutex.acquire();
                    SharedVariables.pizzaSlicesCount--;
                    pickPizzaSlice();
                    SharedVariables.mutex.release();

                    // Eating and studying
                    eatAndStudy();
                }
            } catch (InterruptedException ignore) {
            }
    }

    // Method to pick pizza slices
    private void pickPizzaSlice() {
        System.out.println("Student " + this.index + " picked a pizza slice");
        System.out.println("Remaining : " + SharedVariables.pizzaSlicesCount);
    }

    // Method to eat and study
    private void eatAndStudy() throws InterruptedException {
        System.out.println("Student " + this.index + " is studying while eating pizza ");
        Thread.sleep(300);
    }

    // Method to re order pizza
    private void reOrderPizzas() {
        System.out.println("The student " + this.index + " re ordered pizzas ");
    }
}
