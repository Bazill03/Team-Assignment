package dnDCharacterCreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DisplayInformation {
	/**
	 * Finds class or race description
	 * 
	 * @param input   class or race to retrieve
	 * @param isClass true to pull class info, false to pull race info
	 * @throws FileNotFoundException
	 */
	public static void getInformation(String input) throws FileNotFoundException {

		String[] classRaceInfoArray = new String[8];
		String output = "";

		try (Scanner fileInput = new Scanner(MainWindow.class.getResourceAsStream("classRaceInfo.csv"))) {
			if (fileInput.hasNextLine()) {
				for (int i = 0; i < classRaceInfoArray.length; i++) {
					String lookingForClassRace = fileInput.nextLine();
					classRaceInfoArray[i] = lookingForClassRace;
				}
			}
		}

		// HashMap of Races and classes
		HashMap<String, String> raceSet = new HashMap<>();
		raceSet.put("Troll", classRaceInfoArray[0]);
		raceSet.put("Human", classRaceInfoArray[1]);
		raceSet.put("Elf", classRaceInfoArray[2]);
		raceSet.put("Worgen", classRaceInfoArray[3]);
		raceSet.put("Mage", classRaceInfoArray[4]);
		raceSet.put("Hunter", classRaceInfoArray[5]);
		raceSet.put("Orge", classRaceInfoArray[6]);
		raceSet.put("Warrior", classRaceInfoArray[7]);

		for (Map.Entry<String, String> el : raceSet.entrySet()) {
			if (el.getKey() == input) {
				output = el.getValue();
			}
		}

		displayInformationWindow(output);
	}

	public static void displayInformationWindow(String input) {
		JOptionPane infoFrame = new JOptionPane();
		JOptionPane.showMessageDialog(infoFrame, input);
	}

}
