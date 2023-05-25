package jogo;

import javax.swing.JFrame;
import jogo.Modelo.Menu;
import jogo.Modelo.Fase;

public class Container extends JFrame {
	
	public Container(int x) {
		
		tela(x);
		
		setTitle("Lumberjack Rampage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	public void tela(int x) {
		switch (x){
		case 1:
			setSize(300,250);
			add(new Menu());
			break;
		case 2:
			setSize(1024,728);
			add(new Fase());
			break;
		case 3:
			setSize(1024,728);
			//add(new Tutorial());
			break;
		default:
			setSize(300,250);
			add(new Menu());
			break;
	}
	}
	
	public static void main (String []args) {
		new Container(1);
	}
	
}
