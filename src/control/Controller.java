package control;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import entity.Direction;
import entity.Player;
import entity.Warehouse;

@objid ("6e8b20f4-934d-4b34-bcde-16593a99e9b9")
public class Controller {
    @objid ("a314485c-751b-4288-9577-e7cb1db4de80")
    private Warehouse warehouse;

    @objid ("0d8b8391-47b4-426c-a8d8-2d8af07dd71a")
    private Player player;

    @objid ("d194fe2c-4505-48ec-81c3-3dfe828c0116")
    public void action(final Direction direction) {
    }

    @objid ("cb8b4936-a05b-4ca9-8980-b0734cfe3789")
    public void action (LEFT)() {
    }

    @objid ("4e88075a-03f0-4ef1-a56d-79772818842a")
    public void test() {
    }

}
