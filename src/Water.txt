public class Water {
    // defines a synchronized function that can only be ran by one thread at a time
    public synchronized void water(String contender){ /* defines a synchronized function that can only be ran by one
        thread at a time */
        System.out.println(contender + " has stopped for a drink.");
        try {
            Thread.sleep ( 500); // takes 1/2 second to drink
        }
        catch (InterruptedException e){
            System.out.println(contender + " got interrupted while drinking."); // got interrupted...
        }
        System.out.println(contender + " is done drinking!"); // ...but, kept drinking
    }
}
