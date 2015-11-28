package vws.tictactoe;

import vws.tictactoe.controller.Game;

/**
 * Entry class, starts a new TicTacToe game.
 * @author Nina Schulte-Hobein
 */
public class TicTacToe {

	/**
	 * Starts a new game of TicTacToe.
	 * @param args - No arguments are required.
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}

}
