package mastermind;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * G�n�re un code de mastermind
 * @author BastAndr
 *
 */
public class Code extends JPanel{
	
	private ArrayList<Color> colors = new ArrayList<Color>();			// Toutes les couleurs possibles 
	private ArrayList<Color> code = new ArrayList<Color>();				// Couleurs composant le code
	private ArrayList<Circle> codeMarbles = new ArrayList<Circle>();	// Couleurs rentr� par l'utilisateur qui veut briser le code
	
	public Code(ArrayList<Color> col) {
		super();
		this.colors = col;
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setBackground(Color.BLACK);
		
		Random rdn = new Random();
		// Set le code couleur en choisissant une des couleurs possibles al�atoirement
		for(int i = 0; i < panelJeu.getNumberMarble(); i++) {
			int idx = rdn.nextInt(colors.size());
			code.add(colors.get(idx));
			colors.remove(idx);
		}
		
		// Cr�ation des billes de couleurs correspondant au code
		for(Color col : code) {
			Circle cir = new Circle(40);
			cir.setBackground(Color.BLACK);
			codeMarbles.add(cir);
			add(cir);
		}
	}
	
	/**
	 * Affiche les billes du code couleurs
	 */
	public void showCode() {
		for(int i = 0; i < code.size(); i++) {
			codeMarbles.get(i).setColor(code.get(i));
			codeMarbles.get(i).repaint();
		}
	}
	
	/**
	 * Couleurs composants le code
	 * @return Renvoie la liste des couleurs du code
	 */
	public ArrayList<Color> getColor() {
		return code;
	}
}
