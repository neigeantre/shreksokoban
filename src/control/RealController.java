package control;

import entity.Direction;
import entity.Player;
import entity.Warehouse;

public class RealController implements IController {
	private Warehouse warehouse;
	private Player player;
	
    public RealController() {
    	warehouse = Warehouse.generateFromFile("/home/arthur/gloo/sokoban/src/control/schemeLevel.txt");
    	player = warehouse.getPlayer();
    }

	@Override
	public void action(Direction direction) {
		// TODO Auto-generated method stub
		this.player.move(direction);
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return warehouse.isComplete();
	}

	@Override
	public int getNbLines() {
		// TODO Auto-generated method stub
		return warehouse.getNbLines();
	}

	@Override
	public int getNbColumns() {
		// TODO Auto-generated method stub
		return warehouse.getNbColumns();
	}

	@Override
	public CaseContent getContent(int ligne, int colonne) {
		// TODO Auto-generated method stub
		return warehouse.getCaseContent(ligne, colonne);
	}

}
