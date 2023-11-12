package jogo.Modelo;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Policial {
private int x, y, altura, largura;
	
	private Image imagem;
	private boolean isVisivel;
	private Random random = new Random();
	private ImageIcon referencia = new ImageIcon("res\\PolicialPixelArt2.png");
	
	public Policial() {
		isVisivel = true;
		this.x = random.nextInt(264);
		this.y = random.nextInt(264);
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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
