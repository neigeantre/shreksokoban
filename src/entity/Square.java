package entity;
import control.CaseContent;


public abstract class Square {
    public Square(Warehouse warehouse, Position position) {
		this.warehouse = warehouse;
		this.position = position;
	}

    protected Warehouse warehouse;

    protected Position position;

	public Position getPosition() {
		return position;
	}
	
    public abstract boolean isPartiallyFree(Direction direction);
    
    public abstract boolean isCompletelyFree();
    
    public abstract String getView();

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	public abstract Player getPlayer();
	
	public abstract CaseContent evaluateCaseContent();
}
