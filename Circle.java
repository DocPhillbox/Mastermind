package mastermind;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

/**
 * Crée une bille de couleur
 * @author BastAndr
 *
 */
public class Circle extends JPanel implements MouseListener {
	
	private Color col = Color.BLACK;	// Couleur du Circle
	private int size;					// Taille du Circle
	
	public Circle(int size) {
		super();
		this.size = size;
		initGUI();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(col);
		g.fillOval(0, 0, size, size);
	}
	
	/**
	 * Mise en place de l'interface graphique
	 */
	private void initGUI() {
		setPreferredSize(new Dimension(40, 40));
		setBackground(Color.WHITE);
	}
	
	/**
	 * Rend le Circle actif
	 */
	public void active() {
		changeBackgroundGray();
		addMouseListener(this);
	}
	
	/**
	 * Rend le Circle inactif
	 */
	public void inactive() {
		changeBackgroundWhite();
		removeMouseListener(this);
	}
	
	/**
	 * Change le background en blanc
	 */
	public void changeBackgroundWhite() {
		setBackground(Color.WHITE);
	}
	
	/**
	 * Change le background en gris
	 */
	public void changeBackgroundGray() {
		setBackground(Color.GRAY);
	}
	
	/**
	 * Change la couleur du Circle
	 * @param col Couleur a affiché
	 */
	public void setColor(Color col) {
		this.col = col;
	}
	
	/**
	 * Couleur du Circle
	 * @return Renvoie la couleur affiché dans le Circle
	 */
	public Color getColor() {
		return col;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
	
	/**
	 * Sur le click change la couleur du Circle
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		col = panelJeu.getColActuel();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
