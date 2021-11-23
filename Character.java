import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates a character and allows the program to print out a document, or request information about the character such as class, race, and stats.
 * @author Zachary English.
 *
 */
public class Character {
	
	String characterClass;
	String characterRace;
	int str;
	int wis;
	int dex;
	int intelligence;
	int con;
	int cha;
	Boolean isFemale;
	List<Integer> statList = new ArrayList<>();
	
	/**
	 * Creates a character object.
	 * @param characterClass Class of the character.
	 * @param characterRace Race of the character.
	 * @param str Strength
	 * @param wis Wisdom
	 * @param dex Dexterity
	 * @param intelligence Intelligence
	 * @param con Constitution
	 * @param cha Charisma
	 */
	public Character(String characterClass, String characterRace, int str, int wis, int dex, int intelligence, int con, int cha, Boolean isFemale) {
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.str = str;
		this.wis = wis;
		this.dex = dex;
		this.intelligence = intelligence;
		this.con = con;
		this.cha = cha;
		this.isFemale = isFemale;
		Collections.addAll(this.statList, this.str, this.wis, this.dex, this.intelligence, this.con, this.cha);
	}
	
	
	static public int[] getDefaultStats(String playerRaceOrClass) {
		
		int[] baseStats = {10,10,10,10,10,10};
		int[] outputStats = baseStats;
		//player stat order: str, wis, dex, int, con, cha
		int[] humanStats = {2,-1,2,-1,1,3};
		int[] trollStats = {2,-2,2,-2,-1,-1};
		int[] elfStats = {-2,2,1,2,-2,0};
		int[] worgenStats = {3,-2,2,-1,1,0};
		
		//Change stats based on class
		int[] warriorStats = {2,-3,-1,-3,3,-2};
		int[] mageStats = {-2,2,-1,2,-2,0};
		int[] hunterStats = {0,0,2,0,0,1};
		int[] paladinStats = {1,1,-2,0,2,0};
		
		Map<String, int[]> raceSet = new HashMap<>();
		
		// HashMap of Races and classes
		raceSet.put("Troll", trollStats);
		raceSet.put("Human", humanStats);
		raceSet.put("Elf", elfStats);
		raceSet.put("Worgen", worgenStats);
		raceSet.put("Mage", mageStats);
		raceSet.put("Hunter", hunterStats);
		raceSet.put("Paladin", paladinStats);
		raceSet.put("Warrior", warriorStats);
	
		for(Map.Entry<String, int[]> el : raceSet.entrySet()){
			if(el.getKey() == playerRaceOrClass) {
				for(int i = 0; i < el.getValue().length; i++) {
					outputStats[i] += el.getValue()[i];
				}
			}
		}
		
		
		return outputStats;
	}
	
	
	/**
	 * Creates a character file given a character object.
	 */
	public void createCharacter() {
		System.out.println("Creating file...");
		String fileName = this.characterRace + this.characterClass;
		String[] statOrder = {"Strength: ","Wisdom: ","Dexterity: ","Intelligence: ","Constitution: ","Charisma: "};
		File output = new File(fileName);
		
		try {
			PrintWriter print = new PrintWriter(output);
			if(isFemale == true) {
				System.out.println("Character is female");
				print.write("Female " + characterRace + " " + characterClass);				
			} else if(isFemale == false) {
				print.write("Male " + characterRace + " " + characterClass);
				System.out.println("Character is male");
			}

			print.println();

			for(int i = 0; i < statOrder.length; i++) {
				print.write(statOrder[i] + this.statList.get(i));
				print.println();
			}
			print.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
}
