import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener  {
	
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 500, HEIGHT = 500; // width and height of our window
	
	private Thread thread; // we need a Thread so it can execute along with main
	// this thread starts the run function
	
	private boolean running; // boolean that keeps track of game state
	
	private boolean right = true, left = false, up = false, down = false; // keeping track of where
	// we are moving
	
	private BodyPart b; // a single body part 
	
	private ArrayList<BodyPart> snake; // array of body parts makes up a snake
	
	private Apple apple; // a single apple
	private ArrayList<Apple> apples;
	
	private Random r; // for creating random coordinates for an apple
	
	public int score = 0; // keeps track of score
	
	
	
	private int xCoord = 10, yCoord = 10, size = 5; // where snake starts, and its size
	
	private int ticks = 0; // game speed
	
	
	
	public GamePanel() { // constructor for game panel
		// called when game is starting
		setFocusable(true);
		
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		addKeyListener(this); // keeps track of key pressess
		snake = new ArrayList<BodyPart>(); // initialize snake
		apples = new ArrayList<Apple>(); // initialize apples
		
		r = new Random(); // initialize random
		
		start(); // starts the game
		
		
	}
	
	public void start() {
		running = true; // running is set to true when game starts
		thread = new Thread(this); // thread that keeps running without caring for Main
		thread.start();
	}
	public void stop() {
	
		running = false; // if we stop, running goes to false
		// now we create the Game Over Screen
		JFrame f=new JFrame("Game Over Screen");            
		JButton b=new JButton("Press this to play again!"); 
		JLabel l = new JLabel("Your score was: "+ score);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setPreferredSize(new Dimension(500,500));
		JButton close = new JButton("Quit!");
		b.setBounds(130,200,250, 40); 
		f.add(l);
		f.add(b);    
		f.add(close);
		f.setLayout(new FlowLayout());    
		f.pack();
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		Main.returnFrame().dispatchEvent(new WindowEvent(Main.returnFrame(), WindowEvent.WINDOW_CLOSING));
		Main.returnFrame().dispose();
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// if we hit play again --> we start the main again
				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
				Main.main(null);
			}
		});
		close.addActionListener(new ActionListener() {
			// if we hit quit --> we quit the program
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() { // every tick, likes frame per second
		if(snake.size() == 0) { // if the snake doesn't exist, we create it
			b = new BodyPart(xCoord, yCoord, 10);
			snake.add(b); // add the body part to snake list
		}
		ticks++; // now we wait for ticks to get to 750 000
		// chanche this depending on what speed you want
		if(ticks > 750000) {
			
			// these are self explanatory, with every move we change the coordinates
			if(right) xCoord++;
			if(left) xCoord--;
			if(up) yCoord--;
			if(down) yCoord++;
			
			ticks = 0; // set ticks to 0 
			
			b = new BodyPart(xCoord, yCoord, 10); // we create a body part
			snake.add(b); // add it to the snake
			
			if(snake.size() > size ) {
				snake.remove(0); // remove the body part if the snake didn't increase
			}
		}
		if(apples.size() == 0) { // if there are no apples
			// we create them
			int xCoord = r.nextInt(49);
			int yCoord = r.nextInt(49);
			// with random coordinates
			
			apple = new Apple(xCoord, yCoord, 10);
			apples.add(apple);
		}
		
		
		// now we check if we ate an apple
		for(int i = 0;i< apples.size();i++) {
			if(xCoord == apples.get(i).getxCoord() && yCoord == apples.get(i).getyCoord()) {
				// if the current coordinates are the same as apples
				// we increase the size and the score
				// and remove the apple
				score++;
				size++;
				apples.remove(i);	
			}
		
			
		} // we check if we hit the border
		if(xCoord < 0 || xCoord > 49 || yCoord < 0 || yCoord > 49) {
			JOptionPane.showMessageDialog(null, "Game Over!");
			
			stop();
		}
		// we check if we hit our tail
		for(int i =0;i < snake.size(); i++) {
			if(xCoord == snake.get(i).getxCoord() && yCoord == snake.get(i).getyCoord()) {
				if( i!= snake.size()-1) {
					JOptionPane.showMessageDialog(null, "Game Over!");
					
					stop();
				}
			}
		}
	}
	
	public void paint(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT); // clears the screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT); // fills it with black
		
		for(int i = 0;i<WIDTH/10;i++) { // draws lines 
			g.drawLine(i*10, 0, i*10, HEIGHT);
		}
		// inside these lines the snake can move
		// lines cannot be seen
		for(int i = 0;i<HEIGHT/10;i++) {
			g.drawLine(0, i*10, HEIGHT, i*10);
		} // also draws lines
		
		// we call the draw method on the Body Part
		// *snake is ArrayList<BodyPart>
		for(int i = 0;i< snake.size();i++ ) {
			snake.get(i).draw(g);
		}
		// draws apples in the same way
		for(int i = 0;i<apples.size();i++) {
			apples.get(i).draw(g);
		}
		
		
	}
	@Override
	public void run() {
		while(running) { // while running is true
			// we want the commands tick and repaint to be active
			
			tick(); // we'll explain this in its own method
			repaint(); // updates the screen
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// this method keeps track of our keys
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT && left == false) {
			// this ensures that we move in one direction only
			right = true;
			up = false;
			down = false; 
			
			
		}
		
		if(key == KeyEvent.VK_LEFT && right == false) {
			// this ensures that we move in one direction only
			left = true;
			up = false;
			down = false;
			
			
		}
		
		if(key == KeyEvent.VK_UP && down == false) {
			// this ensures that we move in one direction only
			up = true;
			left = false;
			right = false;
			
			
		}
		
		if(key == KeyEvent.VK_DOWN && up == false) {
			// this ensures that we move in one direction only
			down = true;
			left = false;
			right = false;
			
			
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// we need to ovverride because of the interface but we dont need to use them
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// we need to ovverride because of the interface but we dont need to use them
		
	}
}
