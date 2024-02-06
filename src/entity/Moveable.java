package entity;


public abstract class Moveable {
    public Moveable(Floor floor) {
		this.floor = floor;
	}

    protected Floor floor;

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

}
