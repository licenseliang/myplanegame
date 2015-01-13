package cn.license.collsionwith;

import cn.license.Plane;
import cn.license.Player;
import cn.license.draw.BaseAction;

public class PlayerCWPlane implements ICollsionWithPlane {

	private Player player;

	public PlayerCWPlane(Player player) {
		this.player = player;
	}

	//判断碰撞(主角与敌机)
	public boolean isCollsionWith(Plane plane) {
		// 是否处于无敌时间
		if (!player.isCollision) {
			int x2 = plane.x;
			int y2 = plane.y;
			int w2 = plane.frameW;
			int h2 = plane.frameH;
			if (player.x >= x2 && player.x >= x2 + w2) {
				return false;
			} else if (player.x < x2
					&& player.x + player.bmpPlayer.getWidth() <= x2) {
				return false;
			} else if (player.y >= y2 && player.y >= y2 + h2) {
				return false;
			} else if (player.y <= y2
					&& player.y + player.bmpPlayer.getHeight() <= y2) {
				return false;
			}
			// 碰撞即进入无敌状态
			player.isCollision = true;
			return true;
			// 处于无敌状态，无视碰撞
		} else {
			return false;
		}
	}
}
