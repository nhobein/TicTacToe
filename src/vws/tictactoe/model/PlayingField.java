package vws.tictactoe.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 3x3 playingfield of TicTacToe.
 * @author Nina Schulte-Hobein
 */
public class PlayingField {
	
	public static final int NUMBEROFCELLS = 9;
	public static final int CELLSINAROW = 3;
	
	private FieldMarker[] playingField; 
	
	/**
	 * Represents the states of a playingfield-cell.
	 */
	public enum FieldMarker {
	    EMPTY, X, O
	}

	/**
	 * Initializes a new playingfield where all cells are empty.
	 */
	public PlayingField() {
		playingField = new FieldMarker[NUMBEROFCELLS];
		for(int i = 0; i < NUMBEROFCELLS; i++) {
			playingField[i] = FieldMarker.EMPTY;
		}
	}
	
	/**
	 * @return the number of the playingfield-cells
	 */
	public int getNumberOfCells() {
		return NUMBEROFCELLS;
	}

	/**
	 * @return the cells in a row of the playingfield
	 */
	public int getCellsInARow() {
		return CELLSINAROW;
	}

	/**
	 * @param index - the index of the playingfield-cell
	 * @return the value of the playingfield-cell 
	 */
	public FieldMarker getValueAt(int index) {
		return playingField[index];
	}

	/**
	 * @param index - the index of the playingfield-cell
	 * @param marker - the value the field shall get
	 */
	public void setValue(int index, FieldMarker marker) {
		playingField[index] = marker;
	}
	
	/**
	 * Gets a list of cell-indices which have the given marker as value.
	 * @param marker - the value the cells shall have
	 * @return a list of cell-indices of all the cells who contain the given marker
	 */
	public List<Integer> getIndicesMarkedWith(FieldMarker marker) {
		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < NUMBEROFCELLS; i++) {
			if (playingField[i] == marker) {
				indices.add(i);
			}
		}
		return indices;
	}

}
	
