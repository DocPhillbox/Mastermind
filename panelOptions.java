package mastermind;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelOptions extends JPanel {
	
	private JDialog dialog;
	private JLabel lblColorNum, lblMarbleNum;
	private JComboBox<?> cbColorNum;
	private JComboBox<?> cbMarbleNum;
	private JButton btnSave;
	private int dimWidth = 2;
	private int dimHeight = 3;
	
	public panelOptions(JDialog dlg) {
		super();
		this.dialog = dlg;
		initGUI();
	}
	
	private void initGUI() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(dimHeight, dimWidth));
		
		btnSave = new JButton("Sauvegarder");
		
		lblColorNum = new JLabel("Nombre de couleurs :");
		lblMarbleNum = new JLabel("Nombre de billes :");
		
		// Objets des ComboBox
		Object[] numColor = { 6, 7, 8, 9, 10, 11, 12 };
		Object[] marbleNum = { 4, 5, 6 };
		
		cbColorNum= new JComboBox<Object>(numColor);
		cbMarbleNum = new JComboBox<Object>(marbleNum);
		cbColorNum.setSelectedItem(panelJeu.getNumberColor());
		cbMarbleNum.setSelectedItem(panelJeu.getNumberMarble());
		
		// Ajout des événements
		btnSave.addActionListener(new eventClick_save());
		
		add(lblColorNum);
		add(cbColorNum);
		add(lblMarbleNum);
		add(cbMarbleNum);
		add(btnSave);
	}
	
	private class eventClick_save implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println(cbColorNum.getSelectedItem());
			
			// Sauvegarde des paramétres
			panelJeu.setNumberColor(Integer.parseInt(cbColorNum.getSelectedItem().toString()));
			panelJeu.setNumberMarble(Integer.parseInt(cbMarbleNum.getSelectedItem().toString()));
			dialog.dispose();
		}
	}
}
