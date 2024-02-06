package entity;
import java.util.ArrayList;


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

    private int row;

    private int column;

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
