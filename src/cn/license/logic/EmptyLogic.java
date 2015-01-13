package cn.license.logic;

import cn.license.Plane;
import cn.license.draw.BaseAction;

public class EmptyLogic extends BaseAction implements ILogic {

	public EmptyLogic(Plane plane) {
		super(plane);
	}

	public void logic() {
		// do nothing
	}
}