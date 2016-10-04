public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread studentThreads[] = new Thread[SharedVariables.numOfStudents];

        // Thread to manage the pizza delivery
        PizzaDelivery pizzaDelivery = new PizzaDelivery();
        Thread pizzaThread = new Thread(pizzaDelivery);
        pizzaThread.start();

        // Threads to manage students
        for (int studentIndex = 0; studentIndex < SharedVariables.numOfStudents; studentIndex++) {
            Student student = new Student(studentIndex+1);
            studentThreads[studentIndex] = new Thread(student);
            studentThreads[studentIndex].start();
        }

        // Wait the main thread to obtain the simulation
        Thread.sleep(3500);

        // Shutting down the threads
        pizzaThread.interrupt();
        for (int studentIndex = 0; studentIndex < SharedVariables.numOfStudents; studentIndex++) {
            studentThreads[studentIndex].interrupt();
        }

        System.out.println("Program execution is terminated");
    }
}
