package cn.license.logic;

import cn.license.Plane;
import cn.license.draw.BaseAction;


public class DuckrLogic extends BaseAction implements ILogic{

	public DuckrLogic(Plane plane) {
		super(plane);
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
			plane.x -= plane.speed / 2;
			plane.y += plane.speed;
			if (plane.x < -50) {
				plane.isDead = true;
			}
		}
	}
}