package cn.license.collsionwith;

import cn.license.Bullet;
import cn.license.Plane;

public interface ICollsionWith {
	public void setPlane(Plane plane);
	public boolean isCollsionWith(Bullet bullet);
}
