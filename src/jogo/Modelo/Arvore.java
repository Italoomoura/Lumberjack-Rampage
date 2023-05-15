package jogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

public class Arvore {
	private int x, y, altura, largura;
	
	private Random random = new Random();
	private Image imagem;
	private ImageIcon referencia = new ImageIcon("res\\arvore.png");
	private boolean isVisivel;
	
	public Arvore() {
		this.x = random.nextInt(501);
		this.y = random.nextInt(501);
		isVisivel = true;
	}
	
	public void load() {
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
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

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
}
