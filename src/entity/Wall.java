package entity;

import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("7e4794ac-4e29-491c-bce7-44c2e36a2a6b")
public class Wall extends Square {
	
	@Override
	String getType() {
		
		return "Wall";
	}
}
