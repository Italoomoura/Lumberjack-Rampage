package jogo.Modelo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jogo.ContainerGame;

public class Historia extends JPanel  {
		
		private static final long serialVersionUID = 1L;
		private JLabel figura;
		
		private int indexImagem = 2;
		private ImageIcon[] imagens = new ImageIcon[6];
		
		private MouseHandler mouse = new MouseHandler();
		
		public Historia() {
			
			setBounds(0, 0, 1024, 728);
			setBackground(null);
			addMouseListener(mouse);
			
			for (int i = 0; i < imagens.length; ++i) {
				imagens[i] = new ImageIcon(".//res//Img" + Integer.toString(i) + ".jpg");
			}
			
			figura = new JLabel();
			
			figura.setIcon(imagens[1]);
			add(figura);
		}

		
		public class MouseHandler implements MouseListener {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					figura.setIcon(imagens[indexImagem]);
					add(figura);
					indexImagem++;
				}
				catch (Exception exception) {
					new ContainerGame(2);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
	
}
