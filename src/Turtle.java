import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Turtle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JFrame frame = new JFrame();

		final ImageIcon successIcon = new ImageIcon("successIcon.png");
		final ImageIcon wall = new ImageIcon("wall.png");
		final ImageIcon enemy = new ImageIcon("enemy.png");
		final ImageIcon pacman = new ImageIcon("pacman.png");
		final ImageIcon empty = new ImageIcon("empty.png");
		final ImageIcon bigDot = new ImageIcon("bigDot.png");

		final JButton button = new JButton(successIcon);
		final JDialog dialog = new JDialog();

		random = new Random();

		dialog.setSize(690,650);
		dialog.setVisible(false);
		
		pacmanH=1;  pacmanW=5;
		enemyH=1;  enemyW=1;
		start=2;  temp=empty;
		
		
		final JLabel[][] f = new JLabel[MAP_SIZE_HEIGHT][MAP_SIZE_WIDTH];
		
		for (int i=0; i<MAP_SIZE_HEIGHT; i++) {
			for(int j=0; j<MAP_SIZE_WIDTH; j++) {
				f[i][j] = new JLabel();
			}
		}
			
		class Blistener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}

		class TListener implements ActionListener {   //timerÅ¬·¡½º ActionListener
			int x, y;
			
			public TListener(int x, int y) {
				enemyH = x;
				enemyW = y;
			}
			
			public void actionPerformed(ActionEvent event)
			{
				if(start<=0) where = 1+random.nextInt(1);
				else { where = 1; start--; }
					switch(where) {
						case 1:
							if(!(f[enemyH][enemyW+1].getIcon()).equals(wall)) {
								temp1=f[enemyH+1][enemyW+1].getIcon();
								f[enemyH][enemyW+1].setIcon(enemy);
								f[enemyH][enemyW].setIcon(temp);
								temp=temp1;
								enemyW++;
							}
							break;
					}
					
					if(enemyH==pacmanH && enemyW==pacmanW) {
						f[enemyH][enemyW].setIcon(enemy);
						//dialog.add(button);
						//dialog.setVisible(true);
					}
					else if(enemyW==MAP_END) {
						f[enemyH][enemyW].setIcon(enemy);
						dialog.add(button);
						dialog.setVisible(true);
					}				
				System.out.println(where);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(MAP_SIZE_HEIGHT,MAP_SIZE_WIDTH));
		frame.requestFocus();

		

		for(int i=0; i<MAP_SIZE_HEIGHT; i++) {
			for(int j=0; j<MAP_SIZE_WIDTH; j++) {
					f[i][j].setIcon(wall);
					panel.add(f[i][j]);
				
			}
		}
		
		for(int i=1; i<MAP_SIZE_HEIGHT - 1; i++) {
			for(int j=1; j<MAP_SIZE_WIDTH - 1; j++) {
					f[i][j].setIcon(empty);
					frame.add(panel);
				
			}
		}
		
		f[pacmanH][pacmanW].setIcon(pacman);
		
		for(int i = 0; i < 12; i++) {
			f[enemyH + i][enemyW].setIcon(enemy);
		}
		
		for(int i=1; i<MAP_SIZE_HEIGHT - 1; i++) {
			f[i][MAP_END].setIcon(bigDot);
		}
		
		TListener tListener1 = new TListener(enemyH,enemyW);
		/*
		TListener tListener2 = new TListener(enemyH+1,enemyW);
		TListener tListener3 = new TListener(enemyH+2,enemyW);
		TListener tListener4 = new TListener(enemyH+3,enemyW);
		*/
		button.addActionListener(new Blistener());
		
		Timer t1 = new Timer(2500, tListener1);
		/*
		Timer t2 = new Timer(2500, tListener2);
		Timer t3 = new Timer(2500, tListener3);
		Timer t4 = new Timer(2500, tListener4);
		*/
		t1.start();
		/*
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		*/
		
		frame.setTitle("TurtleGame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private static Random random;
	private static int pacmanH, pacmanW, enemyH, enemyW, numOfDot, where, start;
	private static Icon temp1, temp2, temp3, temp4, temp;

	private static final int FRAME_WIDTH = 990;
	private static final int FRAME_HEIGHT = 650;
	private static final int MAP_SIZE_WIDTH = 20;
	private static final int MAP_SIZE_HEIGHT = 14;
	private static final int MAP_END = MAP_SIZE_WIDTH - 3;
	}