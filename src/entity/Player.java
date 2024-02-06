package entity;


public class Player extends Moveable {
	
    public Player(Floor floor) {
		super(floor);
		// TODO Auto-generated constructor stub
	}

    public void move(final Direction direction) {
    	if (this.floor.isNeighbourFree(direction)) {
    		Square neighbour = this.floor.getNeighbour(direction);
    		assert (neighbour.getClass() == Floor.class);
    		this.floor.setMoveable(null);
    		this.floor = (Floor) neighbour;
    		this.floor.setMoveable(this);
    	}
    	
    }
}
