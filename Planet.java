
import java.util.Random;

public class Planet {
	
	static Random rn = new Random();

	static String[] planets = {"Etheshan","Chuluturn","Utov","Dao R25","Thamuinides","Dypso T0","Ingend","Bitcein O9","Kokenbels","Utopianas","Thichi EQO",
			"Garvis V6","Xennion","Emzuch XY5"};
	
	
	
	static void randomPlName() {
		int random = rn.nextInt(planets.length);
		System.out.println(planets[random]);
		
	}

}
