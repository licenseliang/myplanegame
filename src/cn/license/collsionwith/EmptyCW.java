package cn.license.collsionwith;

import cn.license.Bullet;
import cn.license.Plane;

public class EmptyCW implements ICollsionWith{
	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	// �ж���ײ(�л��������ӵ���ײ)
	public boolean isCollsionWith(Bullet bullet) {
		return false;
	}
}
