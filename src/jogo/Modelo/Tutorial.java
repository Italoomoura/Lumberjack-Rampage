package jogo.Modelo;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tutorial extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel figura;
	
	public Tutorial() {
		
		setBounds(0, 0, 1024, 728);
		setBackground(null);
		
		figura = new JLabel();
		figura.setIcon(new ImageIcon("res//Tutorial.jpg"));
		add(figura);
	}
	
}
