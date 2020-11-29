package mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Génère les correcters du mastermind
 * @author Bastandr
 *
 */
public class mastermindCorrecter extends JPanel {
	
	private int numBille = panelJeu.getNumberMarble();	// Nombre de billes de corrections
	private int dimWidth;								// Dimension horizontale
	private int dimHeight;								// Dimension verticale
	private ArrayList<Circle> billesCorrecter;			// Liste des billes de corrections
	
	public mastermindCorrecter() {
		super();
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		// Génère les billes dans la liste
		resetMarble();
		
		// Affiches les billes dans le panel
		GridLayout gl = new GridLayout(dimHeight, dimWidth);
		setLayout(gl);
		for(Circle cir : billesCorrecter) {
			add(cir);
		}
	}
	
	/**
	 * Crée une liste de billes pour la correction
	 */
	private void resetMarble() {
		billesCorrecter = new ArrayList<Circle>();
		for(int i = 0; i < numBille; i++) {
			Circle cir = new Circle(30);
			billesCorrecter.add(cir);
		}
		setDim();
	}
	
	/**
	 * Définit les dimensions du GridLayout
	 */
	private void setDim() {
		// Test si le nombre de billes et pair
		if(numBille % 2 == 0) {
			dimWidth = numBille / 2;
			dimHeight = 2;
		} else {
			dimWidth = (numBille + 1) / 2;
			dimHeight = (numBille - 1) / 2;
		}
	}
	
	/**
	 * Change la couleur des billes de corrections
	 * @param lstCol Liste de couleur a affiché
	 */
	public void changeColor(ArrayList<Color> lstCol) {
		for(int i = 0; i < lstCol.size(); i++) {
			billesCorrecter.get(i).setColor(lstCol.get(i));
			billesCorrecter.get(i).repaint();
		}
	}
	
	/**
	 * Active les billes
	 */
	public void active() {
		for(Circle cir : billesCorrecter) {
			cir.changeBackgroundGray();
		}
	}
	
	/**
	 * Désactive les billes
	 */
	public void inactive() {
		for(Circle cir : billesCorrecter) {
			cir.changeBackgroundWhite();
		}
	}
}
