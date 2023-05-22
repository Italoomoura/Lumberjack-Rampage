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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements ActionListener{

	private Image fundo, bomf, ruimf;
	private Player player;
	private Timer timer;
	private PolicialAtirador atirador, atirador2;
	private Arvore arvore[] = new Arvore[51];
	private int i = 0, arvoresCortadas = 0;
	private boolean isRunning, bom;
	
	ImageIcon referenciaFundo = new ImageIcon("res\\background.png");
	ImageIcon referenciaBom = new ImageIcon("res\\fimbom.png");
	ImageIcon referenciaRuim = new ImageIcon("res\\fimruim.png");
	
	public Fase(){
		isRunning = true;
		setFocusable(true);
		setDoubleBuffered(true);
		
		fundo = referenciaFundo.getImage();
		
		player = new Player();
		player.load();
		
		//Render do policial
		atirador = new PolicialAtirador();
		atirador.load(800, 600); //deixei parametros no load do policial assim fica fácil de escolher nova posição;
		
		atirador2 = new PolicialAtirador();
		atirador2.load(50, 100);
		
		//Você é simplesmente psicopata por ter feito isso aqui, n é possível q esse seja o jeito certo
		for (int i = 0; i < arvore.length; i++) {
			arvore[i] = new Arvore();
			arvore[i].load(); // Inicializa cada elemento do array com uma nova instância de Arvore
		}
		

		addMouseListener(new MouseHandler());
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();

	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(fundo, 0, 0, null);
		
		if(player.isVisivel()) {
			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		}
		if(atirador.isVisivel()) {
			graficos.drawImage(atirador.getImagem(), atirador.getX(), atirador.getY(), this);
			graficos.drawImage(atirador2.getImagem(), atirador2.getX(), atirador2.getY(), this);
		}
		
		if (arvoresCortadas >= 5) {
			graficos.drawImage(atirador2.getImagem(), atirador2.getX(), atirador2.getY(), this);
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
	    double velocidade = 2.0; // Velocidade do inimigo

	    // Atualiza a posição do inimigo em direção ao jogador
	    double direcaoX = player.getX() - atirador.getX();
	    double direcaoY = player.getY() - atirador.getY();
	    double distancia = Math.sqrt(direcaoX * direcaoX + direcaoY * direcaoY); // Distância entre o inimigo e o jogador

	    // Normaliza a direção (transforma em um vetor unitário)
	    direcaoX /= distancia;
	    direcaoY /= distancia;

	    // Atualiza a posição do inimigo em direção ao jogador com base na velocidade
	    int novaPosicaoX = (int) (atirador.getX() + direcaoX * velocidade);
	    int novaPosicaoY = (int) (atirador.getY() + direcaoY * velocidade);

	    atirador.setX(novaPosicaoX);
	    atirador.setY(novaPosicaoY);
	}
	
	
	public void checarColisoes() {
		Rectangle formaPlayer = player.getBounds();
		Rectangle formaArvore = arvore[i].getBounds();
		Rectangle formaAtirador = atirador.getBounds();
		
		if(formaArvore.intersects(formaPlayer)) {
			arvore[i].setVisivel(false);
			arvoresCortadas++;
			//Novo policial quando atingir 25 árvores cortadas
			if (arvoresCortadas == 5) {
				atirador2 = new PolicialAtirador();
				atirador2.load(500, 500);
			}
		}
		
		if(formaAtirador.intersects(formaPlayer)) {
			isRunning = false;
			bom = true;
			atirador.setVisivel(false);
			player.setVisivel(false);
		}
		
	}
	
	private class MouseHandler implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		@Override
		public void mousePressed(MouseEvent e) {
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