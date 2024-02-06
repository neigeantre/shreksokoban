package entity;

import control.CaseContent;

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

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaseContent evaluateCaseContent() {
		// TODO Auto-generated method stub
		return CaseContent.WALL;
	}
}
