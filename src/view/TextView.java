package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import control.Controller;

public class TextView {
	
	private static Controller control;
	private static ArrayList<ArrayList<String>> board;
	private static int BOARD_HEIGHT = 10;
	private static int BOARD_WIDTH = 10;
	
	public TextView() {
		this.control = control;
	}
	
	public static void showBoard() {
		
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
		
		board = control.getBoard();	
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
						break;
					case "Goal":
						System.out.println(".");
						break;
				default:
					break;

				}
				
			}
			System.out.println("\n");
		}
		
	}
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public static void main(String[] args) {
		boolean gameon = true;
		
		Scanner myScanner = new Scanner(System.in);
		
		while (gameon) {
			System.out.println("First move");
			TextView.showBoard();
			String move = myScanner.nextLine();
			
		}
	}
	

}
