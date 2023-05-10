package jogo.Modelo;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	
	private int x, y, dx, dy, altura, largura;
	private Image imagem;
	private ImageIcon referencia = new ImageIcon("res\\playerW.png");
	private ImageIcon W = new ImageIcon("res\\playerW.png");
	private ImageIcon S = new ImageIcon("res\\playerS.png");
	private ImageIcon A = new ImageIcon("res\\playerA.png");
	private ImageIcon D = new ImageIcon("res\\playerD.png");
	
	public Player() {
		this.x = 472;
		this.y = 500;
	}
	
	public void load() {
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public void update() {
		x += dx;
		y += dy;
	}
	
	public void keyPressed(KeyEvent tecla) {
		int cod = tecla.getKeyCode();
		if(cod == KeyEvent.VK_W) {
			dy = -7;
			imagem = W.getImage();			
		}
		if(cod == KeyEvent.VK_S) {
			dy = 7;
			imagem = S.getImage();	
		}
		if(cod == KeyEvent.VK_A) {
			dx = -7;
			imagem = A.getImage();	
		}
		if(cod == KeyEvent.VK_D) {
			dx = 7;
			imagem = D.getImage();	
		}
	}
	
	public void keyRelease(KeyEvent tecla) {
		int cod = tecla.getKeyCode();
		if(cod == KeyEvent.VK_W) {
			dy = 0;
		}
		if(cod == KeyEvent.VK_S) {
			dy = 0;
		}
		if(cod == KeyEvent.VK_A) {
			dx = 0;
		}
		if(cod == KeyEvent.VK_D) {
			dx = 0;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}
	
}