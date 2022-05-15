public class Enemy extends Character{

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


}
