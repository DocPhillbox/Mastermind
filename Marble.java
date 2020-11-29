package mastermind;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Génère une liste de billes
 * @author Bastandr
 *
 */
public class Marble extends JPanel {
	
	private int numMarble = panelJeu.getNumberMarble();	// Nombre de billes
	private ArrayList<Circle> marbles;					// Circle pour afficher les billes
	
	public Marble() {
		super();
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setBackground(Color.WHITE);
		
		resetMarble();
		for(Circle cir : marbles) {
			add(cir);
		}
	}
	
	/**
	 * Crée une liste de Circle correspondant aux couleurs des billes
	 */
	private void resetMarble() {
		marbles = new ArrayList<Circle>();
		for(int i = 0; i < numMarble; i++) {
			Circle cir = new Circle(40);
			marbles.add(cir);
		}
	}
	
	/**
	 * Renvoie la liste des couleurs des billes
	 * @return Liste de couleurs des billes
	 */
	public ArrayList<Color> getMarblesColor() {
		ArrayList<Color> marblesColor = new ArrayList<Color>();
		
		for(Circle cir : marbles) {
			marblesColor.add(cir.getColor());
		}
		
		return marblesColor;
	}
	
	/**
	 * Rend les Circle actif
	 */
	public void active() {
		setBackground(Color.GRAY);
		for(Circle cir : marbles) {
			cir.active();
		}
	}
	
	/**
	 * Rend les Circle inactif
	 */
	public void inactive() {
		setBackground(Color.WHITE);
		for(Circle cir : marbles) {
			cir.inactive();
		}
	}
}
