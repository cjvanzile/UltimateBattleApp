/* The Contender class contains the attributes for each contender and the run()method dictates the  behaviour of each
thread.
*/
public class Contender implements Runnable {
    // Variable name for the contender, iterable action
    private String competitor; // Competitor name
    private int pushUps; // Number of push-ups per round
    private int maxRest =0; // Max rest time per round

    private int totalPushUps =0; // Total push-ups completed
    static volatile boolean winner = false; // Set to true when someone exceeds 200 push-ups

    Water drink = new Water(); // Drink water class

    //Constructor
    public Contender(String competitor, int pushUps, int maxRest, Water drink){
        this.competitor = competitor;  // Competitor name
        this.pushUps = pushUps;  // Number of push-ups per round
        this.maxRest = maxRest;  // Maximum rest time per round
        this.drink = drink;  // Drink synchronization class
    }
    // Create necessary getters, no setters necessary
    public String getCompetitor() {
        return competitor;
    }
    public int getTotalPushUps() {
        return totalPushUps;
    }

    public void run() { // Create runnable thread
        try {
            while (winner == false) { // Loop while winner is false

                totalPushUps += pushUps;  // Add completed push-ups to the total

                if ( totalPushUps >= 200 ) {  // Determine if we have a winner
                    winner = true; // Set static volatile flag to let everyone know we have a winner

                    // Print notification of winner
                    System.out.println( "**********************************************\n"
                        + "* " + competitor + " just WON the race with " + totalPushUps + " push-ups!\n"
                        + "**********************************************");
                } else // Print notification if not a winner
                    System.out.println(competitor + " has completed " + totalPushUps + " push-ups.");

                // math.random() returns a double between 0.0 and 1.0
                int rest = (int) (Math.random() * maxRest); //each round consists of a random rest period

                System.out.println( competitor + " is resting." );
                Thread.sleep(rest); // Thread sleeps for rest period

                System.out.println(competitor + " rested for " + rest + " ms.");

                // math.random() returns a double between 0.0 and 1.0
                if ( Math.random() >= 0.5 ) {  // Competitor will drink water 50% of the time
                    synchronized (drink) { // only one competitor can drink at a time
                        drink.water(competitor);
                    }
                }
            }
        }
        catch (InterruptedException e) { // we caught an exception
            System.out.println(competitor + " got interrupted.");
        }
    }
}
