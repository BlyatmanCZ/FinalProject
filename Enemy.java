import java.util.Random;
import java.util.Scanner;

public class Enemy extends Character{
	
	static Random rn = new Random();
	static Scanner sc = new Scanner(System.in);

    private String name;

    public Enemy(int HP, int strength, String name) {
        super(HP, strength);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    static public Enemy[] enemies = { new Enemy(rn.nextInt(10)+10, rn.nextInt(10)+5, "Alien soldier"), new Enemy(rn.nextInt(7)+15, rn.nextInt(7)+10, "Enemy scientist"),
    		new Enemy(rn.nextInt(5)+13,rn.nextInt(10)+5, "Alien hound"), new Enemy(rn.nextInt(10)+17, rn.nextInt(10)+5, "Enemy machine"),
    		new Enemy(rn.nextInt(7)+15, rn.nextInt(10)+5, "Enemy Juggernaut"), new Enemy(rn.nextInt(10)+20,rn.nextInt(5)+5,"Unkown alien")
    		
    };
    
    static public void battle(Character ch) {
    	int rnEnemyNum = rn.nextInt(enemies.length);

    	System.out.println("You see a " + enemies[rnEnemyNum].getName() + " in the wild ");
        int temp = enemies[rnEnemyNum].getHP();

        while(enemies[rnEnemyNum].getHP() > 0 && ch.getHP() > 0) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1) Attack \n2) Health potion (" + ch.gethPotion() + ") \n3) Strength potion (" + ch.getsPotion() + ") \n4) Run away");
            System.out.println();
            int attChoice = sc.nextInt();
            switch (attChoice) {
                case 1:
                    System.out.println("You have decided to attack the enemy.");
                    System.out.println("\nYou attack first.");
                    enemies[rnEnemyNum].setHP(enemies[rnEnemyNum].getHP()-ch.getStrength());
                    System.out.println("You have dealt " + ch.getStrength() + " damage to the " + enemies[rnEnemyNum].getName());
                    if(enemies[rnEnemyNum].getHP() > 0) {
                        System.out.println("\n" + enemies[rnEnemyNum].getName() + " attacks you.");
                        ch.setHP(ch.getHP()-enemies[rnEnemyNum].getStrength());
                        System.out.println("The " + enemies[rnEnemyNum].getName() + " has dealt "+ enemies[rnEnemyNum].getStrength() + " damage to you.");
                        if(ch.getHP() > 0){
                            System.out.println("You have " + ch.getHP() + " HP remaining.");
                        }else{
                            System.out.println("You have died.");
                        }
                    }else {
                        System.out.println("You have successfully killed the enemy.");
                    }
                    break;
                case 2:
                    if(ch.gethPotion() > 0){
                        System.out.println("You have decided to drink a health potion.");
                        ch.setHP(ch.getHP()+5);
                        System.out.println("You have gained 5 HP and now you have " + ch.getHP() + "HP.");
                        ch.sethPotion(ch.gethPotion()-1);
                        System.out.println("You have " + ch.gethPotion() + " health potions remaining.");
                    }else{
                        System.out.println("Sadly, you don't have any more health potions.");
                    }
                    break;
                case 3:
                    if(ch.getsPotion() > 0){
                        System.out.println("You have decided to drink a strength potion.");
                        ch.setStrength(ch.getStrength()+5);
                        System.out.println("You have gained 5 ATK and now you have " + ch.getStrength() + "HP.");
                        ch.setsPotion(ch.getsPotion()-1);
                        System.out.println("You have " + ch.getsPotion() + " strength potions remaining.");
                    }else{
                        System.out.println("Sadly, you don't have any more strength potions.");
                    }
                    break;
                case 4:
                    System.out.println("You have decided to run away.");
                    break;
            }
        }
        if(enemies[rnEnemyNum].getHP()==0){
            enemies[rnEnemyNum].setHP(temp);
        }
    }
}
