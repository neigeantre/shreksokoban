package entity;

import java.util.ArrayList;
import java.util.List;

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
}
