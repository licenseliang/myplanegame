package cn.license.collsionwith;

import cn.license.Bullet;
import cn.license.Plane;
import cn.license.draw.BaseAction;

public class EmptyCW extends BaseAction implements ICollsionWith{

	public EmptyCW(Plane plane) {
		super(plane);
	}

	// ÅĞ¶ÏÅö×²(µĞ»úÓëÖ÷½Ç×Óµ¯Åö×²)
	public boolean isCollsionWith(Bullet bullet) {
		return false;
	}
}
