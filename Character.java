public class Character {

    protected int HP;
    protected int strength;
    protected int luck;
    protected int hPotion;
    protected int sPotion;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int gethPotion() {
        return hPotion;
    }

    public void sethPotion(int hPotion) {
        this.hPotion = hPotion;
    }

    public int getsPotion() {
        return sPotion;
    }

    public void setsPotion(int sPotion) {
        this.sPotion = sPotion;
    }

    public Character(int HP, int strength, int luck, int hPotion, int sPotion) {
        this.HP = HP;
        this.strength = strength;
        this.luck = luck;
        this.hPotion = hPotion;
        this.sPotion = sPotion;
    }

    public Character(int HP, int strength) {
        this.HP = HP;
        this.strength = strength;
    }

    public void charChoice(int choice) {   //Nastavi hodnoty charakteru podle vyberu
        switch (choice) {
            case 1:
                setHP(20);
                setStrength(10);
                setLuck(10);
                System.out.println("You have successfully chosen Soldier as your character");
                break;
            case 2:
                setHP(15);
                setStrength(8);
                setLuck(15);
                System.out.println("You have successfully chosen Scientist as your character");
                break;
            case 3:
                setHP(30);
                setStrength(15);
                setLuck(5);
                System.out.println("You have successfully chosen Juggernaut as your character");
                break;

        }
    }
}



