import java.util.Scanner;

public class Character {

    Scanner sc = new Scanner(System.in);

    public int HP;
    public int strenght;
    public int luck;

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

    public void charChoice(int choice) {
        switch (choice) {
            case 1:
                setHP(10);
                setStrenght(10);
                setLuck(10);
                System.out.println("You successfully chose Soldier as your character");
                break;
            case 2:
                setHP(8);
                setStrenght(8);
                setLuck(15);
                System.out.println("You successfully chose Scientist as your character");
                break;
            case 3:
                setHP(15);
                setStrenght(15);
                setLuck(5);
                System.out.println("You successfully chose Juggernaut as your character");
                break;

        }
    }
}



