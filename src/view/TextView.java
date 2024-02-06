package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import entity.GenerateTest;

import control.Controller;

public class TextView {
	
	private static Controller control;
	private static ArrayList<ArrayList<String>> board;
	private static int BOARD_HEIGHT = 3;
	private static int BOARD_WIDTH = 5;
	

	
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
					case "Wall":
						System.out.print("#");
						break;
					case "Player":
						System.out.print("@");
						break;
					case "Stone":
						System.out.print("$");
						break;
					case "Goal":
						System.out.print(".");
						break;
				default:
					System.out.print(" ");
					break;

				}
				
			}
			System.out.print("\n");
		}
		
	}
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public static void main(String[] args) {
		boolean gameon = true;
		
		GenerateTest.generate();
		control = GenerateTest.generateController();
		System.out.println(control.getPos(2, 2));
		System.out.println(control.getBoard());
		
		Scanner myScanner = new Scanner(System.in);
		
		while (gameon) {
			System.out.println("First move");
			TextView.showBoard();
			String move = myScanner.nextLine();
				
			control.translateAction(move);
			
		}
		
		myScanner.close();
	}
	

}
