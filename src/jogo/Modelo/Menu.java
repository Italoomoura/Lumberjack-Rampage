package jogo.Modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import jogo.ContainerGame;

public class Menu extends JPanel{

	private static final long serialVersionUID = 1L;
	private Image imagem;
	private ImageIcon referenciaImagem;

	public Menu(){
		
		referenciaImagem = new ImageIcon("res//Capa.jpg");
		imagem = referenciaImagem.getImage();
		
		setLayout(null);
		
		JButton btnStart = new JButton("Começar");
		btnStart.setBounds(387, 450, 250, 50);
		btnStart.setBackground(new Color(26, 79, 237));
		btnStart.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setBounds(387, 525, 250, 50);
		btnTutorial.setBackground(new Color(26, 79, 237));
		btnTutorial.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton btnExit = new JButton("Sair");
		btnExit.setBounds(387, 600, 250, 50);
		btnExit.setBackground(new Color(26, 79, 237));
		btnExit.setFont(new Font("Arial", Font.BOLD, 24));
		
		
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
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagem, 0, 0, null);
	}
	
}
