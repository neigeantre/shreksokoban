package entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import control.CaseContent;

public class Warehouse {
    private ArrayList<Position> positions = new ArrayList<Position> ();

    private ArrayList<Square> squares = new ArrayList<Square> ();
    
    public Square getNeighbour(Square square, Direction direction) {
    	Position position = square.getPosition();
    	int rowDifference = 0;
    	int columnDifference = 0;
    	switch (direction) {
    		case LEFT:
    			columnDifference = -1;
    			break;
    		case RIGHT:
    			columnDifference = 1;
    			break;
    		case UP:
    			rowDifference = -1;
    			break;
    		case DOWN:
    			rowDifference = 1;
    			break;
    	}
    	for (Position otherPosition : positions) {
    		if (otherPosition.getColumn() == position.getColumn() + columnDifference && 
    				otherPosition.getRow() == position.getRow() + rowDifference) {
    			return otherPosition.getSquare();
    		}
    	}
    	return null;
    }
    
    public void allocate(Moveable m, Floor floor) {
    	floor.setMoveable(m);
    }

    
    public Warehouse(ArrayList<Position> positions, ArrayList<Square> squares) {
    	this.positions = positions;
    	this.squares = squares;
    }
    
    public ArrayList<Square> getSquares(){
    	return this.squares;
    }
    
    public ArrayList<Position> getPositions(){
    	return this.positions;
    }

	public void setSquares(ArrayList<Square> squares) {
		this.squares = squares;
	}
	
	public boolean isComplete() {
		for (Square square: squares) {
			if (square.getClass() == Floor.class && !((Floor) square).isValid()) {
				return false;
			}
 		}
		return true;
	}
	
	public static Warehouse generateFromFile(String filename) {
		ArrayList<Position> positions = new ArrayList<>();
		ArrayList<Square> squares = new ArrayList<Square>();
		Warehouse warehouse = new Warehouse(positions, new ArrayList<Square>());
		
	    try {
	    	FileInputStream fis = new FileInputStream(filename);
	        char current;
	        int i = 0;
	        int j = 0;
	        while (fis.available() > 0) {
	          current = (char) fis.read();
	          Position pos = new Position(j,i);
	          i++;
	          positions.add(pos);
	          Player player = new Player(null);
	          
	          switch(current) {
	          case '\n':
	        	  j++;
	        	  i=0;
	        	  break;
	          case '+': {
	        	  Floor floor = new Floor(warehouse, pos, true);
	        	  squares.add(floor);        	  
	        	  player = new Player(floor);
	      		  floor.setMoveable(player);
	      		  pos.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          }
	          case '*': {
	        	  Floor floor = new Floor(warehouse, pos, true);
	        	  squares.add(floor);
	        	  Stone stone = new Stone(floor);   			
	        	  floor.setMoveable(stone);
	        	  pos.setSquare(floor);
	        	  squares.add(floor);
	        	  break;
	          }
	          case '#': {
	        	  Wall wall = new Wall(warehouse, pos);
	        	  pos.setSquare(wall);
	        	  squares.add(wall);
	        	  break;
	          }
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
			return warehouse;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	      }
	  }
	
	public Player getPlayer() {
		for (Square square: squares) {
			if (square.getPlayer() != null) {
				return square.getPlayer();
			}
		}
		return null;
	}
	
	public int getNbLines() {
		int nbLines = 0;
		for (Position pos: positions) {
			if (pos.getRow() > nbLines) {
				nbLines = pos.getRow();
			}
		}
		return nbLines;
	}
	
	public int getNbColumns() {
		int nbColumns = 0;
		for (Position pos: positions) {
			if (pos.getColumn() > nbColumns) {
				nbColumns = pos.getColumn();
			}
		}
		return nbColumns;
	}
	
	public Square getSquare(int ligne, int colonne) {
		Position selectedPos = new Position(0,0);
		for (Position pos: positions) {
			if (pos.getRow()==ligne && pos.getColumn()==colonne) {
				selectedPos = pos;
			}
		}
		for (Square square: squares) {
			if (square.getPosition()==selectedPos) {
				return square;
			}
		}
		return null;
	}
	
	public CaseContent getCaseContent(int ligne, int colonne) {
		Square s = this.getSquare(ligne, colonne);
		if (s!=null) {
			return s.evaluateCaseContent();
		}
		return null;
	}
}
