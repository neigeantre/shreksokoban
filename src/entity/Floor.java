package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("458c24cf-feeb-42b5-9254-9e1e0d05e4b4")
public class Floor extends Square {
    public Floor(Warehouse warehouse, Position position) {
		super(warehouse, position);
		// TODO Auto-generated constructor stub
	}

	@objid ("409de5df-f2ef-46b1-8d09-978b8640100d")
    private boolean isGoal;

    @objid ("e884bd15-b489-41f5-8f09-9ee67ad46202")
    private Moveable moveable;
    
    @Override
    public String getType() {
    	if (isGoal) {
    		return "Goal";
    	}
    	else if (moveable==null) {
    		return " ";
    	}
    	return moveable.getType();
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
}
