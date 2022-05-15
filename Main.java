import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

        public class Main {

            public static void main(String[] args) {

                Random rn = new Random();
                Scanner sc = new Scanner(System.in);

                System.out.println("                                      --------- SPACEVENTURES ---------");
                System.out.println("Your galaxy was invaded by evil aliens and you will have to save as many planets as you can to help restore the peace. ");

                System.out.println("\nEnter your name:");
                String name = sc.next();
                System.out.println("Welcome, " + name);

                System.out.println("\nChoose your character:");

                System.out.println("1) Soldier - Att 10, HP 10, Luck 10");
                System.out.println("2) Scientist - Att 8, HP 8, Luck 15 ");
                System.out.println("3) Juggernaut - Att 15, HP 15, Luck 5");

                int choice = sc.nextInt(); //add try catch

                Character ch = new Character(0,0,0);
                ch.charChoice(choice);

                System.out.println("\nYour journey begins");
                System.out.println("Save as many planets as you can!\n-----------------------------");

                while(ch.HP > 0) {
                    System.out.println("\nYou have arrived on the planet " + Planet.randomPlName());
                    System.out.println(Planet.randomPlDesc());
                    System.out.println("You decide to explore the planet.");
                    boolean N = true;
                    boolean S = true;
                    boolean E = true;
                    boolean W = true;
                    for(int i = 0; i < 4; i++) {
                        Planet.direction(N,S,E,W);
                        int choice2 = sc.nextInt();
                        switch(choice2){
                            case 1:
                                N = false;
                                System.out.println("You have decided to go north.");
                                break;
                            case 2:
                                S = false;
                                System.out.println("You have decided to go south.");
                                break;
                            case 3:
                                E = false;
                                System.out.println("You have decided to go east.");
                                break;
                            case 4:
                                W = false;
                                System.out.println("You have decided to go west.");
                                break;
                        }
                        System.out.println("\nAfter some time, you discover " + Planet.randomPlace());
                        System.out.println("You decide to explore this place.");
                        System.out.println("You see a enemy " + " in the wild ");
                    }
                    ch.setHP(0); //temp
                }
            }
        }