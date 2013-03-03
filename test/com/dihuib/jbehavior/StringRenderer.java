/**
 * 
 */
package com.dihuib.jbehavior;

/**
 * @author Dihui Bao 
 *
 */
public class StringRenderer {
	
	private Game game;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public String asString() {
		if(getGame() == null) {
			return "";
		}
		
		StringBuilder builder = new StringBuilder("");
		
		for(int i=0; i< game.getHeight();i++) {
			for(int j=0; j< game.getWidth(); j++) {
				builder.append(rchar(i,j));
			}
			if(i!=game.getHeight()-1)
				builder.append(System.getProperty("line.separator"));
		}
		
		return builder.toString();
	}
	
	public char rchar(int column, int row) {
		return getGame().getBox()[column][row];
	}

}
