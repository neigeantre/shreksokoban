package entity;
import java.util.ArrayList;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("cf75c6ab-9e29-46d7-9507-29e1dac0aea6")
public class Position {
	
	public static ArrayList<Position> generateGrid(int height, int width, Warehouse warehouse){
		ArrayList<Position> grid = new ArrayList<>(); 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid.add(new Position(i, j));
			}
		}
		return grid;
	}
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
		this.square = null;
	}
	
    public Position(int row, int column, Square square) {
		this.row = row;
		this.column = column;
		this.square = square;
	}

	@objid ("d3741440-f645-4d0a-85e3-fd5f86b68659")
    private int row;

    @objid ("bf62665c-6b4b-405e-91dd-76ff8d6ebf26")
    private int column;

    @objid ("559b7e66-8c12-418e-aaf2-a1d5a38ab39a")
    private Square square;

	public Square getSquare() {
		return square;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public String toString() {
		return "(" + row + ", " + column + ")";
	}

	public void setSquare(Square square) {
		this.square = square;
	}
}
