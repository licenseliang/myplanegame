package cn.license.logic;

import cn.license.MySurfaceView;
import cn.license.draw.Plane;


public class DucklLogic implements ILogic{

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
			// б���½��˶�
			plane.x += plane.speed / 2;
			plane.y += plane.speed;
			if (plane.x > MySurfaceView.screenW) {
				plane.isDead = true;
			}
		}
	}
}