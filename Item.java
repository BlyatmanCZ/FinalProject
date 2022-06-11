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

    static Item[] items = { //An array of item objects with different rarities, which the player can get from a chest
            new Item(1,0,"Basic handgun"), new Item(0,1,"Rusty shield"), //Common
            new Item(1,0,"Old knife"), new Item(0,1,"Aged chest-plate"),
            new Item(2,0,"Cyber rifle"), new Item(1,1,"Energy shield"), //Uncommon
            new Item(2,0,"Machete"), new Item(0,2,"Cool glasses"),
            new Item(2,1,"Plasma sword"), new Item(1,2,"Gravity helmet"), //Rare
            new Item(2,1, "Katana"), new Item(0,3,"Neon armor"),
            new Item(3,1,"Energy gun"), new Item(0,4,"Cyber suit"), //Epic
            new Item(4,0,"Plasma RPG"), new Item(2,3,"Laser pants"),
            new Item(5,0,"Laser-gun 3000"), new Item(2,5,"Neutron armor"), //Legendary
            new Item(5,0,"Ancient katana"), new Item(0,7,"Hawaiian shirt")

    };

    static void openChest(Item activeItem, Character ch) { //Method for opening a chest
        int rnItemNum = rn.nextInt(100);
        int rnItemNum2 = rn.nextInt(4);
        int equipChoice = 0;

        System.out.println("You are opening a chest!"); // The player gets a random item from the array based on their rarity

        if (rnItemNum < 39) { // 39% chance of getting a Common item from the chest
            System.out.println("You got a Common item from the chest!");
            System.out.println(items[rnItemNum2].getName() + " - ATK: " + items[rnItemNum2].getATK() + ", DEF: " + items[rnItemNum2].getDEF());

            Item.equipItem1(activeItem,ch);
            System.out.println("1) Yes \n2) No");
            while(equipChoice < 1 || equipChoice > 2){
                try {equipChoice=Integer.parseInt(sc.nextLine());}
                catch(NumberFormatException e){System.out.println("Enter a number.");}
            }
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2].getName()); //Sets the item which the player just got from the chest as his active (equipped) item
                activeItem.setATK(items[rnItemNum2].getATK());
                activeItem.setDEF(items[rnItemNum2].getDEF());
                Item.equipItem2(activeItem,ch);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch);
            }
        } else if (rnItemNum < 66) { // 27% chance of getting an Uncommon item
            System.out.println("You got an Uncommon item from the chest!");
            System.out.println(items[rnItemNum2 + 4].getName()+ " - ATK: " + items[rnItemNum2+4].getATK() + ", DEF: " + items[rnItemNum2+4].getDEF());

            Item.equipItem1(activeItem,ch);
            System.out.println("1) Yes \n2) No");
            while(equipChoice < 1 || equipChoice > 2){
                try {equipChoice=Integer.parseInt(sc.nextLine());}
                catch(NumberFormatException e){System.out.println("Enter a number.");}
            }
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+4].getName());
                activeItem.setATK(items[rnItemNum2+4].getATK());
                activeItem.setDEF(items[rnItemNum2+4].getDEF());
                Item.equipItem2(activeItem,ch);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch);
            }
        } else if (rnItemNum < 83) { // 17% chance of getting a Rare item
            System.out.println("You got a Rare item from the chest!");
            System.out.println(items[rnItemNum2 + 8].getName()+ " - ATK: " + items[rnItemNum2+8].getATK() + ", DEF: " + items[rnItemNum2+8].getDEF());

            Item.equipItem1(activeItem,ch);
            System.out.println("1) Yes \n2) No");
            while(equipChoice < 1 || equipChoice > 2){
                try {equipChoice=Integer.parseInt(sc.nextLine());}
                catch(NumberFormatException e){System.out.println("Enter a number.");}
            }
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+8].getName());
                activeItem.setATK(items[rnItemNum2+8].getATK());
                activeItem.setDEF(items[rnItemNum2+8].getDEF());
                Item.equipItem2(activeItem,ch);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch);
            }
        } else if (rnItemNum < 94) { // 11% chance of getting an Epic item
            System.out.println("You got an Epic item from the chest!");
            System.out.println(items[rnItemNum2 + 12].getName()+ " - ATK: " + items[rnItemNum2+12].getATK() + ", DEF: " + items[rnItemNum2+12].getDEF());

            Item.equipItem1(activeItem,ch);
            System.out.println("1) Yes \n2) No");
            while(equipChoice < 1 || equipChoice > 2){
                try {equipChoice=Integer.parseInt(sc.nextLine());}
                catch(NumberFormatException e){System.out.println("Enter a number.");}
            }
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+12].getName());
                activeItem.setATK(items[rnItemNum2+12].getATK());
                activeItem.setDEF(items[rnItemNum2+12].getDEF());
                Item.equipItem2(activeItem,ch);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch);
            }
        } else { // 6% chance of getting a Legendary item
            System.out.println("You got a Legendary item from the chest!");
            System.out.println(items[rnItemNum2 + 16].getName()+ " - ATK: " + items[rnItemNum2+16].getATK() + ", DEF: " + items[rnItemNum2+16].getDEF());

            Item.equipItem1(activeItem,ch);
            System.out.println("1) Yes \n2) No");
            while(equipChoice < 1 || equipChoice > 2){
                try {equipChoice=Integer.parseInt(sc.nextLine());}
                catch(NumberFormatException e){System.out.println("Enter a number.");}
            }
            if(equipChoice == 1){
                activeItem.setName(items[rnItemNum2+16].getName());
                activeItem.setATK(items[rnItemNum2+16].getATK());
                activeItem.setDEF(items[rnItemNum2+16].getDEF());
                Item.equipItem2(activeItem,ch);
                System.out.println("You have equipped "+ activeItem.getName() + " as your active item.");
                System.out.println("With " + activeItem.getName() + " equipped, you now have " + ch.getHP() + "HP and " + ch.getStrength() + "ATK.");
            }else{
                Item.equipItem2(activeItem,ch);
            }
        }
    }
    static void equipItem1(Item activeItem, Character ch){ //Method for equipping an item which the player got from chest
        System.out.println("\nDo you want to equip this item? (You can have only one item equipped at a time)");
        if(activeItem.getName() == null){
            System.out.println("You don't have any item equipped right now.");
        }else {
            System.out.println("You have a " + activeItem.getName() + " (ATK: " + activeItem.getATK() + ", DEF: " + activeItem.getDEF() + ") equipped right now.");
        }
        ch.setHP(ch.getHP()- activeItem.getDEF());
        ch.setStrength(ch.getStrength()- activeItem.getATK());
        ch.setMaxHP(ch.getMaxHP()-activeItem.getDEF());
    }
    static void equipItem2(Item activeItem, Character ch){ //Adds the values of active item to the values of the character
        ch.setHP(ch.getHP()+activeItem.getDEF());
        ch.setStrength(ch.getStrength()+ activeItem.getATK());
        ch.setMaxHP(ch.getMaxHP()+activeItem.getDEF());
    }
}