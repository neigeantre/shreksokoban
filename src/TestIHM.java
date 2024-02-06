import javax.swing.SwingUtilities;

import control.MockController;
import gui.SokobanWindow;

/**
 * Application de test de l'IHM du jeu Sokoban en utilisant le controleur bouchon
 * 
 * @author Dominique Marcadet
 * @version 1.1
 *
 */
public class TestIHM implements Runnable {

	@Override
	public void run() {
    	new SokobanWindow(new MockController());
	}

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new TestIHM());
    }
}
