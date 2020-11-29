package mastermind;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Génère le panel d'acceuil pour lancer une partie
 * @author Bastandr
 *
 */
public class panelAcceuil extends JPanel{
	
	private framePrincipal actualFrame;
	private JLabel lblAcceuil;
	private JButton btnNewGame, btnOptions, btnRegles;
	private BoxLayout bl;
	private Component vs1, vs2, vs3;
	private panelJeu panJeu;
	
	public panelAcceuil(framePrincipal frmPrincipal) {
		super();
		actualFrame = frmPrincipal;
		frmPrincipal.setSize(600, 250);
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setBackground(Color.WHITE);
		
		lblAcceuil = new JLabel("Bienvenue dans le jeu du Mastermind");
		btnNewGame = new JButton("Nouvelle partie");
		btnOptions = new JButton("Options");
		btnRegles = new JButton("Règles");
		
		bl = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(bl);
		
		// Positionnement des composants
		// Cette méthode permet d'aligner dans un boxlayout
		vs1 = Box.createVerticalStrut(20);
		vs2 = Box.createVerticalStrut(20);
		vs3 = Box.createVerticalStrut(20);
		lblAcceuil.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRegles.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(lblAcceuil);
		add(vs1);
		add(btnNewGame);
		add(vs2);
		add(btnOptions);
		add(vs3);
		add(btnRegles);
		
		// Ajout des évènements
		btnNewGame.addActionListener(new eventClick_NewGame());
		btnRegles.addActionListener(new eventClick_rules());
		btnOptions.addActionListener(new eventClick_options());
	}
	
	/**
	 * Génère un event pour lancer une partie
	 * @author Bastandr
	 *
	 */
	private class eventClick_NewGame implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Affichage du panelJeu
			
			panJeu = new panelJeu(actualFrame);
			actualFrame.changePanel(panJeu);
		}
		
	}
	
	/**
	 * Génère un event pour afficher les règles
	 * @author BAstandr
	 *
	 */
	private class eventClick_rules implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			rulesDialog dlg = new rulesDialog(actualFrame);
		}
	}
	
	/**
	 * Génère un event pour afficher les options
	 * @author 226-18
	 *
	 */
	private class eventClick_options implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog option = new JDialog(actualFrame, "Options", true);
			option.getContentPane().add(new panelOptions(option));
			option.setSize(400, 200);
			option.setVisible(true);
		}
	}
}
