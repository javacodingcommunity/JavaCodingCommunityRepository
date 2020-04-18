import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	
	private int xCoord, yCoord, width, height; // every Apple consists of these elements
	
	public Apple(int xCoord, int yCoord, int tileSize) { // constructor for the Apple.
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		width = tileSize;
		height = tileSize;
	
	}
	
	public void draw(Graphics g) { // drawing the apple
		g.setColor(Color.YELLOW); // choose color
		g.fillRect(xCoord * width,yCoord*height, width,height);
	}

	public int getxCoord() { // getter for x
		return xCoord;
	}

	public void setxCoord(int xCoord) { // setter for x
		this.xCoord = xCoord;
	}

	public int getyCoord() { // getter for y
		return yCoord;
	}

	public void setyCoord(int yCoord) { // setter for y
		this.yCoord = yCoord;
	}
}