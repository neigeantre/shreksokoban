package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("458c24cf-feeb-42b5-9254-9e1e0d05e4b4")
public class Floor extends Square {
    @objid ("409de5df-f2ef-46b1-8d09-978b8640100d")
    private boolean isGoal;

    @objid ("e884bd15-b489-41f5-8f09-9ee67ad46202")
    private Moveable moveable;

}
