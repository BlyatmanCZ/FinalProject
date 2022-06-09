import java.util.Random;
import java.util.Scanner;

public class Item {

    static Random rn = new Random();
    static Scanner sc = new Scanner(System.in);

    private int ATK;
    private int DEF;
    private String name;

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(int ATK, int DEF, String name) {
        this.ATK = ATK;
        this.DEF = DEF;
        this.name = name;
    }

    static Item[] items = { //pole objektu itemu, ktere hrac muze ziskat
            new Item(1,0,"Basic handgun"), new Item(0,1,"Rusty shield"), //Common
            new Item(1,0,"Old knife"), new Item(0,1,"Aged chest-plate"),
            new Item(2,0,"Cyber rifle"), new Item(1,1,"Energy shield"), //Uncommon
            new Item(2,0,"Machete"), new Item(0,2,"Cool glasses"),
            new Item(3,0,"Plasma sword"), new Item(1,2,"Gravity helmet"), //Rare
            new Item(3,0, "Katana"), new Item(0,3,"Neon armor"),
            new Item(4,0,"Energy gun"), new Item(0,4,"Cyber suit"), //Epic
            new Item(4,0,"Plasma RPG"), new Item(2,2,"Laser pants"),
            new Item(5,0,"Laser-gun 3000"), new Item(2,5,"Neutron armor"), //Legendary
            new Item(5,0,"Ancient katana"), new Item(0,7,"Hawaiian shirt")

    };

    static void openChest(Item activeItem, Character ch, int maxHP) { //metoda pro otevreni truhly. Hrac dostane nahodny item podle rarity a jeji procentualni sance
        int rnItemNum = rn.nextInt(100) + 1;
        int rnItemNum2 = rn.nextInt(4);
        int equipChoice;

        System.out.println("You are opening a chest!");

        if (rnItemNum > 1 && rnItemNum < 39) { // Common 38%
            System.out.println("You got a Common item from the chest!");
            System.out.println(items[rnItemNum2].getName() + " - ATK: " + items[rnItemNum2].getATK() + ", DEF: " + items[rnItemNum2].getDEF());

            Item.equipItem1(activeItem,ch, maxHP);
            System.out.println("1) Yes \n2) No");
            equipChoice = sc.nextInt();
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2].getName());
                activeItem.setATK(items[rnItemNum2].getATK());
                activeItem.setDEF(items[rnItemNum2].getDEF());
                Item.equipItem2(activeItem,ch, maxHP);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch, maxHP);
            }
        } else if (rnItemNum > 38 && rnItemNum < 65) { // Uncommon 26%
            System.out.println("You got an Uncommon item from the chest!");
            System.out.println(items[rnItemNum2 + 4].getName()+ " - ATK: " + items[rnItemNum2+4].getATK() + ", DEF: " + items[rnItemNum2+4].getDEF());

            Item.equipItem1(activeItem,ch, maxHP);
            System.out.println("1) Yes \n2) No");
            equipChoice = sc.nextInt();
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+4].getName());
                activeItem.setATK(items[rnItemNum2+4].getATK());
                activeItem.setDEF(items[rnItemNum2+4].getDEF());
                Item.equipItem2(activeItem,ch,maxHP);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch,maxHP);
            }
        } else if (rnItemNum > 64 && rnItemNum < 82) { // Rare 17%
            System.out.println("You got a Rare item from the chest!");
            System.out.println(items[rnItemNum2 + 8].getName()+ " - ATK: " + items[rnItemNum2+8].getATK() + ", DEF: " + items[rnItemNum2+8].getDEF());

            Item.equipItem1(activeItem,ch,maxHP);
            System.out.println("1) Yes \n2) No");
            equipChoice = sc.nextInt();
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+8].getName());
                activeItem.setATK(items[rnItemNum2+8].getATK());
                activeItem.setDEF(items[rnItemNum2+8].getDEF());
                Item.equipItem2(activeItem,ch,maxHP);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch,maxHP);
            }
        } else if (rnItemNum > 81 && rnItemNum < 94) { // Epic 12%
            System.out.println("You got an Epic item from the chest!");
            System.out.println(items[rnItemNum2 + 12].getName()+ " - ATK: " + items[rnItemNum2+12].getATK() + ", DEF: " + items[rnItemNum2+12].getDEF());

            Item.equipItem1(activeItem,ch,maxHP);
            System.out.println("1) Yes \n2) No");
            equipChoice = sc.nextInt();
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+12].getName());
                activeItem.setATK(items[rnItemNum2+12].getATK());
                activeItem.setDEF(items[rnItemNum2+12].getDEF());
                Item.equipItem2(activeItem,ch,maxHP);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch,maxHP);
            }
        } else if (rnItemNum > 93) { // Legendary 7%
            System.out.println("You got a Legendary item from the chest!");
            System.out.println(items[rnItemNum2 + 16].getName()+ " - ATK: " + items[rnItemNum2+16].getATK() + ", DEF: " + items[rnItemNum2+16].getDEF());

            Item.equipItem1(activeItem,ch,maxHP);
            System.out.println("1) Yes \n2) No");
            equipChoice = sc.nextInt();
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+16].getName());
                activeItem.setATK(items[rnItemNum2+16].getATK());
                activeItem.setDEF(items[rnItemNum2+16].getDEF());
                Item.equipItem2(activeItem,ch,maxHP);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch,maxHP);
            }
        }
    }
    static void equipItem1(Item activeItem, Character ch, int maxHP){ //metody pro zadavani itemu jako hracuv aktivni
        System.out.println("\nDo you want to equip this item? (You can have only one item equipped at a time)");
        if(activeItem.getName() == null){
            System.out.println("You don't have any item equipped right now.");
        }else {
            System.out.println("You have a " + activeItem.getName() + " (ATK: " + activeItem.getATK() + ", DEF: " + activeItem.getDEF() + ") equipped right now.");
        }
        ch.setHP(ch.getHP()- activeItem.getDEF());
        ch.setStrength(ch.getStrength()- activeItem.getATK());
        maxHP = maxHP - activeItem.getDEF();
    }
    static void equipItem2(Item activeItem, Character ch, int maxHP){
        ch.setHP(ch.getHP()+activeItem.getDEF());
        ch.setStrength(ch.getStrength()+ activeItem.getATK());
        maxHP = maxHP + activeItem.getDEF();
    }
}
