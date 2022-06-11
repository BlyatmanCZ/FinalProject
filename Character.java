public class Character {

    protected int HP;
    protected int strength;
    protected int luck;
    protected int hPotion;
    protected int sPotion;
    protected int credit;
    protected int score;
    protected int maxHP;

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
    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public Character(int HP, int strength, int luck, int hPotion, int sPotion, int credit, int score, int maxHP) {
        this.HP = HP;
        this.strength = strength;
        this.luck = luck;
        this.hPotion = hPotion;
        this.sPotion = sPotion;
        this.credit = credit;
        this.score = score;
        this.maxHP = maxHP;
    }

    public Character(int HP, int strength, int score) {
        this.HP = HP;
        this.strength = strength;
        this.score = score;
    }

    public void charChoice(int choice) {  //Sets character values based on which character the player decide to play as
        switch (choice) {
            case 1: //Soldier
                setHP(20);
                setStrength(10);
                setLuck(10);
                setMaxHP(20);
                System.out.println("You have successfully chosen Soldier as your character");
                break;
            case 2: //Scientist
                setHP(15);
                setStrength(8);
                setLuck(15);
                setMaxHP(15);
                System.out.println("You have successfully chosen Scientist as your character");
                break;
            case 3: //Juggernaut
                setHP(25);
                setStrength(13);
                setLuck(5);
                setMaxHP(25);
                System.out.println("You have successfully chosen Juggernaut as your character");
                break;

        }
    }
}



