import javax.swing.JFrame;

public class Main {
	public static JFrame frame = null;
	
	public Main() {
		
		frame = new JFrame();
		GamePanel gamePanel = new GamePanel();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(gamePanel);
		
		frame.setTitle("The Snake Game by Java Coding Community");
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		}
	
	public static JFrame returnFrame() {
		return frame;
	}
		
	
		
		
		
	
	
	
	public static void main(String[] args) {
		new Main();
	}

}
