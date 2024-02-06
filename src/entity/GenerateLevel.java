package gloo.projet;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileInputStream; // Import the Scanner class to read text files
import java.io.IOException;
import java.util.ArrayList;


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
	          i++;
	          Position pos = addPosition(positions,i,j);
	          
	          
	          switch(current) {
	          case '\n':
	        	  j++;
	        	  break;
	          case '#':
	        	  Wall wall = new Wall(warehouse, pos);
	        	  position.setSquare(wall);
	        	  squares.add(wall);
	        	  break;
	          case '$':
	        	  Floor floor = new Floor(warehouse, pos, false);
	        	  squares.add(floor);
	        	  Stone stone = new Stone(floor);   			
	        	  floor.setMoveable(stone);
	        	  position.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          case '@':
	        	  Floor floor = new Floor(warehouse, pos, false);
	        	  squares.add(floor);        	  
	        	  Player player = new Player(floor);
	      		  floor.setMoveable(player);
	      		  position.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          case '.':
	        	  Floor floor = new Floor(warehouse, pos, true);
	        	  position.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          case ' ':
	        	  Floor floor = new Floor(warehouse, pos, false);
	        	  position.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          
	          }
	          
	          System.out.print(current);
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
