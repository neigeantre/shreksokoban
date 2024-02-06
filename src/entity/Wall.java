package entity;


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
	public String getView() {
		
		return "#";
	}
}
