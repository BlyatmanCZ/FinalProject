import java.util.Random;
import java.util.Scanner;

public class Planet {

    static Random rn = new Random();
    static Scanner sc = new Scanner(System.in);

    static String[] planets = {
            "Etheshan","Chuluturn","Utov",
            "Thamuinides","Dypso T0","Ingend",
            "Biaecin Y9","Koknbelss","Utopianas",
            "Thichi-EQO","Garvis V6","Xennion",
            "Emzuch XY5","Strepaturn","Zigantsus",
            "Yairtis II", "Nunov", "Gloria Q33T",
            "Xudrone", "Lluumia", "Gort",
            "Vuganov", "JSH-2077", "Eo",
            "Vora DS2", "Mig05", "Xe'tara",
            "Sonvania", "Oveaux","Dao R25"};

    static String randomPlName() {   //Chooses a random planet name form the array of strings
        int randomNum = rn.nextInt(planets.length);
        return planets[randomNum];
    }

    static String[] planetDesc = {"It's freezing cold here. After arriving, you try to look around but all you can see is ice.",
            "This planet is covered with lava and full of volcanoes, with average temperature of " + (rn.nextInt(100)+50) + "°C, " +
            "luckily your special suit allows you to move freely on this planet.",
            "This planet is "+(rn.nextInt(30)+70)+"% covered with water. You see some lights coming from the depths of the water.",
            "This planet is covered with forests and jungles. The vegetation looks very different from Earth's though.",
            "Upon arriving, you notice beautiful rings surrounding this planet.",
            "One of the most developed civilizations once lived on this planet. Now, all you can see is ruins.",
            "One night on this planet lasts over "+ (rn.nextInt(100)+1) +" Earth days. " +
            "The only source of light are the planet's "+ (rn.nextInt(50)+2) + " moons.",
            "You've heard a lot of wierd sounds after arriving to this planet.",
            "This small planet is fully covered with sand. Deserts and sandstorms are pretty much all you can see.",
            "The air on this planet is very humid. You see some weird-looking jungles in the distance.",
            "It seems that nothing much was left off from the previous civilizations living on this planet",
            "Legend has it, that one of the ancient nicknames of this planet was 'The Planet of Gods'.",
            "This dark and rocky planet is " + (rn.nextInt(30)+50) + "% covered with mountains. Traveling here isn't easy."
    };

    static String randomPlDesc() {   //Chooses a random planet description form the array of strings
        int randomNum2 = rn.nextInt(planetDesc.length);
        return planetDesc[randomNum2];
    }

    static void direction(boolean N, boolean S, boolean E, boolean W) { //A method that deletes the directions that the player has already explored from the selection
        String North = "1) North, ";
        String South = "2) South, ";
        String East = "3) East, ";
        String West = "4) West";

        if(!N){
            North = "";
        }if(!S) {
            South = "";
        }if(!E) {
            East = "";
        }if(!W) {
            West = "";
        }

        if(N && S && E && W){
            System.out.println("You decide to explore the planet.");
        }else {
            System.out.println("-----------------------------\nYou decide to explore the planet in some other direction.");
        }
        System.out.println("\nYou have a choice to go:");
        System.out.println(North + South + East + West);
        System.out.println("Which direction are you going?");

    }

    static String[] battlePlaces = {"a temple", "a crashed spaceship", "city ruins", "a hostile watchtower",
            "a hostile fortress", "an abandoned observatory", "an old laboratory", "an enemy hideout",
            "a small alien settlement", "a hostile outpost"
    };

    static String randomBattlePlace() {   //Chooses a random battle place name form the array of strings
        int randomNum3 = rn.nextInt(battlePlaces.length);
        return battlePlaces[randomNum3];
    }
    static void friendlyScientist(Character ch, Item activeItem){ //A method for a friendly scientist which a player may encounter
        int rnScientistNum = rn.nextInt(3);
        System.out.println("\nAfter some time exploring, you have met a friendly scientist.");
        if(rnScientistNum == 0) {
            System.out.println("The scientist gave you a free health potion for your journey on this planet.");
            ch.sethPotion(ch.gethPotion()+1);
            System.out.println("You now have " + ch.gethPotion() + " health potions in your inventory.");
        }else if(rnScientistNum == 1){
            System.out.println("The scientist gave you a free strength potion for your journey on this planet.");
            ch.setsPotion(ch.getsPotion()+1);
            System.out.println("You now have " + ch.getsPotion() + " strength potions in your inventory.");
        }else {
            System.out.println("The scientist gave you a free chest with a random item inside.");
            System.out.println("Do you want to open this chest? \n1) Yes \n2) No");
            int YNChoice = 0;
            while(YNChoice < 1 || YNChoice > 2){
                try {
                    YNChoice=Integer.parseInt(sc.nextLine());
                }
                catch(NumberFormatException e){
                    System.out.println("Enter a number.");
                }
            }
            if(YNChoice == 1){
                Item.openChest(activeItem, ch);
            }else {
                System.out.println("You have declined a free chest from the scientist.");
            }
        }
        System.out.println("\nYou return to your landing site.");

    }
    static void gameEnd(Character ch, String name) { //After five saved planets, this method gives the player an option to end the game or to continue
        System.out.println("-----------------------------\nCongratulations, you have successfully saved 5 planets from evil aliens.");
        System.out.println("You now have an option to continue playing in infinity mode or you can finish the game now to see your score.");
        System.out.println("1) End the game\n2) Infinity mode");

        int endChoice = 0;
        try {
            endChoice=Integer.parseInt(sc.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("Enter a number.");
        }
        if(endChoice == 1){
            System.out.println("-----------------------------\nYOU WON!");
            System.out.println("\n" + name + " - Total score: " + ch.getScore()) ;
            System.out.println("\nYou really became the savior of your galaxy.");
            ch.setHP(0);
        }else{
            System.out.println("You have decided to continue in your journey to save more planets.");
        }
    }
}
