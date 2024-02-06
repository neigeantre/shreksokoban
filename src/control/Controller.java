package control;


import java.util.ArrayList;
import java.util.HashMap; 
import entity.Direction;
import entity.Player;
import entity.Warehouse;
import entity.Position;
import entity.Square;

public class Controller {
    private Warehouse warehouse;

    private Player player;
        
    public Controller(Player player, Warehouse warehouse) {
    	this.player = player;
    	this.warehouse = warehouse;
    }

    public void action(final Direction direction) {
    	this.player.move(direction);
    }
    
    public Position getPos(int i, int j) {
    	ArrayList<Position> positions = warehouse.getPositions();
		for (Position pos: positions) {
			if (pos.getRow()==i && pos.getColumn()==j) {
				return pos;
			}
		
		}
    	return null;
    }
    
    public ArrayList<ArrayList<String>> getBoard() {
    	
    	int BOARD_HEIGHT = 11;
    	int BOARD_WIDTH = 19;
    	
    	ArrayList<ArrayList<String>> board = new ArrayList<>();
		for (int i =0; i< BOARD_HEIGHT; i++) {
			ArrayList<String> subarray = new ArrayList<String>();
			for (int j=0; j < BOARD_WIDTH; j++) {
				if (getPos(i,j) != null) {
					if (getPos(i,j).getSquare() != null) {
						subarray.add(j,getPos(i,j).getSquare().getView());
					}
				}
			}
			board.add(subarray);
		}
    	return board;
    }
    
    public boolean isFinished() {
    	return warehouse.isComplete();
    }
    
    public void translateAction(String useraction) {
    	switch(useraction){
		case "U":
			action(Direction.UP);
			break;
		case "D":
			action(Direction.DOWN);
			break;
		case "L":
			action(Direction.LEFT);
			break;
		case "R":
			action(Direction.RIGHT);
			break;
		
    	default:
    		break;
    	}
    }
}

