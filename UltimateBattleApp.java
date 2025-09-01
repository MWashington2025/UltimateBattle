/*
Marzavious Washington
2/14/2025
COP-3330C-24217
Description: Utilizing threads within a program with two people going against each other.
 */

public class UltimateBattleApp {

    public static void main(String[] args) {
        Water water = new Water();
        Contender friend1 = new Contender("Spongebob", 13, 100, water);
        Contender friend2 = new Contender("Patrick", 9, 200, water);
        Water drink = new Water();

        Thread thread = new Thread(friend1);
        Thread thread1 = new Thread(friend2);

        thread.start();
        thread1.start();
    }
}
