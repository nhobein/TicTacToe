package vws.tictactoe.view;

import java.util.ArrayList;
import java.util.List;

/**
 * A handler to hold and inform registered listeners about new user input.
 * @author Nina Schulte-Hobein
 */
public class InputHandler {

	private List<InputListener> listeners = new ArrayList<InputListener>();

	/**
	 * Adds a new InputListener to the list of registered listeners.
	 * @param listener - the new InputListener
	 */
    protected void addListener(InputListener listener) {
        listeners.add(listener);
    }

    /**
     * Method that informs all registered listeners about new user input.
     * @param cellIndex - the playingfield-cell which the user selected
     */
    protected void selectedIndex(int cellIndex) {
        for (InputListener listener : listeners){    	
            listener.selectedIndex(cellIndex);
        }
    }
	
}
