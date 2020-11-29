package mastermind;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Génère une ligne de mastermind
 * @author Bastandr
 *
 */
public class mastermindRow extends JPanel {
	
	public Marble marbles;					// Billes de jeu
	public mastermindCorrecter correcter;	// Billes de correction
	
	public mastermindRow() {
		super();
		initGUI();
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setPreferredSize(new Dimension(400, 75));
		BorderLayout bl = new BorderLayout();
		setLayout(bl);
		
		marbles = new Marble();
		marbles.setAlignmentY(Component.CENTER_ALIGNMENT);
		correcter = new mastermindCorrecter();
		
		add(BorderLayout.CENTER, marbles);
		add(BorderLayout.EAST, correcter);
	}
	
	/**
	 * Active les billes et les correcters
	 */
	public void active() {
		marbles.active();
		correcter.active();
	}
	
	/**
	 * Désactive les billes et les correcters
	 */
	public void inactive() {
		marbles.inactive();
		correcter.inactive();
	}
}
