package cn.license.collsionwith;

import cn.license.Bullet;
import cn.license.Plane;
import cn.license.draw.BaseAction;

public class EmptyCW extends BaseAction implements ICollsionWith{

	public EmptyCW(Plane plane) {
		super(plane);
	}

	// �ж���ײ(�л��������ӵ���ײ)
	public boolean isCollsionWith(Bullet bullet) {
		return false;
	}
}
