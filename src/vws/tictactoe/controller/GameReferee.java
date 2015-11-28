package vws.tictactoe.controller;

import java.util.List;

import vws.tictactoe.model.PlayingField;
import vws.tictactoe.model.PlayingField.FieldMarker;

/**
 * A class that controls the game rules.
 * @author Nina Schulte-Hobein
 */
public class GameReferee {

	private final int NUMBEROFCELLS;
	private final int CELLSINROW;
	
	PlayingField playingField;
	FieldMarker actualPlayer;		// The player whose turn it is.
	String actualNote;				// The information note that shall be displayed in the gui.

	/**
	 * Sets the playingfield and its size and initializes the game.
	 * @param playingField - the playingfield the referee shall watch over
	 */
	public GameReferee(PlayingField playingField) {
		this.playingField = playingField;
		NUMBEROFCELLS = playingField.getNumberOfCells();
		CELLSINROW = playingField.getCellsInARow();
		init();
	}
	
	/**
	 * Sets the initial player and information note.
	 */
	private void init(){
		actualPlayer = FieldMarker.X;
		actualNote = "Player X it's your turn. Please choose a cell: ";
	}
	
	/**
	 * Checks if the chosen cell can be marked and if the game is over.
	 * If the game continues, the player is switched. 
	 * @param index - The index of the playingfield-cell.
	 */
	public void checkMove(int index) {
		if(index >= 0 && index < NUMBEROFCELLS) {
			FieldMarker marker = playingField.getValueAt(index);
			if (marker == FieldMarker.EMPTY) {
				playingField.setValue(index, actualPlayer);
				if (!isGameOver()) {
					switchPlayer();
				}
			} else {
				actualNote = "The chosen cell is already occupied. Please chose another cell.\n"; 
			}
		} else {
			actualNote = "Wrong Input. Please choose an index between 0 and 8.\n";
		}
	}
	
	/**
	 * Switches the player and actualizes the information note.
	 */
	private void switchPlayer () {
		if (actualPlayer == FieldMarker.X) {
			actualPlayer = FieldMarker.O;
			actualNote = "Player O it's your turn. Please choose a cell: ";
		} else {
			actualPlayer = FieldMarker.X;
			actualNote = "Player X it's your turn. Please choose a cell: ";
		}
	}
	
	/**
	 * @return the actual information note for the players
	 */
	public String getActualNote() {
		return actualNote;
	}
	
	/**
	 * Checks if the game has ended.
	 * @return true, if the game is over
	 */
	private Boolean isGameOver() {
		List<Integer> xIndices = playingField.getIndicesMarkedWith(FieldMarker.X);
		List<Integer> oIndices = playingField.getIndicesMarkedWith(FieldMarker.O);
		if (threeInARow(xIndices) || threeInACol(xIndices) || threeInADiagonal(xIndices)) {
			actualNote = "Game Over. Player X won.";
			return true;
		}
		if (threeInARow(oIndices) || threeInACol(oIndices) || threeInADiagonal(oIndices)) {
			actualNote = "Game Over. Player O won.";
			return true;
		}
		//Check if all cells are occupied, then we have a draw
		if(xIndices.size() + oIndices.size() == NUMBEROFCELLS) {
			actualNote = "Game Over. We have a draw.";
			return true;
		}
		return false;
	}

	/**
	 * Checks if a player has three markers in a row.
	 * @param indices - the list of cells occupied by this player
	 * @return true, if the player has three cells in a row
	 */
	private boolean threeInARow(List<Integer> indices) {		
		for(int i = 0; i < NUMBEROFCELLS; i = i + CELLSINROW ) {
			if(indices.contains(i) && indices.contains(i+1) && indices.contains(i+2)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a player has three markers in a column.
	 * @param indices - the list of cells occupied by this player
	 * @return true, if the player has three cells in a column
	 */
	private boolean threeInACol(List<Integer> indices) {
		for(int i = 0; i < CELLSINROW; i++) {
			if(indices.contains(i) && indices.contains(i + CELLSINROW) && indices.contains(i + (CELLSINROW * 2))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if a player has three markers in one of the two diagonals.
	 * @param indices - the list of cells occupied by this player
	 * @return true, if the player has three cells in a diagonal
	 */
	private boolean threeInADiagonal(List<Integer> indices) {
		if(indices.contains(0) && indices.contains(CELLSINROW + 1) && indices.contains((CELLSINROW + 1) * 2)) {
			return true;
		}
		if(indices.contains(CELLSINROW-1) && indices.contains((CELLSINROW-1) * 2) && indices.contains((CELLSINROW-1) * 3)) {
			return true;
		}
		return false;
	}

}
