package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import entity.GenerateTest;
import control.GenerateLevel;

import control.Controller;

public class TextView {
	
	private static Controller control;
	private static ArrayList<ArrayList<String>> board;
	private static int BOARD_HEIGHT = 11;
	private static int BOARD_WIDTH = 19;
	

	
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
			for (int j=0;j < board.get(i).size(); j++) {
				System.out.print(board.get(i).get(j));
			}
			System.out.print("\n");
		}
		
	}
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	public static void main(String[] args) {
		
		//GenerateTest.generate();
		//control = GenerateTest.generateController();
		
		GenerateLevel.readFile("/home/arthur/gloo/sokoban/src/control/schemeLevel.txt");
		control = GenerateLevel.generateController();
		System.out.println(control.getPos(2, 2));
		System.out.println(control.getBoard());
		
		Scanner myScanner = new Scanner(System.in);
		
		clearScreen();
		System.out.println("\n\n");
		TextView.showBoard();
		
		while (!control.isFinished()) {
			String move = myScanner.nextLine();
			control.translateAction(move);
			
			clearScreen();
			System.out.println("\n\n");
			TextView.showBoard();
			
			if (control.isFinished()) {
				System.out.println("Vous avez gagné !");
			}
		}
		
		myScanner.close();
	}
	

}
