/**
 * COSC 2100 - Project 1
 * The class is a mail merger that replaces marcos
 * @author Thomas Harmeyer
 * Instructor Dr. Brylow
 * TA-BOT:MAILTO thomas.harmeyer@marquette.edu
 */

package emailPutterTogether;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner input = new Scanner(System.in);\
		File testFile = new File("C:/Users/20harmet.SDEWIN/Desktop/TestCases.txt");
		Scanner input = new Scanner(testFile);
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
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
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
				output.add(new ArrayList<String>());
				fin = start;
				for (int i = 0; i < marcosA.size(); i++) {
					fin = (fin.replaceAll(marcosA.get(i), subsA.get(y).get(i)));
				}
				output.get(y).add(fin);
			}
		}
		for (int x=0; x<subsA.size();x++) {
			for (String str : output.get(x)) {
				System.out.println(str);
			}
			System.out.println("---");
		}
		
	}
}
