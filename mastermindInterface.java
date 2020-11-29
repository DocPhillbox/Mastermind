package mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Génère l'interface de jeu du mastermind
 * @author Bastandr
 *
 */
public class mastermindInterface extends JPanel{
	
	private JButton btnRegles, btnAbandonner, btnGuess;	// Boutons du jeu
	private colorPicker colPicker = new colorPicker();	// Objets pour choisir les couleurs
	
	public mastermindInterface() {
		super();
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setPreferredSize(new Dimension(200, 944));
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		btnAbandonner = new JButton("Abandonner");
		btnGuess = new JButton("Briser le code");
		btnRegles = new JButton("Règles");
		
		// Ajout des events
		btnGuess.addActionListener(new event_guessClick());
		btnRegles.addActionListener(new event_rulesClick());
		btnAbandonner.addActionListener(new event_giveupClick());
		
		add(btnRegles);
		add(btnAbandonner);
		add(btnGuess);
		add(colPicker);
	}
	
	/**
	 * Génère l'événement du bouton guess
	 * Permet d'essayer de briser le code
	 * @author BastAndr
	 *
	 */
	private class event_guessClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int iNumCorrect = 0;
			ArrayList<Color> marblesColor = panelJeu.getActualMarblesColor();
			ArrayList<Color> codeColor = panelJeu.getCodeColors();
			ArrayList<Color> correcterColor = new ArrayList<Color>();
			
			// ArrayList pour le tri
			ArrayList<Color> correcterColorSorted = new ArrayList<Color>();
			Color[] colorsCorrecter = {Color.RED, Color.YELLOW, Color.BLACK};
			
			// Test si le code est bon
			for(int i = 0; i < marblesColor.size(); i++) {
				if(marblesColor.get(i) == codeColor.get(i)) {
					correcterColor.add(Color.RED);
				} else if(codeColor.contains(marblesColor.get(i))) {
					correcterColor.add(Color.YELLOW);
				} else {
					correcterColor.add(Color.BLACK);
				}
			}
			
			// Tri de la liste dans un certains ordre
			// Rouge <- Jaune <- Noir
			for(Color corrCol : colorsCorrecter) {
				for(Color col : correcterColor) {
					if(corrCol.equals(col)) {
						correcterColorSorted.add(col);
					}
				}
			}
			
			// Afficher la correction
			panelJeu.setCorrecterColors(correcterColorSorted);
			
			for(Color col : correcterColor) {
				if(col == Color.RED) {
					iNumCorrect++;
				}
			}
			
			if(iNumCorrect == panelJeu.getNumberMarble()) {
				// Le code a été brisé
				panelJeu.showCode();
				JOptionPane.showMessageDialog(panelJeu.getFrame(), "Vous avez gagné");
				panelJeu.goToAcceuil();
			} else if(panelJeu.getActuelCode() < 11) {
				panelJeu.setActuelCode(panelJeu.getActuelCode() + 1);
			} else {
				panelJeu.showCode();
				JOptionPane.showMessageDialog(panelJeu.getFrame(), "Vous avez perdu");
				panelJeu.goToAcceuil();
			}
		}
	}
	
	/**
	 * Génère l'événement du bouton rules
	 * Affiche les règles du jeu
	 * @author Bastandr
	 *
	 */
	private class event_rulesClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rulesDialog dlg = new rulesDialog(panelJeu.getFrame());
		}
	}
	
	/**
	 * Génère l'événement du bouton giveup
	 * Affiche une fenêtre d'abandon
	 * @author Bastandr
	 *
	 */
	private class event_giveupClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Object[] options = { "Oui", "Non"};
			int n = JOptionPane.showOptionDialog(panelJeu.getFrame(), "Voulez-vous abandonner la partie ?", "Abandonner", 
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(n == JOptionPane.YES_OPTION) {
				panelJeu.goToAcceuil();
			}
		}
	}
	
	/**
	 * Renvoie les couleurs possibles
	 * @return Liste de couleurs
	 */
	public ArrayList<Color> getColors() {
		return colPicker.getColors();
	}
}
