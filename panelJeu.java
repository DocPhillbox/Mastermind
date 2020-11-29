package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Génère le panel de partie
 * @author Bastandr
 *
 */
public class panelJeu extends JPanel {
	
	private static framePrincipal frmActuel;										// Frame principal contenant les panels
	private static Mastermind mastermind;											// Jeu du mastermind
	private static Color colActuel = Color.BLACK;									// Couleur séléectionnées par défaut
	private ArrayList<Color> colors = new ArrayList<Color>();						
	private static ArrayList<Color> actualMarblesColor = new ArrayList<Color>();	// Couleurs actuels des billes
	private static ArrayList<Color> codeColors = new ArrayList<Color>();			// Couleurs du code
	private static ArrayList<Color> correcterColors = new ArrayList<Color>();		// Couleurs actuels de corrections
	private static int actuelCode = 0;												// Index de la ligne de jeu actuel
	private static Code code;														// Code du mastermind
	
	// Champs de paramètres
	private static int numberColor = 6;												// Nombre de couleurs possibles
	private static int numberMarble = 4;											// Nombre de billes
	
	public panelJeu(framePrincipal frmPrincipal) {
		super();
		panelJeu.frmActuel = frmPrincipal;
		frmActuel.setSize(700, 944);
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		mastermindInterface panelInterface = new mastermindInterface();
		
		// Reset des valeurs statiques de la classe
		actuelCode = 0;
		mastermind = new Mastermind();
		
		add(mastermind);
		add(BorderLayout.EAST, panelInterface);
		colors = panelInterface.getColors();
		code = new Code(colors);
		add(BorderLayout.SOUTH, code);
		mastermind.setActualRow();
		codeColors = code.getColor();
	}
	
	/**
	 * Affiche le panel d'acceuil dans le frame principal
	 */
	public static void goToAcceuil() {
		panelAcceuil pan = new panelAcceuil(frmActuel);
		frmActuel.changePanel(pan);
	}

	public static Color getColActuel() {
		return colActuel;
	}

	public static void setColActuel(Color colActuel) {
		panelJeu.colActuel = colActuel;
	}

	public static int getActuelCode() {
		return actuelCode;
	}

	public static void setActuelCode(int actuelCode) {
		panelJeu.actuelCode = actuelCode;
		mastermind.setActualRow();
	}

	public static ArrayList<Color> getActualMarblesColor() {
		setActualMarblesColor(mastermind.getActuelMarblesColor());
		return actualMarblesColor;
	}

	public static void setActualMarblesColor(ArrayList<Color> actualMarblesColor) {
		panelJeu.actualMarblesColor = actualMarblesColor;
	}

	public static ArrayList<Color> getCodeColors() {
		return codeColors;
	}

	public static void setCodeColors(ArrayList<Color> codeColors) {
		panelJeu.codeColors = codeColors;
	}

	public static ArrayList<Color> getCorrecterColors() {
		return correcterColors;
	}

	public static void setCorrecterColors(ArrayList<Color> correcterColors) {
		panelJeu.correcterColors = correcterColors;
		mastermind.setActuelCorrecterColor(correcterColors);
	}
	
	public static JFrame getFrame() {
		return panelJeu.frmActuel;
	}
	
	/**
	 * Affiche le code
	 */
	public static void showCode() {
		code.showCode();
	}

	public static int getNumberColor() {
		return numberColor;
	}

	public static void setNumberColor(int numberColor) {
		panelJeu.numberColor = numberColor;
	}

	public static int getNumberMarble() {
		return numberMarble;
	}

	public static void setNumberMarble(int numberMarble) {
		panelJeu.numberMarble = numberMarble;
	}
}
