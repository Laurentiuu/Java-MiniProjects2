package businessLayer;

import java.util.Scanner;

import presentationLayer.ReadFromFile;


/**
 * Clasa care contine functia main
 * @author laurg
 *
 */
public class MainClass {

	/**
	 * Functia main unde va incepe rularea programului
	 * @param args argumentele care vor dicitite. In cazul nostru este fisierul text de unde se vor lua datele(comments.txt)
	 */
	public static void main(String[] args) {
		
		// java -jar PT2020_30226_Galis_Laurentiu_Assignment_3.jar commands.txt
		for (String s : args) {
			ReadFromFile r = new ReadFromFile(s);
			
			
			System.out.println("\n\nWant to clean all tables?(yes/no)");
			Scanner sc=new Scanner(System.in);
			String in=sc.nextLine();
			if(in.equals("yes")) {
				Operations.clearAllTables();
			}
			else {
				System.out.println("Tables are unmodified");
			}
		
		}
		
	}

}
