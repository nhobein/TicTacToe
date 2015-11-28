package vws.tictactoe.controller;

import vws.tictactoe.model.PlayingField;
import vws.tictactoe.view.InputListener;
import vws.tictactoe.view.View;
import vws.tictactoe.view.ConsoleView;

/**
 * A controller class that administrates view, playingfield and referee.
 * @author Nina Schulte-Hobein
 */
public class Game implements InputListener {

	private View view;
	private PlayingField playingField;
	private GameReferee referee;
	
	/**
	 * Instantiates a new view and registers itself as listener for userinput.
	 */
	public Game() {
		view = new ConsoleView();
		view.registerCellSelectedListener(this);
	}
	
	/**
	 * Starts a new game of Tic Tac Toe.
	 */
	public void start() {
		playingField = new PlayingField();
		referee = new GameReferee(playingField);
		actualizeGameState(referee.getActualNote());
	}

	/**
	 * Actualizes the view of the game.
	 * @param note - an information note for the players
	 */
	private void actualizeGameState(String note) {
		view.drawGameState(playingField, note);
	}

	@Override
	public void selectedIndex(int cellIndex) {
		referee.checkMove(cellIndex);
		actualizeGameState(referee.getActualNote());
	}

	public PlayingField getPlayingField() {
		return playingField;
	}

}
