package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import control.Controller;

public class TextView {
	
	private Controller control;
	private ArrayList<ArrayList<String>> board;
	private int BOARD_HEIGHT = 10;
	private int BOARD_WIDTH = 10;
	
	public TextView() {
		this.control = control;
	}
	
	public void showBoard() {
		
		/*
		 Légende :

			# : mur
			$ : caisse
			. : destination
		 	* : caisse sur une zone de rangement (pas présente dans ce niveau)
			@ : personnage
			+ : personnage sur une zone de rangement (pas présent dans ce niveau)
		 */
		
		// initialise board
		
		board = new ArrayList<>();
		for (int i =0; i< BOARD_HEIGHT; i++) {
			board.add(new ArrayList<String>(BOARD_WIDTH));
		}
		
		control.getBoard().forEach(
				(key, value)
					-> board.add(key.column,value));
		
		//
		for (int i=0;i<BOARD_HEIGHT; i++) {
			for (int j=0;j < BOARD_WIDTH; j++) {
				switch (board.get(i).get(j)) {
					case null:
						System.out.println(" ");
						break;
					case "Wall":
						System.out.println("#");
						break;
					case "Player":
						System.out.println("@");
						break;
					case "Stone":
						System.out.println("$");

				}
				
			}
		}
		
	}

}
