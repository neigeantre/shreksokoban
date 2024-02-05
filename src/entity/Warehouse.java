package entity;

import java.util.ArrayList;
import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("c8e0e928-61bf-4b53-8d1e-88b44e44d04a")
public class Warehouse {
    @objid ("ee3812eb-85c9-4ff5-af1c-acd6139cdfae")
    private ArrayList<Position> positions = new ArrayList<Position> ();

    @objid ("1fe578cf-6887-44d2-9332-dc8dcb8978ab")
    private ArrayList<Square> squares = new ArrayList<Square> ();
    
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
}
