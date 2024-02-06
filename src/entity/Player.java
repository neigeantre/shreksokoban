package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("a6fd0137-8e93-43cc-902c-d5e1b6eefc65")
public class Player extends Moveable {
	
    public Player(Floor floor) {
		super(floor);
		// TODO Auto-generated constructor stub
	}

	@objid ("10549e0f-6a02-4a25-9749-de59b724f856")
    public void move(final Direction direction) {
    	if (this.floor.isNeighbourFree(direction)) {
    		Square neighbour = this.floor.getNeighbour(direction);
    		assert (neighbour.getClass() == Floor.class);
    		this.floor = (Floor) neighbour;
    	}
    	
    }

	
    @Override
    String getType() {
    	return "Player";
    }
}
