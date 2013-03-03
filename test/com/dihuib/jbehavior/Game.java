package com.dihuib.jbehavior;

public class Game {

	private char[][] box;
	private int width;
	private int height;
	private StringRenderer observer;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;
		box = new char[width][height];
		init();
	}
	
	private void init() {
		for(int i=0; i<getHeight(); i++) {
			for(int j=0; j<getWidth(); j++) {
				box[i][j] = '.'; 
			}
		}
	}
	
	public void toggleCellAt(int column, int row) {
		switch(box[column][row]) {
		case '.':	box[column][row] = 'X'; break;
		case 'X':	box[column][row] = '.'; break;
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char[][] getBox() {
		return box;
	}

	public void setBox(char[][] box) {
		this.box = box;
	}

	public StringRenderer getObserver() {
		return observer;
	}

	public void setObserver(StringRenderer observer) {
		this.observer = observer;
		observer.setGame(this);
	}
	
	public static void main(String [] args) {
		Game game = new Game(5,5);
		StringRenderer renderer = new StringRenderer();
		game.setObserver(renderer);
		
		System.out.println(renderer.asString());
	}

}
