import java.util.Scanner;

public class Character {

    protected int HP;
    protected int strenght;
    protected int luck;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public Character(int HP, int strenght, int luck) {
        this.HP = HP;
        this.strenght = strenght;
        this.luck = luck;
    }

    public Character(int HP, int strenght) {
        this.HP = HP;
        this.strenght = strenght;
    }

    public void charChoice(int choice) {   //Nastavi hodnoty charakteru podle vyberu
        switch (choice) {
            case 1:
                setHP(10);
                setStrenght(10);
                setLuck(10);
                System.out.println("You have successfully chosen Soldier as your character");
                break;
            case 2:
                setHP(8);
                setStrenght(8);
                setLuck(15);
                System.out.println("You have successfully chosen Scientist as your character");
                break;
            case 3:
                setHP(15);
                setStrenght(15);
                setLuck(5);
                System.out.println("You have successfully chosen Juggernaut as your character");
                break;

        }
    }
}



