import java.awt.Color;
import java.awt.Graphics;

public class BodyPart {
	
	private int xCoord, yCoord, width, height; // every Body Part is composed of these elements.
	
	public BodyPart(int xCoord, int yCoord, int tileSize) { // constructor for the Body Part.
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		width = tileSize;
		height = tileSize;
	
	}
	
	
	
	public void draw(Graphics g) { // draws the Body Part
		
		g.setColor(Color.RED);  // change the color
		g.fillRect(xCoord*width, yCoord * height, width, height);
		
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
