package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		segments = new LinkedList<BodySegment>();
		deltaX = 0;
		deltaY = 0;
		
		BodySegment initSegment = new BodySegment(0.5, 0.5, SEGMENT_SIZE); // Ensures the game starts with one segment in the middle of the screen
		segments.add(initSegment);
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		BodySegment head = segments.getFirst(); // .getFirst returns the first element in a list
		double prevX = head.getX();
		double prevY = head.getY();
		
		head.setHead(prevX + deltaX, prevY + deltaY); //changes position of head

	       for (int i = 1; i < segments.size(); i++) {
	           BodySegment current = segments.get(i);
	           double tempX = current.getX();
	           double tempY = current.getY();
	           
	           current.setHead(prevX, prevY);
	           prevX = tempX;
	           prevY = tempY;
	       }
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		for (BodySegment segment : segments) {
			segment.draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {

		BodySegment head = segments.getFirst(); // .getFirst returns first value within a list
		       double dx = head.getX() - f.getX();
		       double dy = head.getY() - f.getY();
		       double distance = Math.sqrt(dx * dx + dy * dy); // distance formula

		       if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) { // this tests to see if the snakes head is touching the food
		           BodySegment tail = segments.getLast(); // .getLast returns the last value in a list
		           BodySegment newSegment = new BodySegment(tail.getX(), tail.getY(), SEGMENT_SIZE); // creates a new segment at the location of the last snake segment
		           segments.addLast(newSegment); // adds the newly created segment to the list
		           return true;
		       }
		       return false;
		}

	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {

		BodySegment head = segments.getFirst();
		
		double x = head.getX();
		double y = head.getY();
		
		if (x >= 0 && x <= 1 && y >= 0 && y <= 1) {
			return true;
			}
		return false;
		}
}