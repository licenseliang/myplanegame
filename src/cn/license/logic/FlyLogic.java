package cn.license.logic;

import cn.license.Plane;
import cn.license.draw.BaseAction;


public class FlyLogic extends BaseAction implements ILogic{

	public FlyLogic(Plane plane) {
		super(plane);
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
			// 减速出现，加速返回
			plane.speed -= 1;
			plane.y += plane.speed;
			if (plane.y <= -200) {
				plane.isDead = true;
			}
		}
	}
}