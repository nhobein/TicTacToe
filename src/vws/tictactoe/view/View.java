package vws.tictactoe.view;

import vws.tictactoe.model.PlayingField;

/**
 * An interface that should be implemented by classes which offer a gui for TicTacToe.
 * @author Nina Schulte-Hobein
 */
public interface View {

	/**
	 * Draws the playingfield and sets a note, which playersI turn it is or if the game has ended.
	 * @param playingField - The Playingfield. 
	 * @param note - A note, which players' turn it is or whether the game has ended.
	 */
	public void drawGameState(PlayingField playingField, String note);
	
	/**
	 * Registers a Listener at the View to get informed when the player marks a cell.
	 * @param listener - The listener that shall be called when a player made his move.
	 */
	public void registerCellSelectedListener(InputListener listener);
	
}
