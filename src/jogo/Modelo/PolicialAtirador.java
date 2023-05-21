package jogo.Modelo;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class PolicialAtirador {
private int x, y, altura, largura;
	
	private Image imagem;
	private boolean isVisivel;
	private ImageIcon referencia = new ImageIcon("res\\atirador.png");
	
	private List <Tiro> tiros;
	
	public PolicialAtirador() {
		this.x = 800;
		this.y = 500;
		isVisivel = true;
		
		tiros = new ArrayList<Tiro>();
	}
	
	public void load() {
		imagem = referencia.getImage();
		
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
	}
	
	public void tiroSimples() {
		this.tiros.add(new Tiro(x+largura, y+(altura/2)));
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

	public List<Tiro> getTiros() {
		return tiros;
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
