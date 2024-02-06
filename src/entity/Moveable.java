package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("2db2a328-bb2e-45da-a016-2fb09771ef3e")
public abstract class Moveable {
    public Moveable(Floor floor) {
		this.floor = floor;
	}

	@objid ("b39ec76f-4022-4113-b29f-6e5ccc978144")
    protected Floor floor;

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

}
