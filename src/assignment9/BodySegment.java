package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) { //something to keep in mind here is whether size means diameter or radius
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = new Color(255, 0, 150);
		//See ColorUtils for some color options (or choose your own)
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size);
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setHead(double headX, double headY) {
		this.x = headX;
		this.y = headY;
	}
}
