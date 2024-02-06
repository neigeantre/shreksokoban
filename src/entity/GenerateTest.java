package entity;
import java.util.ArrayList;
import control.Controller;

public class GenerateTest {
	private static Warehouse warehouse;
	private static Player player;
	
	public static Controller generateController() {
		return new Controller(player,warehouse);
	}
	
	public static void generate() {
		ArrayList<Position> positions = new ArrayList<>();
		
		Position pos_r0c0 = new Position(0,0);
		Position pos_r0c1 = new Position(0,1);
		Position pos_r0c2 = new Position(0,2);
		Position pos_r0c3 = new Position(0,3);
		Position pos_r0c4 = new Position(0,4);
		Position pos_r1c0 = new Position(1,0);
		Position pos_r1c1 = new Position(1,1);
		Position pos_r1c2 = new Position(1,2);
		Position pos_r1c3 = new Position(1,3);
		Position pos_r1c4 = new Position(1,4);
		Position pos_r2c0 = new Position(2,0);
		Position pos_r2c1 = new Position(2,1);
		Position pos_r2c2 = new Position(2,2);
		Position pos_r2c3 = new Position(2,3);
		Position pos_r2c4 = new Position(2,4);
		
		positions.add(pos_r0c0);
		positions.add(pos_r0c1);
		positions.add(pos_r0c2);
		positions.add(pos_r0c3);
		positions.add(pos_r0c4);
		positions.add(pos_r1c0);
		positions.add(pos_r1c1);
		positions.add(pos_r1c2);
		positions.add(pos_r1c3);
		positions.add(pos_r1c4);
		positions.add(pos_r2c0);
		positions.add(pos_r2c1);
		positions.add(pos_r2c2);
		positions.add(pos_r2c3);
		positions.add(pos_r2c4);
		
		Wall r0c0 = new Wall(warehouse, pos_r0c0);
		Wall r0c1 = new Wall(warehouse, pos_r0c1);
		Wall r0c2 = new Wall(warehouse, pos_r0c2);
		Wall r0c3 = new Wall(warehouse, pos_r0c3);
		Wall r0c4 = new Wall(warehouse, pos_r0c4);
		Wall r1c0 = new Wall(warehouse, pos_r1c0);
		Floor r1c1 = new Floor(warehouse, pos_r1c1);
		Floor r1c2 = new Floor(warehouse, pos_r1c2);
		Floor r1c3 = new Floor(warehouse, pos_r1c3, true);
		Wall r1c4 = new Wall(warehouse, pos_r1c4);
		Wall r2c0 = new Wall(warehouse, pos_r2c0);
		Wall r2c1 = new Wall(warehouse, pos_r2c1);
		Wall r2c2 = new Wall(warehouse, pos_r2c2);
		Wall r2c3 = new Wall(warehouse, pos_r2c3);
		Wall r2c4 = new Wall(warehouse, pos_r2c4);
		
		player = new Player(r1c1);
		r1c1.setMoveable(player);
		
		pos_r0c0.setSquare(r0c0);
		pos_r0c1.setSquare(r0c1);
		pos_r0c2.setSquare(r0c2);
		pos_r0c3.setSquare(r0c3);
		pos_r0c4.setSquare(r0c4);
		pos_r1c0.setSquare(r1c0);
		pos_r1c1.setSquare(r1c1);
		pos_r1c2.setSquare(r1c2);
		pos_r1c3.setSquare(r1c3);
		pos_r1c4.setSquare(r1c4);
		pos_r2c0.setSquare(r2c0);
		pos_r2c1.setSquare(r2c1);
		pos_r2c2.setSquare(r2c2);
		pos_r2c3.setSquare(r2c3);
		pos_r2c4.setSquare(r2c4);
		
		warehouse = new Warehouse(positions, new ArrayList<Square>());
		ArrayList<Square> squares = new ArrayList<Square>();
		squares.add(r0c0);
		squares.add(r0c1);
		squares.add(r0c2);
		squares.add(r0c3);
		squares.add(r0c4);
		squares.add(r1c0);
		squares.add(r1c1);
		squares.add(r1c2);
		squares.add(r1c3);
		squares.add(r1c4);
		squares.add(r2c0);
		squares.add(r2c1);
		squares.add(r2c2);
		squares.add(r2c3);
		squares.add(r2c4);
		
		Stone stone = new Stone(r1c2);
		r1c2.setMoveable(stone);
		
		warehouse.setSquares(squares);
		for (Square s:squares) {
			s.setWarehouse(warehouse);
		}
		
		System.out.println("Voisin de droite de r1c1 : " + r1c1.getNeighbour(Direction.RIGHT).getPosition());

	}
}
