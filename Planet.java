import java.util.Random;

public class Planet {

    static Random rn = new Random();

    static String[] planets = {"Etheshan","Chuluturn","Utov","Dao R25",
            "Thamuinides","Dypso T0","Ingend",
            "Bitcein O9","Kokenbels","Utopianas",
            "Thichi EQO","Garvis V6","Xennion",
            "Emzuch XY5","Strepaturn","Zigantsus"};

    static String randomPlName() {   //Vybere nahodne jmeno planety z pole Stringu
        int randomNum = rn.nextInt(planets.length);
        return planets[randomNum];
    }

    static String[] planetDesc = {"It's freezing cold here. After arriving, you try to look around but all you can see is ice.",
            "This planet is covered with lava and full of volcanoes, with average temperature of " + (rn.nextInt(100)+50) + "°C, " +
            "luckily your special suit allows you to move freely on this planet.",
            "This planet is "+(rn.nextInt(30)+70)+"% covered with water. You see some lights coming from the depths of the water.",
            "This planet is covered with forests. The vegetation looks very different from Earth's though.",
            "Upon arriving, you notice beautiful rings surrounding this planet.",
            "One of the most developed civilizations once lived on this planet. Now, all you can see is ruins.",
            "One night on this planet lasts over "+ (rn.nextInt(100)+1) +" Earth days. " +
            "The only source of light are the planet's "+ (rn.nextInt(50)+2) + " moons.",
            "You've heard a lot of wierd sounds after arriving to this planet."

    };

    static String randomPlDesc() {   //Vybere nahodny popis planety z pole Stringu
        int randomNum2 = rn.nextInt(planetDesc.length);
        return planetDesc[randomNum2];
    }

    static void direction(boolean N, boolean S, boolean E, boolean W) { //Vymaze z vyberu ty smery, ktere hrac jiz prozkoumal
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

        System.out.println("\nYou have a choice to go:");
        System.out.println(North + South + East + West);
        System.out.println("Which direction are you going?");
    }

    static String[] places = {"a temple", "a crashed spaceship", "city ruins", "a hostile watchtower"};

    static String randomPlace() {   //Vybere nahodnou lokaci z pole Stringu
        int randomNum3 = rn.nextInt(places.length);
        return places[randomNum3];
    }
}
