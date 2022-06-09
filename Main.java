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

                System.out.println("\nEnter your name:");
                String name = sc.next();
                System.out.println("Welcome, " + name + "!");

                System.out.println("\nChoose your character:");

                System.out.println("1) Soldier - ATK 10, HP 20, Luck 10");
                System.out.println("2) Scientist - ATK 8, HP 15, Luck 15 ");
                System.out.println("3) Juggernaut - ATK 15, HP 25, Luck 5");

                Character ch = new Character(0,0,0,1,1,0,0);

                while(ch.getHP()==0){
                    int choice = sc.nextInt();
                    ch.charChoice(choice);
                }
                int maxHP = ch.getHP();

                Item activeItem = new Item(0,0,null);

                System.out.println("\nYour journey begins");
                System.out.println("Save as many planets as you can!\n-----------------------------");

                while(ch.getHP() > 0) {
                    System.out.println("\nYou have arrived on the planet " + Planet.randomPlName());
                    System.out.println(Planet.randomPlDesc());
                    boolean N = true;
                    boolean S = true;
                    boolean E = true;
                    boolean W = true;
                    while((N || S || E || W) && ch.getHP() > 0) {
                        Planet.direction(N, S, E, W);
                        int choice2 = sc.nextInt();
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
                        int rnPlaceNum = rn.nextInt(10);
                        if(rnPlaceNum > 0){
                            Enemy.battle(ch, maxHP);
                        }else{
                            Planet.friendlyScientist(ch,activeItem,maxHP);
                        }

                        }
                    if(ch.getHP()>0){
                        ch.setHP(maxHP);
                        System.out.println("\nYou have explored all the directions of this planet. \nYou return to your spaceship.");
                        System.out.println("Your spaceship has taken off and now it's on its way to another planet.");
                        Shop.shop(ch, activeItem, maxHP);
                    }
                }
            }
        }