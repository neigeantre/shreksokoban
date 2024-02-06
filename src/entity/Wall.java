package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7e4794ac-4e29-491c-bce7-44c2e36a2a6b")
public class Wall extends Square {
	public Wall(Warehouse warehouse, Position position) {
		super(warehouse, position);
		// TODO Auto-generated constructor stub
	}

	public boolean isPartiallyFree(Direction direction) {
		return false;
	}
	
	public boolean isCompletelyFree() {
		return false;
	}
	
	@Override
	public String getType() {
		
		return "Wall";
	}
}
