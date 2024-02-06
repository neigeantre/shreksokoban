package control;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileInputStream; // Import the Scanner class to read text files
import java.io.IOException;
import java.util.ArrayList;

import entity.Floor;
import entity.Player;
import entity.Position;
import entity.Square;
import entity.Stone;
import entity.Wall;
import entity.Warehouse;


public class GenerateLevel {
	private String filename;
	
	public GenerateLevel(String filename) {
		this.filename = filename;
	}
	
	private static Warehouse warehouse;
	private static Player player;
	
	public static Controller generateController() {
		return new Controller(player,warehouse);
	}
	
	
	public static void readFile(String filename) {
		ArrayList<Position> positions = new ArrayList<>();
		ArrayList<Square> squares = new ArrayList<Square>();
		warehouse = new Warehouse(positions, new ArrayList<Square>());
		
		
	    try {
	    	FileInputStream fis = new FileInputStream(filename);
	        char current;
	        int i =0;
	        int j =0;
	        while (fis.available() > 0) {
	          current = (char) fis.read();
	          Position pos = new Position(j,i);
	          i++;
	          positions.add(pos);
	          
	          switch(current) {
	          case '\n':
	        	  j++;
	        	  i=0;
	        	  break;
	          case '#':
	        	  Wall wall = new Wall(warehouse, pos);
	        	  pos.setSquare(wall);
	        	  squares.add(wall);
	        	  break;
	          case '$': {
	        	  Floor floor = new Floor(warehouse, pos, false);
	        	  squares.add(floor);
	        	  Stone stone = new Stone(floor);   			
	        	  floor.setMoveable(stone);
	        	  pos.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          }
	          case '@': {
	        	  Floor floor = new Floor(warehouse, pos, false);
	        	  squares.add(floor);        	  
	        	  player = new Player(floor);
	      		  floor.setMoveable(player);
	      		  pos.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          }
	          case '.': {
	        	  Floor floor = new Floor(warehouse, pos, true);
	        	  pos.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          }
	          case ' ': {
	        	  Floor floor = new Floor(warehouse, pos, false);
	        	  pos.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          }
	          }
	          
	        }
	        warehouse.setSquares(squares);
			for (Square s:squares) {
				s.setWarehouse(warehouse);
			}
	    } catch (IOException e) {
	        e.printStackTrace();
	      }
	  }
  
  
	
  
}
