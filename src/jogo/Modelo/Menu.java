package jogo.Modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import jogo.ContainerGame;

public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;

	public Menu(){
		JButton btnStart = new JButton("Começar");
		btnStart.setBounds(412, 500, 200, 50);
		btnStart.setBackground(new Color(95, 162, 50));
		btnStart.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnTutorial = new JButton("Tutorial");
		btnStart.setBounds(412, 600, 200, 50);
		btnStart.setBackground(new Color(95, 162, 50));
		btnStart.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnExit = new JButton("Sair");
		btnStart.setBounds(412, 700, 200, 50);
		btnStart.setBackground(new Color(95, 162, 50));
		btnStart.setFont(new Font("Arial", Font.BOLD, 24));
		
		add(btnStart);
		add(btnTutorial);
		add(btnExit);
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContainerGame(3);
			}
		});
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ContainerGame(4);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
