package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("458c24cf-feeb-42b5-9254-9e1e0d05e4b4")
public class Floor extends Square {
    public Floor(Warehouse warehouse, Position position) {
		super(warehouse, position);
		isGoal=false;
		// TODO Auto-generated constructor stub
	}
    
    public Floor(Warehouse warehouse, Position position, boolean isGoal) {
    	super(warehouse, position);
    	this.isGoal = isGoal;
    }

	@objid ("409de5df-f2ef-46b1-8d09-978b8640100d")
    private boolean isGoal;

    @objid ("e884bd15-b489-41f5-8f09-9ee67ad46202")
    private Moveable moveable;
    
    @Override
    public String getView() {
    	if (isGoal) {
    		if (moveable == null) {
    			return ".";
    		} else if (moveable.getClass() == Player.class) {
    			return "+";
    		} else {
    			return "*";
    		}
    	} else {
    		if (moveable == null) {
    			return " ";
    		} else if (moveable.getClass() == Player.class) {
    			return "@";
    		} else {
    			return "$";
    		}
    	}
    }
    
    boolean checkIfGoal() {
    	return isGoal;
    }
    

    @objid ("a5890ffa-c71a-4125-a810-056902cea10b")
    public boolean isNeighbourFree(final Direction direction) {
    	Square neighbour = this.warehouse.getNeighbour(this,direction);
    	return neighbour.isPartiallyFree(direction);
    }
    
    public boolean isCompletelyFree() {
    	return moveable==null;
    }
    
    public boolean isPartiallyFree(Direction direction) {
    	if (this.isCompletelyFree()){
    		return true;
    	} else if (this.moveable.getClass()==Stone.class) {
    		this.moveable = (Stone) this.moveable;
    		Square neighbour = this.warehouse.getNeighbour(this, direction);
    		if (neighbour.getClass() == Floor.class) {
    			if (neighbour.isCompletelyFree()) {
	    			this.warehouse.allocate(this.moveable,(Floor) neighbour);
	    			this.moveable.setFloor((Floor) neighbour);
	    			this.moveable = null;
	    			return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void setMoveable(Moveable m) {
    	this.moveable = m;
    }
    
    public Square getNeighbour(Direction direction) {
    	return this.warehouse.getNeighbour(this, direction);
    }
    
    // return true if it is not a goal or if it is a goal occupied by a stone
    public boolean isValid() {
    	if (isGoal) {
    		return moveable != null && moveable.getClass() == Stone.class;
    	}
    	return true;
    }
}
