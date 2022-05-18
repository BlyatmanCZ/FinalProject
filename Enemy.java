import java.util.Random;

public class Enemy extends Character{
	
	Random rn = new Random();

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
    
    public Enemy[] enemies = { new Enemy(rn.nextInt(10)+10, rn.nextInt(10)+5, "Alien soldier"), new Enemy(rn.nextInt(7)+15, rn.nextInt(7)+10, "Enemy scientist"),
    		new Enemy(rn.nextInt(5)+13,rn.nextInt(10)+5, "Alien hound"), new Enemy(rn.nextInt(10)+17, rn.nextInt(10)+5, "Enemy machine"),
    		new Enemy(rn.nextInt(7)+15, rn.nextInt(10)+5, "Enemy Juggernaut"), new Enemy(rn.nextInt(10)+20,rn.nextInt(5)+5,"Unkown alien")
    		
    };
}
