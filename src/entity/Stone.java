package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("ea2e33f9-dec1-48ee-bea1-93eccafc46c7")
public class Stone extends Moveable {
	
	public Stone(Floor floor) {
		super(floor);
		// TODO Auto-generated constructor stub
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
    @Override
    String getType() {
    	return "Stone";
    }

}
