import java.util.Scanner;

public class Shop {

    static Scanner sc = new Scanner(System.in);

    static public void shop(Character ch, Item activeItem, int maxHP) { //Metoda pro nakup ruznych itemu v obchode
        int shopYN;
        int shopChoice = 0;
        System.out.println("\nIn your spaceship you have a option to buy items in a shop with your credits.");
        System.out.println("Do you want to buy any items? \n1) Yes \n2) No");
        shopYN = sc.nextInt();
        if (shopYN == 1) {
            while (shopChoice != 4) {
                System.out.println("\nWhat do you want to buy?");
                System.out.println("1) Health potion (20 Credits)\n2) Strength potion (20 Credits)\n3) A chest with a random item (30 Credits)\n4) Leave shop");
                System.out.println("\nYou have " + ch.getCredit() + " Credits.");
                shopChoice = sc.nextInt();
                switch (shopChoice) {
                    case 1:
                        if (ch.getCredit() > 19) {
                            ch.sethPotion(ch.gethPotion() + 1);
                            ch.setCredit(ch.getCredit() - 20);
                            System.out.println("You have bought a health potion and you have " + ch.gethPotion() + " health potions.");
                        } else {
                            System.out.println("Sadly, you don't have enough credits to buy this item.");
                        }
                        break;
                    case 2:
                        if (ch.getCredit() > 19) {
                            ch.setsPotion(ch.getsPotion() + 1);
                            ch.setCredit(ch.getCredit() - 20);
                            System.out.println("You have bought a strength potion and now you have " + ch.getsPotion() + " strength potions.");
                        } else {
                            System.out.println("Sadly, you don't have enough credits to buy this item.");
                        }
                        break;
                    case 3:
                        if (ch.getCredit() > 29) {
                            ch.setCredit(ch.getCredit() - 30);
                            System.out.println("You have bought a chest.");
                            Item.openChest(activeItem, ch, maxHP);
                        } else {
                            System.out.println("Sadly, you don't have enough credits to buy this item.");
                        }
                        break;
                }
            }
        }
    }
}