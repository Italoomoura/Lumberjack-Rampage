package jogo;

import javax.swing.JFrame;
import jogo.Modelo.Menu;
import jogo.Modelo.Tutorial;
import jogo.Modelo.Fase;
import jogo.Modelo.Historia;

public class ContainerGame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public ContainerGame(int x) {
		
		tela(x);
		
		setTitle("Lumberjack Rampage");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public void tela(int x) {
		switch (x){
			case 1:
				setSize(1024,728);
				add(new Menu());
				break;
			case 2:
				setSize(1024,728);
				add(new Fase());
				break;
			case 3:
				setSize(1024,748);
				add(new Historia());
				break;
			case 4:
				setSize(1024,728);
				add(new Tutorial());
				break;
		}
	}
	
	public static void main (String []args) {
		new ContainerGame(1);
	}
	
}
