package dnDCharacterCreator;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

public class ChangingImgsPanel extends JPanel {

	private int headIndex = 0;
	private int bodyIndex = 0;
	
	ImageIcon humanMale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/HumanMale Transparent.png"));
	ImageIcon humanFemale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/HumanFemale Transparent.png"));
	ImageIcon orgeMale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/OrgeMale Transparent.png"));
	ImageIcon orgeFemale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/OrgeFemale Transparent.png"));
	ImageIcon trollMale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/TrollMale Transparent.png"));
	ImageIcon trollFemale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/TrollFemale Transparent.png"));
	ImageIcon worgenMale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/WorgenMale Transparent.png"));
	ImageIcon worgenFemale = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/WorgenFemale Transparent.png"));
	
	ImageIcon warriorBody = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/Warrior Transparent.png"));
	ImageIcon mageBody = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/Mage Transparent.png"));
	ImageIcon hunterBody = new ImageIcon(MainWindow.class.getResource("/dnDCharacterCreator/Images/Hunter Transparent.png"));
	
	//ImageIcon[] maleHeads = {humanMale, orgeMale, trollMale, worgenMale};
	//ImageIcon[] femaleHeads = {humanFemale, orgeFemale, trollFemale, worgenFemale};
	
	ImageIcon[] heads = {humanMale, humanFemale, orgeMale, orgeFemale, trollMale, trollFemale, worgenMale, worgenFemale};
	ImageIcon[] bodies = {warriorBody, mageBody, hunterBody};
	
       /**
	* Change the index of the collection of heads for the paintComponent method.
	*/
	public void changeHead(int i) {
		headIndex = i;
		repaint();
	}
	
       /**
	* Change the index of the collection of the bodies for the paintComponent method.
	*/
	public void changeBody(int i) {
		bodyIndex = i;
		repaint();
	}
	
       /**
	* Display the combination of the race(head) and class(body) on the screen. 
	*/
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		bodies[bodyIndex].paintIcon(this, g, -35, -30);
		heads[headIndex].paintIcon(this, g, -40, -65);
		
	}
	
	/**
	 * Create the panel.
	 */
	public ChangingImgsPanel() {
		
	}

}
