package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("cf75c6ab-9e29-46d7-9507-29e1dac0aea6")
public class Position {
    @objid ("d3741440-f645-4d0a-85e3-fd5f86b68659")
    private int row;

    @objid ("bf62665c-6b4b-405e-91dd-76ff8d6ebf26")
    private int column;

    @objid ("505d80c0-920b-4ff1-9645-e949a9d61734")
    private Warehouse warehouse;

    @objid ("559b7e66-8c12-418e-aaf2-a1d5a38ab39a")
    private Square square;

}
