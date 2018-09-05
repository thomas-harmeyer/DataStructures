/**
 * COSC 2100 - Project 1
 * The class is a mail merger that replaces marcos
 * @author Thomas Harmeyer
 * Instructor Dr. Brylow
 * TA-BOT:MAILTO thomas.harmeyer@marquette.edu
 */

package emailPutterTogether;

import java.util.ArrayList;
import java.util.Scanner;

public class emailParser {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		/* This section is for just the ArrayList of macros */
		// This is the first line in the test
		String marcos = input.nextLine();

		// The macros scanner
		Scanner marcosIn = new Scanner(marcos);

		// The array for the macros
		ArrayList<String> marcosA = new ArrayList<String>();

		while (marcosIn.hasNext()) {
			marcosA.add(marcosIn.next());
		}

		// The array for the things under the marcos but not the email
		ArrayList<ArrayList<String>> subsA = new ArrayList<ArrayList<String>>();
		String intheMids = input.nextLine();
		for (int x = 0; !(intheMids.equals("---")); x++) {
			Scanner intheMidsIn = new Scanner(intheMids);
			subsA.add(new ArrayList<String>());
			while (intheMidsIn.hasNext()) {
				subsA.get(x).add(intheMidsIn.next());
			}
			intheMidsIn.close();
			intheMids = input.nextLine();
		}
		marcosIn.close();
		String fin = null;
		while (input.hasNextLine()) {
			String start = input.nextLine();
			for (int y = 0; y < subsA.size(); y++) {
				fin=start;
				for (int i = 0; i < marcosA.size(); i++) {
					fin = (fin.replaceAll(marcosA.get(i), subsA.get(y).get(i)));
				}
				System.out.println(fin);
			}
		}
	}
}
