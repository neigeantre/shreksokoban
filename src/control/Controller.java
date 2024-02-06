package control;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

import java.util.ArrayList;
import java.util.HashMap; 
import entity.Direction;
import entity.Player;
import entity.Warehouse;
import entity.Position;
import entity.Square; 

@objid ("6e8b20f4-934d-4b34-bcde-16593a99e9b9")
public class Controller {
    @objid ("a314485c-751b-4288-9577-e7cb1db4de80")
    private Warehouse warehouse;

    @objid ("0d8b8391-47b4-426c-a8d8-2d8af07dd71a")
    private Player player;
        
    public Controller(Player player, Warehouse warehouse) {
    	this.player = player;
    	this.warehouse = warehouse;
    }

    @objid ("d194fe2c-4505-48ec-81c3-3dfe828c0116")
    public void action(final Direction direction) {
    	this.player.move(direction);
    }
    
    public Position getPos(int i, int j) {
    	ArrayList<Position> positions = warehouse.getPositions();
		for (int k =0; k < positions.size();k++) {
			Position pos = positions.get(k);
			if (pos.getRow()==i && pos.getColumn()==j) {
				return pos;
			}
		
		}
    	return null;
    }
    
    public ArrayList<ArrayList<String>> getBoard() {
    	
    	int BOARD_HEIGHT = 10;
    	int BOARD_WIDTH = 10;
    	
    	ArrayList<ArrayList<String>> board = new ArrayList<>();
		for (int i =0; i< BOARD_HEIGHT; i++) {
			ArrayList<String> subarray = new ArrayList<String>(BOARD_WIDTH);
			for (int j=0; j < BOARD_WIDTH; j++) {
				subarray.add(j,getPos(i,j).getSquare().getType());
				}
			
			board.add(subarray);

		}
    	

    	
    	return board;
    }
}

