package mastermind;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 * Génère un jeu de Mastermind
 * @author Bastandr
 *
 */
public class Mastermind extends JPanel {
	
	private ArrayList<mastermindRow> rows;	// Lignes de Mastermind
	private int numRows = 12;				// Nombre de lignes
	
	public Mastermind() {
		super();
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		BoxLayout bl = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(bl);
		
		resetRows();
		for(mastermindRow row : rows) {
			add(row);
		}
	}
	
	/**
	 * Crée une liste de lignes
	 */
	private void resetRows() {
		// Ajout des lignes du mastermind
		rows = new ArrayList<mastermindRow>();
		for(int i = 0; i < numRows; i++) {
			mastermindRow mr = new mastermindRow();
			rows.add(mr);
		}
	}
	
	/**
	 * Set la ligne de jeu actuellement jouable
	 */
	public void setActualRow() {
		int code = panelJeu.getActuelCode();
		if(code > 0) {
			rows.get(code - 1).inactive();
		}
		rows.get(code).active();
	}
	
	/**
	 * Renvoie la liste des couleurs des billes
	 * @return Liste de couleurs
	 */
	public ArrayList<Color> getActuelMarblesColor() {
		int code = panelJeu.getActuelCode();
		return rows.get(code).marbles.getMarblesColor();
	}
	
	/**
	 * Set les couleurs des correcteurs actuels
	 * @param cols Liste de couleurs pour les billes de corrections
	 */
	public void setActuelCorrecterColor(ArrayList<Color> cols) {
		int code = panelJeu.getActuelCode();
		rows.get(code).correcter.changeColor(cols);
	}
}
