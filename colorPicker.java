package mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Génère une grille de couleur que lôn peut sélectionner
 * @author Bastandr
 *
 */
public class colorPicker extends JPanel implements ActionListener {
	
	private ArrayList<Color> colors;					// Liste des couleurs possibles
	private int numColor = panelJeu.getNumberColor();	// Nombre de couleur possibles
	private int dimWidth;								// Dimension horizontale
	private int dimHeight;								// Dimension verticale
	
	public colorPicker() {
		super();
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		resetColor();
		setLayout(new GridLayout(dimHeight, dimWidth));
		
		// Affiche les boutons contenant les couleurs possibles
		for(Color col : colors) {
			JButton b = new JButton();
			b.setBackground(col);
			b.addActionListener(this);
			add(b);
		}
	}
	
	/**
	 * Crée une liste de couleurs aléatoires
	 */
	private void resetColor() {
		colors = new ArrayList<Color>();
		Random rdm = new Random();
		for(int i = 0; i < numColor; i++) {
			Color col = new Color(rdm.nextInt(255), rdm.nextInt(255), rdm.nextInt(255));
			colors.add(col);
		}
		setDim();
	}
	
	/**
	 * Définit les dimensions du GridLayout
	 */
	private void setDim() {
		// Test si le nombre de couleurs et pair
		if(numColor % 2 == 0) {
			dimWidth = 2;
			dimHeight = numColor / 2;
		} else {
			dimWidth = 2;
			dimHeight = (numColor + 1) / 2;
		}
	}
	
	/**
	 * Sur le click du bouton set la couleur sélectionnée pour colorer les billes
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		panelJeu.setColActuel(btn.getBackground());
	}
	
	/**
	 * Renvoie la liste des couleurs possibles
	 * @return Liste des couleurs possibles
	 */
	public ArrayList<Color> getColors() {
		return colors;
	}
}
