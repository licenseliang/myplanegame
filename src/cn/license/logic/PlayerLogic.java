package cn.license.logic;

import cn.license.MySurfaceView;
import cn.license.Player;

public class PlayerLogic implements ILogic {

	private Player player;

	public PlayerLogic(Player player) {
		this.player = player;
	}

	public void logic() {
		// 处理主角移动
		if (player.isLeft) {
			player.x -= player.speed;
		}
		if (player.isRight) {
			player.x += player.speed;
		}
		if (player.isUp) {
			player.y -= player.speed;
		}
		if (player.isDown) {
			player.y += player.speed;
		}
		// 判断屏幕X边界
		if (player.x + player.bmpPlayer.getWidth() >= MySurfaceView.screenW) {
			player.x = MySurfaceView.screenW - player.bmpPlayer.getWidth();
		} else if (player.x <= 0) {
			player.x = 0;
		}
		// 判断屏幕Y边界
		if (player.y + player.bmpPlayer.getHeight() >= MySurfaceView.screenH) {
			player.y = MySurfaceView.screenH - player.bmpPlayer.getHeight();
		} else if (player.y <= 0) {
			player.y = 0;
		}
		// 处理无敌状态
		if (player.isCollision) {
			// 计时器开始计时
			player.noCollisionCount++;
			if (player.noCollisionCount >= player.noCollisionTime) {
				// 无敌时间过后，解除无敌状态及初始化计时器
				player.isCollision = false;
				player.noCollisionCount = 0;
			}
		}
	}
}