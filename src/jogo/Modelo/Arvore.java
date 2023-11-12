package jogo.Modelo;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Arvore {
	private int x, y, altura, largura;
	
	private String[] listImg = {"res\\Arvore1.png", "res\\Arvore2.png"};
	
	private Random random = new Random();
	private Image imagem;
	private ImageIcon referencia;;
	private boolean isVisivel;
	
	public Arvore() {
		this.x = random.nextInt(864);
		this.y = random.nextInt(501);
		isVisivel = true;
		
		referencia = new ImageIcon(listImg[random.nextInt(2)]);
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
