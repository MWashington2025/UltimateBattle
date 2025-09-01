import java.util.Random;

class Contender implements Runnable { //Class attributes
    protected String name;
    private int JellyFishCaught;
    private int totalJellyFishCaught = 25;
    private int maxRest; //In minutes
    private static boolean winner = false;//Starting shared attribute (nobody has won yet)
    private Water water; //synchronized attribute

    public Contender (String name, int JellyFishCaught, int maxRest, Water water) { //Container
        this.name = name;
        this.JellyFishCaught = JellyFishCaught;
        this.totalJellyFishCaught = 0;
        this.maxRest = maxRest;
        this.water = water;
    }
    @Override
   public void run() {
        Random random = new Random();
        while (!winner) { //A continuous loop until the attribute "winner" is false.
            try {
                int Rest = random.nextInt(maxRest);//A random number will be selected for the rest time
                Thread.sleep(Rest);//Contenders will rest for a set time
                System.out.println(name + " has chilled for " + Rest + " minutes. ");


                totalJellyFishCaught += JellyFishCaught;//Starting JellyFishing
                System.out.println(name + " has caught " + JellyFishCaught + " Jellyfish. " + " Total JellyFish caught: " + totalJellyFishCaught);

                water.drink(name);//Calling the drink method (or taking a water break)

                if (totalJellyFishCaught >= 200) {//The action will run through until someone gets 200
                    if (!winner) {
                        winner = true;
                        System.out.println(name + " has caught the most! ");
                        break;
                    }

                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
   }
   public static boolean victory() {
        return winner;
   }
}
