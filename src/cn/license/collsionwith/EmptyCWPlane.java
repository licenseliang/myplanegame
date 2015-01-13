package cn.license.collsionwith;

import cn.license.Plane;

public class EmptyCWPlane implements ICollsionWithPlane{
	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	// ÅĞ¶ÏÅö×²(µĞ»úÓëÖ÷½Ç×Óµ¯Åö×²)
	public boolean isCollsionWith(Plane plane) {
		return false;
	}
}
