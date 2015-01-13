package cn.license.logic;

import cn.license.draw.Plane;


public class DuckrLogic implements ILogic{

	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	// 敌机逻辑
	public void logic() {
		// 不断循环播放帧形成动画
		plane.frameIndex++;
		if (plane.frameIndex >= 10) {
			plane.frameIndex = 0;
		}
		// 不同种类的敌机拥有不同的AI逻辑
		if (!plane.isDead) {
			// 斜左下角运动
			plane.x -= plane.speed / 2;
			plane.y += plane.speed;
			if (plane.x < -50) {
				plane.isDead = true;
			}
		}
	}
}