public class Character {

    protected int HP;
    protected int strength;
    protected int luck;
    protected int hPotion;
    protected int sPotion;
    protected int credit;
    protected int score;

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
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Character(int HP, int strength, int luck, int hPotion, int sPotion, int credit, int score) {
        this.HP = HP;
        this.strength = strength;
        this.luck = luck;
        this.hPotion = hPotion;
        this.sPotion = sPotion;
        this.credit = credit;
        this.score = score;
    }

    public Character(int HP, int strength, int score) {
        this.HP = HP;
        this.strength = strength;
        this.score = score;
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
                setHP(1);
                setStrength(8);
                setLuck(15);
                System.out.println("You have successfully chosen Scientist as your character");
                break;
            case 3:
                setHP(25);
                setStrength(15);
                setLuck(5);
                System.out.println("You have successfully chosen Juggernaut as your character");
                break;

        }
    }
}



