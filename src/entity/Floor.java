package entity;

import control.CaseContent;

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

    private boolean isGoal;

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
    
    public Player getPlayer() {
    	if (moveable!=null && moveable.getClass()==Player.class) {
    		return (Player) moveable;
    	}
    	return null;
    }

	@Override
	public CaseContent evaluateCaseContent() {
		// TODO Auto-generated method stub
		if (isGoal) {
			if (moveable==null) {
				return CaseContent.GOAL;
			} else if (moveable.getClass()==Player.class) {
				return CaseContent.MAN;
			} else {
				return CaseContent.BOX_ON_GOAL;
			}
		} else {
			if (moveable==null) {
				return CaseContent.EMPTY_FLOOR;
			} else if (moveable.getClass()==Player.class) {
				return CaseContent.MAN;
			} else {
				return CaseContent.BOX;
			}
		}
	}
}
