import java.util.Random;
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {

                Random rn = new Random();
                Scanner sc = new Scanner(System.in);

                System.out.println("\n" +
                        "░██████╗ ██████╗░ ░█████╗░ ░█████╗░ ███████╗ ██╗░░░██╗ ███████╗ ███╗░░██╗ ████████╗ ██╗░░░██╗ ██████╗░ ███████╗ ░██████╗\n" +
                        "██╔════╝ ██╔══██╗ ██╔══██╗ ██╔══██╗ ██╔════╝ ██║░░░██║ ██╔════╝ ████╗░██║ ╚══██╔══╝ ██║░░░██║ ██╔══██╗ ██╔════╝ ██╔════╝\n" +
                        "╚█████╗░ ██████╔╝ ███████║ ██║░░╚═╝ █████╗░░ ╚██╗░██╔╝ █████╗░░ ██╔██╗██║ ░░░██║░░░ ██║░░░██║ █████╔╝  █████╗░░ ╚█████╗░\n" +
                        "░╚═══██╗ ██╔═══╝░ ██╔══██║ ██║░░██╗ ██╔══╝░░ ░╚████╔╝░ ██╔══╝░░ ██║╚████║ ░░░██║░░░ ██║░░░██║ ██╔═██╗  ██╔══╝░░ ░╚═══██╗\n" +
                        "██████╔╝ ██║░░░░░ ██║░░██║ ╚█████╔╝ ███████╗ ░░╚██╔╝░░ ███████╗ ██║░╚███║ ░░░██║░░░ ╚██████╔╝ ██║░░██║ ███████╗ ██████╔╝\n" +
                        "╚═════╝░ ╚═╝░░░░░ ╚═╝░░╚═╝ ░╚════╝░ ╚══════╝ ░░░╚═╝░░░ ╚══════╝ ╚═╝░░╚══╝ ░░░╚═╝░░░ ░╚═════╝░ ╚═╝░░╚═╝ ╚══════╝ ╚═════╝░");
                System.out.println("\nYour galaxy was invaded by evil aliens and you have to save as many planets as you can to help restore the peace. ");
                System.out.println("Save at least 5 planets to win the game, but be careful, enemies will get more difficult with each saved planet!");

                System.out.println("\nEnter your name:");
                String name = sc.next();
                System.out.println("Welcome, " + name + "!");

                System.out.println("\nChoose your character:");

                System.out.println("1) Soldier - ATK 10, HP 20, Luck 10 (Normal)");
                System.out.println("2) Scientist - ATK 8, HP 15, Luck 15 (Hard)");
                System.out.println("3) Juggernaut / Heavy soldier - ATK 13, HP 25, Luck 5 (Easy)");

                System.out.println("\n(Luck increases the chances of a critical hit in a fight)");

                Character ch = new Character(0, 0, 0, 1, 1, 0, 0,0);

                int choice = 0;
                while (ch.getHP() == 0) {
                    while (choice < 1 || choice > 3){ //Makes sure that the player cannot enter a number other than the one required
                        try {
                            choice=Integer.parseInt(sc.nextLine());
                        }
                        catch(NumberFormatException e){
                            System.out.println("Enter a number from 1 to 3");
                        }
                    }
                    ch.charChoice(choice);
                }

                Item activeItem = new Item(0, 0, null);

                System.out.println("\nYour journey begins.\nGood luck!");

                int planetCounter = 0;
                while (ch.getHP() > 0) {
                    System.out.println("-----------------------------");
                    System.out.println("\nYou have arrived on the planet " + Planet.randomPlName());
                    System.out.println(Planet.randomPlDesc());
                    boolean N = true;
                    boolean S = true;
                    boolean E = true;
                    boolean W = true;
                    while ((N || S || E || W) && ch.getHP() > 0) {
                        Planet.direction(N, S, E, W);

                        int choice2 = 0;
                        while (choice2 < 1 || choice2 > 4) {
                            try {
                                choice2=Integer.parseInt(sc.nextLine());
                            }
                            catch(NumberFormatException e){
                                System.out.println("Enter a number.");
                            }
                        }
                        switch (choice2) {
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
                        int rnPlaceNum = rn.nextInt(100);
                        if (rnPlaceNum > 15) { //85% chance of encountering an enemy
                            Enemy.battle(ch, planetCounter, name);
                        } else { //15% chance of encountering a friendly scientist
                            Planet.friendlyScientist(ch, activeItem);
                        }

                    }
                    if(planetCounter == 5){ //After five saved planets, player has an option to end the game
                        Planet.gameEnd(ch, name);
                    }
                    if (ch.getHP() > 0) {
                        planetCounter++;
                        ch.setHP(ch.getMaxHP());
                        System.out.println("\nYou have explored all the directions of this planet. \nYou return to your spaceship.");
                        System.out.println("Your spaceship has taken off and now it's on its way to another planet.");
                        Shop.shop(ch, activeItem);
                }
            }
        }
    }