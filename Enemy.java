import java.util.Random;
import java.util.Scanner;

public class Enemy extends Character{
	
	static Random rn = new Random();
	static Scanner sc = new Scanner(System.in);

    private String name;

    public Enemy(int HP, int strenght, String name) {
        super(HP, strenght);
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
    
    static public void battle() {
    	int rnEnemyNum = rn.nextInt(enemies.length);
    	
    	System.out.println("You see a " + enemies[rnEnemyNum].getName() + " in the wild ");
        System.out.println("\nWhat do you want to do?");
        
        System.out.println("1) Attack \n2) Health potion \n3) Strenght potion \n4) Run away");
        int attChoice = sc.nextInt();
        switch (attChoice) {
        	case 1:
        		System.out.println("You have decided to attack the enemy.");
        		break;
        	case 2:
        		
        		break;
        	case 3:
        		
        		break;	
        	case 4:
        		System.out.println("You have decided to run away.");
        		break;
        }
        
    }
  
}
