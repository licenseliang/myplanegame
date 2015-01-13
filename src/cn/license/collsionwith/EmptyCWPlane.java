package cn.license.collsionwith;

import cn.license.Plane;
import cn.license.draw.BaseAction;

public class EmptyCWPlane extends BaseAction implements ICollsionWithPlane{

	public EmptyCWPlane(Plane plane) {
		super(plane);
	}

	// ÅĞ¶ÏÅö×²(µĞ»úÓëÖ÷½Ç×Óµ¯Åö×²)
	public boolean isCollsionWith(Plane plane) {
		return false;
	}
}
