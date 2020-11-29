package mastermind;

import java.awt.Dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Génère une boite de dialogue affichant les règles du jeu
 * @author Bastandr
 *
 */
public class rulesDialog extends JDialog {
	
	public rulesDialog(JFrame frame) {
		super(frame, Dialog.ModalityType.APPLICATION_MODAL);
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		String sRules = "Mastermind - Règles \n";
		String sRules2 = "Pour gagner il faut trouver le bon code composé de 4 couleurs différentes \n";
		String sRules3 = "Si vous avez bien placé une bille le correcteur affiche la couleur rouge \n";
		String sRules4 = "Si vous avez mal placé une bille mais que la couleur est dans le code le correcteur affiche la couleur jaune \n";
		String sRules5 = "Si la couleur et pas utilisée le correcteur affiche la couleur noire \n";
		JPanel pan = new JPanel();
		JLabel lblRules = new JLabel(sRules);
		JLabel lblRules2 = new JLabel(sRules2);
		JLabel lblRules3 = new JLabel(sRules3);
		JLabel lblRules4 = new JLabel(sRules4);
		JLabel lblRules5 = new JLabel(sRules5);
		pan.add(lblRules);
		pan.add(lblRules2);
		pan.add(lblRules3);
		pan.add(lblRules4);
		pan.add(lblRules5);
		this.setSize(650, 200);
		this.getContentPane().add(pan);
		this.setVisible(true);
	}
}
