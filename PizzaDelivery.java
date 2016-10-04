/**
 * Thread for Pizza delivery
 */
public class PizzaDelivery implements Runnable {

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // Waiting for the pizza order
                SharedVariables.reOrderSem.acquire();

                //Deliver the pizzas
                deliverPizzas();

                //Updating the pizza slice count
                SharedVariables.mutex.acquire();
                SharedVariables.pizzaSlicesCount = SharedVariables.maxPizzaSlices;
                SharedVariables.mutex.release();

                // Signalling the students to take pizzas
                SharedVariables.pizzaPickupSem.release(SharedVariables.maxPizzaSlices);
            }
        } catch (InterruptedException ignore) {
        }
    }

    // Method to deliver pizzas
    private void deliverPizzas() throws InterruptedException {
        System.out.println("Preparing to deliver the pizzas");
        Thread.sleep(600);
        System.out.println("---------Pizzas are delivered by Kamal's Pizza delivery---------");
    }
}
