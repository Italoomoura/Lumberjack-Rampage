package jogo.Modelo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private Image fundo, bomf, ruimf;
	private Player player;
	private Timer timer;
	private Policial atirador[] = new Policial[2];
	private Arvore arvore[] = new Arvore[50];
	private int i = 0, arvoresCortadas = 0;
	private boolean isRunning, bom;
	
	ImageIcon referenciaFundo = new ImageIcon("res\\grass.png");
	ImageIcon referenciaBom = new ImageIcon("res\\Fimbom.jpg");
	ImageIcon referenciaRuim = new ImageIcon("res\\Fimruim.jpg");
	
	public Fase(){
		isRunning = true;
		setFocusable(true);
		setDoubleBuffered(true);
			
		fundo = referenciaFundo.getImage();
			
		player = new Player();
		player.load();
			
		for(int i = 0; i < atirador.length; i++) {
			atirador[i] = new Policial();
			atirador[i].load();
		}
			
		for (int i = 0; i < arvore.length; i++) {
			arvore[i] = new Arvore();
			arvore[i].load();
		}
			
		addKeyListener(new TecladoAdapter());
			
		timer = new Timer(5, this);
		timer.start();
			
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		for (int i = 0; i <= 4; i++) {
			for (int c = 0; c <= 4; c++) {
				graficos.drawImage(fundo, 256*i, 182*c, null);
			}
		}
		
		if(player.isVisivel()) {
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		}
		

		graficos.drawImage(atirador[0].getImagem(), atirador[0].getX(), atirador[0].getY(), this);
		
		if(arvoresCortadas >= 25) {
			graficos.drawImage(atirador[1].getImagem(), atirador[1].getX(), atirador[1].getY(), this);
		}
		

		
		if(i != arvore.length-1) {
			if(arvore[i].isVisivel()) {
				graficos.drawImage(arvore[i].getImagem(), arvore[i].getX(), arvore[i].getY(), this);
			}
			else {
				i+=1;
			}
		}
		else {
			isRunning = false;
			bom = false;
		}
		
		if(!isRunning) {
			if(bom) {
				bomf = referenciaBom.getImage();
				graficos.drawImage(bomf, 0, 0, null);
			}
			else {
				ruimf = referenciaRuim.getImage();
				graficos.drawImage(ruimf, 0, 0, null);
			}
		}
		
		
		// Contador de árvores cortadas
		FontRenderContext frc = graficos.getFontRenderContext();
		Font font1 = new Font("Courier", Font.BOLD, 24);
		String str1 = new String();
		str1 = String.format("Árvores cortadas: %d", arvoresCortadas);
		TextLayout tl = new TextLayout(str1, font1, frc);
		graficos.setColor(Color.darkGray);
		tl.draw(graficos, 385, 50);
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		
		checarColisoes();
		atualizarMovimentoInimigo();
		
		repaint();
	}
	
	public void atualizarMovimentoInimigo() {
	    double v0 = 2.0, v1 = 3.0;
	
	    double dX0 = player.getX() - atirador[0].getX();
		double dY0 = player.getY() - atirador[0].getY();
		double dX1 = player.getX() - atirador[1].getX();
		double dY1 = player.getY() - atirador[1].getY();
		double distancia0 = Math.sqrt(dX0 * dX0 + dY0 * dY0);
		double distancia1 = Math.sqrt(dX1 * dX1 + dY1 * dY1);

		dX0 /= distancia0;
		dY0 /= distancia0;
		dX1 /= distancia1;
		dY1 /= distancia1;

		int nPX0 = (int) (atirador[0].getX() + dX0 * v0);
		int nPY0 = (int) (atirador[0].getY() + dY0 * v0);
		int nPX1 = (int) (atirador[1].getX() + dX1 * v1);
		int nPY1 = (int) (atirador[1].getY() + dY1 * v1);

		atirador[0].setX(nPX0);
		atirador[0].setY(nPY0);
		atirador[1].setX(nPX1);
		atirador[1].setY(nPY1);
	}
	
	
	public void checarColisoes() {
		Rectangle formaPlayer = player.getBounds();
		Rectangle formaArvore = arvore[i].getBounds();
		Rectangle formaAtirador0 = atirador[0].getBounds();
		Rectangle formaAtirador1 = atirador[1].getBounds();
		
		if(formaArvore.intersects(formaPlayer)) {
			arvore[i].setVisivel(false);
			arvoresCortadas++;
		}
		
		if(formaAtirador0.intersects(formaPlayer)) {
			isRunning = false;
			bom = true;
			atirador[0].setVisivel(false);
			atirador[1].setVisivel(false);
			player.setVisivel(false);
		}
		if(formaAtirador1.intersects(formaPlayer) && arvoresCortadas >= 25) {
			isRunning = false;
			bom = true;
			atirador[0].setVisivel(false);
			atirador[1].setVisivel(false);
			player.setVisivel(false);
		}
		
	}
	
	private class TecladoAdapter extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}
	}
	
}