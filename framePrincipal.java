package mastermind;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Génère le frame principal qui contiendra tous les panels
 * @author BastAndr
 *
 */
public class framePrincipal extends JFrame {
	
	private panelAcceuil panAcceuil;
	
	public framePrincipal() {
		super("Mastermind");
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 250);
		
		// Affichage de la page d'acceuil
		panAcceuil = new panelAcceuil(this);
		getContentPane().add(panAcceuil);
	}
	
	/**
	 * Change le panel actuellement affiché dans le JFrame
	 * @param pan JPanel a affiché
	 */
	public void changePanel(JPanel pan) {
		getContentPane().removeAll();
		getContentPane().add(pan);
	}
	
	public static void main(String[] args) {
		framePrincipal frmPrincipal = new framePrincipal();
		frmPrincipal.setVisible(true);
	}
}
