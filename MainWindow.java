package dnDCharacterCreator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JCheckBox;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	
	Random rand = new Random();
	
	Integer[] headsMale = {0,2,4,6};
	Integer[] headsFemale = {1,3,5,7};
	
	String[] races = {"Human", "Orge", "Troll", "Worgen"};
	String[] classes = {"Warrior", "Mage", "Hunter"};
	
	//Stat Labels
	JLabel lbltotalStatsLabel;
	JLabel lblStrLabel;
	JLabel lblDexLabel;
	JLabel lblConLabel;
	JLabel lblWisLabel;
	JLabel lblIntLabel;
	JLabel lblChaLabel;
	
	JComboBox raceComboBox;
	JComboBox classComboBox;
	
	JCheckBox chckbxLegendaryCheckBox;
	
	JPanel charSelectionPanel;
	JPanel controlPanel;
	private JPanel controlPanel_1;
	
	int pointsToSpend = 10;

	// Stats
	int str = 14;
	int wis = 6;
	int dex = 11;
	int intelligence = 6;
	int con = 14;
	int cha = 11;
	
	int counter = 0;
	int classCounter = 0;

	// Race, Class, Gender
	static String characterClass = "Warrior";
	static String characterRace = "Human";
	static Boolean isFemale = false;

	ButtonGroup genderGroup = new ButtonGroup();
	private JPanel displayPanel;

	private JRadioButton rdbtnWomanButton;

	private JRadioButton rdbtnManButton;

	// End temp

	public MainWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));

		displayPanel = new ChangingImgsPanel();
		contentPane.add(displayPanel);

		controlPanel_1 = createControlPanel();

	}

	private JPanel createCharSelectionPanel(JPanel controlPanel) {
		charSelectionPanel = new JPanel();
		charSelectionPanel.setPreferredSize(new Dimension(250, 110));
		charSelectionPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
		controlPanel.add(charSelectionPanel);
		charSelectionPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel raceSelectionPanel = raceSelectionPanel();

		JPanel classSelectionPanel = createClassSelectionPanel();

		JButton btnRandomizeButton = new JButton("Randomize");
		btnRandomizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int genderIndex = rand.nextInt(2);
				int bodyIndex = rand.nextInt(3);	
				
				if (genderIndex == 0) {
					isFemale = true;
					int headIndex = headsFemale[rand.nextInt(4)];
					rdbtnWomanButton.setSelected(true);
					
					counter = headIndex;
					
					if (counter == 0 || counter == 1)
						raceComboBox.setSelectedIndex(0);
					else if (counter == 2 || counter == 3)
						raceComboBox.setSelectedIndex(1);
					else if (counter == 4 || counter == 5)
						raceComboBox.setSelectedIndex(2);
					else
						raceComboBox.setSelectedIndex(3);
					
					((ChangingImgsPanel) displayPanel).changeHead(headIndex);
				} else {
					isFemale = false;
					int headIndex = headsMale[rand.nextInt(4)];
					rdbtnManButton.setSelected(true);
					
					counter = headIndex;
					
					if (counter == 0 || counter == 1)
						raceComboBox.setSelectedIndex(0);
					else if (counter == 2 || counter == 3)
						raceComboBox.setSelectedIndex(1);
					else if (counter == 4 || counter == 5)
						raceComboBox.setSelectedIndex(2);
					else
						raceComboBox.setSelectedIndex(3);
					
					((ChangingImgsPanel) displayPanel).changeHead(headIndex);
				}

				
				((ChangingImgsPanel) displayPanel).changeBody(bodyIndex);
				
				if (bodyIndex == 0)
					classComboBox.setSelectedIndex(0);
				else if (bodyIndex == 1)
					classComboBox.setSelectedIndex(1);
				else
					classComboBox.setSelectedIndex(2);
			}
		});
		btnRandomizeButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRandomizeButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRandomizeButton.setBorder(new EmptyBorder(10, 10, 10, 10));
		charSelectionPanel.add(btnRandomizeButton);

		return charSelectionPanel;
	}

	private JPanel createClassSelectionPanel() {
		JPanel classSelectionPanel = new JPanel();
		charSelectionPanel.add(classSelectionPanel);
		classSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		classComboBox = new JComboBox(classes);
		classComboBox.setBorder(new EmptyBorder(1, 0, 0, 0));
		classComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterClass = classComboBox.getSelectedItem().toString();
				
				if (characterClass == "Warrior") {
					classCounter = 0;
					((ChangingImgsPanel) displayPanel).changeBody(0);
				}
				else if (characterClass == "Mage") {
					classCounter = 1;
					((ChangingImgsPanel) displayPanel).changeBody(1);
				}
				else if (characterClass == "Hunter") {
					classCounter = 2;
					((ChangingImgsPanel) displayPanel).changeBody(2);
				}
					
				
			}
		});
		classSelectionPanel.add(classComboBox);

		JButton btnClassInfoButton = new JButton("i");
		btnClassInfoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				characterClass = classComboBox.getSelectedItem().toString();
				displayInfoFromComboBox(classComboBox, true);
			}
		});
		classSelectionPanel.add(btnClassInfoButton);

		return classSelectionPanel;
	}

	private JPanel raceSelectionPanel() {
		JPanel raceSelectionPanel = new JPanel();
		charSelectionPanel.add(raceSelectionPanel);
		raceSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		raceComboBox = new JComboBox(races);
		raceComboBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		raceComboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				characterRace = raceComboBox.getSelectedItem().toString();
				
				if (characterRace == "Human" && isFemale == false) {
					counter = 0;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Human" && isFemale == true) {
					counter = 1;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Orge" && isFemale == false) {
					counter = 2;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Orge" && isFemale == true) {
					counter = 3;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
					
				else if (characterRace == "Troll" && isFemale == false) {
					counter = 4;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Troll" && isFemale == true) {
					counter = 5;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Worgen" && isFemale == false) {
					counter = 6;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
				else if (characterRace == "Worgen" && isFemale == true) {
					counter = 7;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
					
			}
		});
		raceSelectionPanel.add(raceComboBox);

		JButton btnRaceInfoButton = new JButton("i");
		btnRaceInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				characterRace = raceComboBox.getSelectedItem().toString();
				displayInfoFromComboBox(raceComboBox, false);
			}
		});
		raceSelectionPanel.add(btnRaceInfoButton);

		return raceSelectionPanel;
	}

	private JPanel createGenderPanel() {
		JPanel GenderPanel = new JPanel();
		GenderPanel.setPreferredSize(new Dimension(250, 30));
		
		controlPanel_1.add(GenderPanel);
		
		rdbtnManButton = new JRadioButton("Man");
		genderGroup.add(rdbtnManButton);
		GenderPanel.add(rdbtnManButton);
		
		rdbtnWomanButton = new JRadioButton("Woman");
		genderGroup.add(rdbtnWomanButton);
		GenderPanel.add(rdbtnWomanButton);
	
		rdbtnManButton.setSelected(true);
		
		chckbxLegendaryCheckBox = new JCheckBox("Legendary");
		GenderPanel.add(chckbxLegendaryCheckBox);
		
		rdbtnManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFemale == true) {
					isFemale = false;
					counter-=1;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
			}
		});
		
		rdbtnWomanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFemale == false) {
					isFemale = true;
					counter+=1;
					((ChangingImgsPanel) displayPanel).changeHead(counter);
				}
			}
		});
		

		return GenderPanel;
	}

	private JPanel createStatsPanel() {
		JPanel StatsPanel = new JPanel();
		StatsPanel.setPreferredSize(new Dimension(275, 100));
		controlPanel_1.add(StatsPanel);
		StatsPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel strPanel = new JPanel();
		StatsPanel.add(strPanel);
		strPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnStrDownButton = new JButton("-");
		btnStrDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (str > 0) {
					str--;
					pointsToSpend++;
					lblStrLabel.setText("Str: " + str);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		strPanel.add(btnStrDownButton);

		lblStrLabel = new JLabel("Str: " + str);
		lblStrLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strPanel.add(lblStrLabel);

		JButton btnStrUpButton = new JButton("+");
		btnStrUpButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (pointsToSpend > 0) {
					str++;
					pointsToSpend--;
					lblStrLabel.setText("Str: " + str);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		strPanel.add(btnStrUpButton);

		JPanel wisPanel = new JPanel();
		StatsPanel.add(wisPanel);
		wisPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnWisDownButton = new JButton("-");
		btnWisDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (wis > 0) {
					wis--;
					pointsToSpend++;
					lblWisLabel.setText("Wis: " + wis);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		wisPanel.add(btnWisDownButton);

		lblWisLabel = new JLabel("Wis: " + wis);
		lblWisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wisPanel.add(lblWisLabel);

		JButton btnWisUpButton = new JButton("+");
		btnWisUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pointsToSpend > 0) {
					wis++;
					pointsToSpend--;
					lblWisLabel.setText("Wis: " + wis);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		wisPanel.add(btnWisUpButton);

		JPanel dexPanel = new JPanel();
		StatsPanel.add(dexPanel);
		dexPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnDexDownButton = new JButton("-");
		btnDexDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dex > 0) {
					dex--;
					pointsToSpend++;
					lblDexLabel.setText("Dex: " + dex);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		dexPanel.add(btnDexDownButton);

		lblDexLabel = new JLabel("Dex: " + dex);
		lblDexLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dexPanel.add(lblDexLabel);

		JButton btnDexUpButton = new JButton("+");
		btnDexUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pointsToSpend > 0) {
					dex++;
					pointsToSpend--;
					lblDexLabel.setText("Dex: " + dex);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		dexPanel.add(btnDexUpButton);

		JPanel intPanel = new JPanel();
		StatsPanel.add(intPanel);
		intPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnIntDownButton = new JButton("-");
		btnIntDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (intelligence > 0) {
					intelligence--;
					pointsToSpend++;
					lblIntLabel.setText("Int: " + intelligence);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		intPanel.add(btnIntDownButton);

		lblIntLabel = new JLabel("Int: " + intelligence);
		lblIntLabel.setHorizontalAlignment(SwingConstants.CENTER);
		intPanel.add(lblIntLabel);

		JButton btnIntUpButton = new JButton("+");
		btnIntUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pointsToSpend > 0) {
					intelligence++;
					pointsToSpend--;
					lblIntLabel.setText("Int: " + intelligence);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		intPanel.add(btnIntUpButton);

		JPanel conPanel = new JPanel();
		StatsPanel.add(conPanel);
		conPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnConDownButton = new JButton("-");
		btnConDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (con > 0) {
					con--;
					pointsToSpend++;
					lblConLabel.setText("Con: " + con);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		conPanel.add(btnConDownButton);

		lblConLabel = new JLabel("Con: " + con);
		lblConLabel.setHorizontalAlignment(SwingConstants.CENTER);
		conPanel.add(lblConLabel);

		JButton btnConUpButton = new JButton("+");
		btnConUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pointsToSpend > 0) {
					con++;
					pointsToSpend--;
					lblConLabel.setText("Con: " + con);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		conPanel.add(btnConUpButton);

		// Best stat
		JPanel chaPanel = new JPanel();
		StatsPanel.add(chaPanel);
		chaPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JButton btnChaDownButton = new JButton("-");
		btnChaDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cha > 0) {
					cha--;
					pointsToSpend++;
					lblChaLabel.setText("Cha: " + cha);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		chaPanel.add(btnChaDownButton);

		lblChaLabel = new JLabel("Cha: " + cha);
		lblChaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chaPanel.add(lblChaLabel);

		JButton btnChaUpButton = new JButton("+");
		btnChaUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pointsToSpend > 0) {
					cha++;
					pointsToSpend--;
					lblChaLabel.setText("Cha: " + cha);
					lbltotalStatsLabel.setText("Points: " + pointsToSpend);
				}
			}
		});
		chaPanel.add(btnChaUpButton);

		lbltotalStatsLabel = new JLabel("Points: " + pointsToSpend);
		lbltotalStatsLabel.setPreferredSize(new Dimension(100, 14));
		StatsPanel.add(lbltotalStatsLabel);

		return StatsPanel;
	}

	private JPanel createCharacterResetPanel() {
		JPanel createCharacterResetPanel = new JPanel();
		controlPanel_1.add(createCharacterResetPanel);

		JButton btnCreateCharacterButton = new JButton("Create");
		btnCreateCharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create character Object
				String characterName = (String)JOptionPane.showInputDialog(
			               contentPane,
			               "What is thy name adventurer?", 
			               "Character Name",            
			               JOptionPane.PLAIN_MESSAGE,
			               null,            
			               null, 
			               "Lightsong The Bold"
			            );
				Boolean isLegendary;
				if(chckbxLegendaryCheckBox.isSelected()) {
					isLegendary = true;
				} else {
					isLegendary = false;
				}
				Character newChar = new Character(characterName, characterClass, characterRace, str, wis, dex, intelligence, con, cha,
						isFemale, isLegendary);
				newChar.createCharacter();
			}
		});
		createCharacterResetPanel.add(btnCreateCharacterButton);

		JButton btnResetCharacterButton = new JButton("Reset");
		btnResetCharacterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				counter = 0;
				classComboBox.setSelectedIndex(0);
				raceComboBox.setSelectedIndex(0);
				((ChangingImgsPanel) displayPanel).changeHead(0);
				((ChangingImgsPanel) displayPanel).changeBody(0);
				rdbtnManButton.setSelected(true);
				str = 14;
				wis = 6;
				dex = 11;
				intelligence = 6;
				con = 14;
				cha = 11;
				lblStrLabel.setText("Str: " + str);
				lblWisLabel.setText("Wis: " + wis);
				lblDexLabel.setText("Dex: " + dex);
				lblIntLabel.setText("Int: " + intelligence);
				lblConLabel.setText("Con: " + con);
				lblChaLabel.setText("Cha: " + cha);
				
			}
		});
		createCharacterResetPanel.add(btnResetCharacterButton);

		return createCharacterResetPanel;
	}

	private JPanel createControlPanel() {
		controlPanel_1 = new JPanel();
		contentPane.add(controlPanel_1);

		JPanel charSelectionPanel = createCharSelectionPanel(controlPanel_1);

		JPanel GenderPanel = createGenderPanel();

		JPanel StatsPanel = createStatsPanel();

		JPanel createCharacterResetPanel = createCharacterResetPanel();

		return controlPanel_1;
	}

	/**
	 * Displays class/race info in a new window.
	 * 
	 * @param box     Combo box to pull information from.
	 * @param isClass True if class, false if race.
	 */
	private void displayInfoFromComboBox(JComboBox<?> box, Boolean isClass) {

		// Gets the race or class in the combobox and converts it to a string.
		String findDesc = box.getSelectedItem().toString();

		// Opens a window.
		try {
			DisplayInformation.getInformation(findDesc);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Raises or lowers a characters stat and updates the main window.
	 * 
	 * @param stat    Stat to be raised or lowered
	 * @param label   Label associated with stat.
	 * @param toRaise True if raising, false if lowering.
	 */
	private void raiseOrLowerStat(int stat, String statName, JLabel label, Boolean toRaise) {

		if (toRaise == true) {
			if (pointsToSpend > 0) {
				stat++;
				System.out.println("Setting " + stat);
				pointsToSpend--;
				label.setText(statName + ": " + stat);
				System.out.println("Attempting to set text for " + label.getText());
				lbltotalStatsLabel.setText("Points: " + pointsToSpend);
			}
		}
		if (toRaise == false) {
			if (stat > 0) {
				stat--;
				pointsToSpend++;
				label.setText(statName + ": " + stat);
				lbltotalStatsLabel.setText("Points: " + pointsToSpend);
			}
		}
	}

}
