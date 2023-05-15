package jogo.Modelo;
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
import java.util.List;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fase extends JPanel implements ActionListener{

	private Image fundo;
	private Player player;
	private Timer timer;
	private PolicialAtirador atirador;
	private Arvore arvore;
	
	public Fase(){
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\background.png");
		fundo = referencia.getImage();
		
		player = new Player();
		player.load();
		
		atirador = new PolicialAtirador();
		atirador.load();
		
		arvore = new Arvore();
		arvore.load();

		addMouseListener(new MouseHandler());
		addKeyListener(new TecladoAdapter());
		
		timer = new Timer(5, this);
		timer.start();

	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo, 0, 0, null);
		graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
		graficos.drawImage(atirador.getImagem(), atirador.getX(), atirador.getY(), this);
		graficos.drawImage(arvore.getImagem(), arvore.getX(), arvore.getY(), this);
		
		List<Tiro> tiros = player.getTiros();
		for(int i = 0; i<tiros.size(); i++) {
			Tiro m = tiros.get(i);
			m.load();
			graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
		}
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		
		List<Tiro> tiros = player.getTiros();
		for(int i = 0; i<tiros.size(); i++) {
			Tiro m = tiros.get(i);
				if(m.isVisivel()) {
					m.update();
				}
				else {
					tiros.remove(i);
				}
		}
		
		checarColisoes();

		repaint();
	}
	
	public void checarColisoes() {
		Rectangle formaPlayer = player.getBounds();
		Rectangle formaArvore = arvore.getBounds();
		Rectangle formaTiro;
		Rectangle formaAtirador;
		
		if(formaPlayer.intersects(formaArvore)) {
			arvore.setVisivel(false);
		}
	}
	
	private class MouseHandler implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("X: "+e.getX()+"\nY: "+e.getY());
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