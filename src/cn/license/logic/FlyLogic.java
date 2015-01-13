package cn.license.logic;

import cn.license.Plane;


public class FlyLogic implements ILogic{

	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	// �л��߼�
	public void logic() {
		// ����ѭ������֡�γɶ���
		plane.frameIndex++;
		if (plane.frameIndex >= 10) {
			plane.frameIndex = 0;
		}
		// ��ͬ����ĵл�ӵ�в�ͬ��AI�߼�
		if (!plane.isDead) {
			// ���ٳ��֣����ٷ���
			plane.speed -= 1;
			plane.y += plane.speed;
			if (plane.y <= -200) {
				plane.isDead = true;
			}
		}
	}
}