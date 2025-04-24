package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game { // come back to this to put in score
	Snake snake;
	Food food;
	private int score;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		this.snake = new Snake(); 
		this.food = new Food();
		this.score = 0;
	}
	
	public void play() {
		while (snake.isInbounds()) { // Check if snake is in bounds
			int dir = getKeypress(); // Pass direction to your snake
			
			if (dir > 0 && dir < 5) {
				snake.changeDirection(dir); 
			}
			
			snake.move(); // Tell the snake to move
			
			if (snake.eatFood(food)) {
				food = new Food(); // Creates new food when old food is eaten
				score ++;
			}
			
			updateDrawing();
		}
		StdDraw.clear();
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear(); // Clear screen
		
		snake.draw(); // Draw snake and food
		food.draw();
		StdDraw.text(0.05, 0.05, "Score: " + score); // Draws score on screen
		
		StdDraw.pause(50); // Pause (50 ms is good)
		
		StdDraw.show(); // Show
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
