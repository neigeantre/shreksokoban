package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("25602798-ec4d-4bed-b6da-6e47876adf00")
public abstract class Square {
    public Square(Warehouse warehouse, Position position) {
		this.warehouse = warehouse;
		this.position = position;
	}

	@objid ("78fc409e-5e82-48b6-93ff-cb38c7107647")
    protected Warehouse warehouse;

    @objid ("dd71c13a-59c1-4d7d-bf5e-47ee17577a54")
    protected Position position;

	public Position getPosition() {
		return position;
	}
	
    public abstract boolean isPartiallyFree(Direction direction);
    
    public abstract boolean isCompletelyFree();
    
    abstract String getType();
}
