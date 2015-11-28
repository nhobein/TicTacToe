package vws.tictactoe.view;

/**
 * An interface that should be implemented by classes interested in information about user input.
 * @author Nina Schulte-Hobein
 */
public interface InputListener {

	/**
	 * Method that is called when the user chooses a playingfield-cell.
	 * @param cellIndex - the chosen cell
	 */
	public void selectedIndex(int cellIndex);
	
}
