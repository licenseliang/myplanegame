package cn.license.collsionwith;

import cn.license.Plane;

public class EmptyCWPlane implements ICollsionWithPlane{
	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	// �ж���ײ(�л��������ӵ���ײ)
	public boolean isCollsionWith(Plane plane) {
		return false;
	}
}
