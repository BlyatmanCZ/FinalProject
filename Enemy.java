import java.util.Random;
import java.util.Scanner;

public class Enemy extends Character{
	
	static Random rn = new Random();
	static Scanner sc = new Scanner(System.in);

    private final String name;

    public Enemy(int HP, int strength, String name, int score) {
        super(HP, strength, score);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    
    static public Enemy[] enemies = { // Array of enemy objects the player can encounter
            new Enemy(rn.nextInt(15)+20, rn.nextInt(5)+8, "Alien soldier", 150),
            new Enemy(rn.nextInt(10)+20, rn.nextInt(3)+8, "Enemy scientist",100),
    		new Enemy(rn.nextInt(7)+20,rn.nextInt(7)+8, "Alien hound",100),
            new Enemy(rn.nextInt(20)+20, rn.nextInt(8)+8, "Enemy machine",250),
    		new Enemy(rn.nextInt(10)+20, rn.nextInt(8)+8, "Enemy Juggernaut",200),
            new Enemy(rn.nextInt(15)+20,rn.nextInt(6)+8,"Unknown alien",200)
    		
    };
    
    static public void battle(Character ch, int planetCounter , String name) { // Method for encountering and fighting an enemy
        System.out.println("\nAfter some time, you discover " + Planet.randomBattlePlace());
        System.out.println("You decide to explore this place.");

        int chance = rn.nextInt(100);

        if(chance > 15) {
            int rnEnemyNum = rn.nextInt(enemies.length); //Chooses random enemy from an array, that the player fights with
            System.out.println("\nYou see a " + enemies[rnEnemyNum].getName() + " in the wild.");
            System.out.println("You have " + ch.getHP() + "HP. ");
            int temp = enemies[rnEnemyNum].getHP();

            enemies[rnEnemyNum].setHP(enemies[rnEnemyNum].getHP()+(planetCounter*2)); //The enemies HP get progressively harder, based on the number of saved planets
            enemies[rnEnemyNum].setScore(enemies[rnEnemyNum].getScore()+(planetCounter*50)); //The score reward for killing the enemy also gets progressively bigger

            boolean run = false;
            int sPotionUsed = 0;

            while (enemies[rnEnemyNum].getHP() > 0 && ch.getHP() > 0 && !run) {
                System.out.println("\nWhat do you want to do?");
                System.out.println("1) Attack \n2) Health potion (" + ch.gethPotion() + ") \n3) Strength potion (" + ch.getsPotion() + ") \n4) Run away");
                System.out.println();
                int attChoice = 0;
                try {
                    attChoice=Integer.parseInt(sc.nextLine());
                }
                catch(NumberFormatException e){
                    System.out.println("Enter a number.");
                }
                switch (attChoice) {
                    case 1: //Attacking the enemy
                        System.out.println("You have decided to attack the enemy.");
                        System.out.println("\nYou attack first.");

                        int rnCriticalHitNum = rn.nextInt(30)+1;
                        if(rnCriticalHitNum < ch.getLuck()){ //Chance of critically hitting the enemy and dealing 2X damage based on the characters luck
                            enemies[rnEnemyNum].setHP(enemies[rnEnemyNum].getHP() - (ch.getStrength()*2));
                            System.out.println("Critical hit!");
                            System.out.println("You have dealt " + (ch.getStrength()*2) + " damage to the " + enemies[rnEnemyNum].getName());
                        }else{
                            enemies[rnEnemyNum].setHP(enemies[rnEnemyNum].getHP() - ch.getStrength());
                            System.out.println("You have dealt " + ch.getStrength() + " damage to the " + enemies[rnEnemyNum].getName());
                        }


                        if (enemies[rnEnemyNum].getHP() > 0) {
                            System.out.println("The enemy has " + enemies[rnEnemyNum].getHP() + "HP remaining.");
                            System.out.println("\n" + enemies[rnEnemyNum].getName() + " attacks you.");
                            ch.setHP(ch.getHP() - enemies[rnEnemyNum].getStrength());
                            System.out.println("The " + enemies[rnEnemyNum].getName() + " has dealt " + enemies[rnEnemyNum].getStrength() + " damage to you.");
                            if (ch.getHP() > 0) {
                                System.out.println("You have " + ch.getHP() + "HP remaining.");
                            } else { // Death of the player
                                System.out.println("-----------------------------");
                                System.out.println("\nGAME OVER");
                                System.out.println("You have been killed by " + enemies[rnEnemyNum].getName());
                                System.out.println("\n" + name + " - Saved planets: " + planetCounter + " Total score: " + ch.getScore());
                            }
                        } else { //Death of the enemy
                            System.out.println("You have successfully killed the enemy.");
                            int tmp = rn.nextInt(20)+11;
                            ch.setCredit(ch.getCredit() + tmp);
                            ch.setScore(ch.getScore() + enemies[rnEnemyNum].getScore());
                            System.out.println("\nYou have received " + tmp + " Credits and " + enemies[rnEnemyNum].getScore() + " score for defeating the enemy.");
                            ch.setHP(ch.getHP() + 10);
                            if (ch.getHP() > ch.getMaxHP()) {
                                ch.setHP(ch.getMaxHP());
                            }
                            System.out.println("You have also recovered 10 health points for defeating the enemy.");
                        }
                        break;
                    case 2: //Drinking a health potion
                        if (ch.gethPotion() > 0) {
                            System.out.println("You have decided to drink a health potion.");
                            ch.setHP(ch.getHP() + 10);
                            System.out.println("You have gained 10 HP and now you have " + ch.getHP() + "HP.");
                            ch.sethPotion(ch.gethPotion() - 1);
                            System.out.println("You have " + ch.gethPotion() + " health potions remaining.");
                        } else {
                            System.out.println("Sadly, you don't have any more health potions.");
                        }
                        break;
                    case 3: //Drinking a strength potion
                        if (ch.getsPotion() > 0) {
                            System.out.println("You have decided to drink a strength potion.");
                            ch.setStrength(ch.getStrength() + 10);
                            System.out.println("You have gained 10 ATK and now you have " + ch.getStrength() + "ATK.");
                            ch.setsPotion(ch.getsPotion() - 1);
                            System.out.println("You have " + ch.getsPotion() + " strength potions remaining.");
                            sPotionUsed++;
                        } else {
                            System.out.println("Sadly, you don't have any more strength potions.");
                        }
                        break;
                    case 4: //Running away
                        System.out.println("You have decided to run away.");
                        run = true;
                        System.out.println("You haven't received any Credits or score for running away from the enemy.");
                        ch.setHP(ch.getHP() + 10);
                        if (ch.getHP() > ch.getMaxHP()) {
                            ch.setHP(ch.getMaxHP());
                        }
                        System.out.println("You have recovered 10 health points.");
                        break;
                }
            }
                enemies[rnEnemyNum].setHP(temp); //Returns the enemy's HP to full, so the player can encounter and fight him again

            ch.setStrength(ch.getStrength()-(10*sPotionUsed));

            if(ch.getHP() > ch.getMaxHP()){ //Makes sure, that the player doesn't have more HP than his max at the end of a fight
                ch.setHP(ch.getMaxHP());
            }
        }else{ // 15% chance, that the player won't find any enemy to fight with
            System.out.println("\nYou have been exploring for a while now, but you don't see anybody.");
            System.out.println("This place seems abandoned.");
        }

        if(ch.getHP()>0){
            System.out.println("\nYou return to your landing site.");
        }
    }
}