package vws.tictactoe.view;

import java.util.Scanner;

import vws.tictactoe.model.PlayingField;
import vws.tictactoe.model.PlayingField.FieldMarker;

/**
 * An implementation of the interface view that realizes a console user interface.
 * @author Nina Schulte-Hobein
 */
public class ConsoleView implements View {

	private static Scanner scanner;
	private InputHandler handler;
	
	/**
	 * Initiates everything needed to handle user input.
	 */
	public ConsoleView() {
		scanner = new Scanner(System.in);
		handler = new InputHandler();
	}
	
	@Override
	public void drawGameState(PlayingField playingField, String note) {
		drawGapLine();
		drawMarkerLine(playingField, 0);
		drawDividingLine();
		drawMarkerLine(playingField, 3);
		drawDividingLine();
		drawMarkerLine(playingField, 6);
		drawGapLine();
		System.out.println();
		System.out.println(note);
		int cellIndex = scanner.nextInt();
		handler.selectedIndex(cellIndex);
	}
	
	/**
	 * Draws a horizontal line as part of the playingfield.
	 */
	private void drawDividingLine() {
		System.out.println("---|---|---");
	}
	
	/**
	 * Draws an empty playingfield-line.
	 */
	private void drawGapLine() {
		System.out.println("   |   |   ");
	}
	
	/**
	 * Draws a playingfield-line with cell-values.
	 * @param playingField - the instance of the playingfield containing the cell-values
	 * @param offset - the index-offset for the line that shall be drawn
	 */
	private void drawMarkerLine(PlayingField playingField, int offset) {
		for(int i = offset; i < offset+3; i++) {
			System.out.print(" ");
			FieldMarker marker = playingField.getValueAt(i);
			switch (marker) {
			case EMPTY: System.out.print(i);
						break;
			case X: 	System.out.print("X");
						break;
			case O:		System.out.print("O");
						break;
			}
			System.out.print(" ");
			//print a border line only inside the playingfield
			if(i < offset+2) {
				System.out.print("|");
			}
		}
		System.out.println();
	}
	
	@Override
	public void registerCellSelectedListener(InputListener listener) {
		handler.addListener(listener);	
	}

}
