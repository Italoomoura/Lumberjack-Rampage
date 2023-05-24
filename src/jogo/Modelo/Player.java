package jogo.Modelo;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
	
	private int x, y, dx, dy, altura, largura;
	private boolean isVisivel;
	
	private Image imagem;
	private ImageIcon referencia = new ImageIcon("res\\LumberjackPixelArt.png");
	
	public Player() {
		this.x = 472;
		this.y = 500;
		isVisivel = true;
		
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
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,largura,altura);
	}
	
	public void keyPressed(KeyEvent tecla) {
		int cod = tecla.getKeyCode();
		
		if(cod == KeyEvent.VK_W) {
			dy = -7;	
		}
		if(cod == KeyEvent.VK_S) {
			dy = 7;	
		}
		if(cod == KeyEvent.VK_A) {
			dx = -7;	
		}
		if(cod == KeyEvent.VK_D) {
			dx = 7;
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
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}
	
}