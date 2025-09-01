public class Water  {
   public synchronized void drink(String contenderName) { //Synchronized action so only one person at a time can drink
       try {
           System.out.println(contenderName + " is drinking water (while underwater). ");
           Thread.sleep(2000);//Time to drink water in seconds
           System.out.println(contenderName + " has stopped drinking water.");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
