package cn.license.logic;

import cn.license.MySurfaceView;
import cn.license.Player;

public class PlayerLogic implements ILogic {

	private Player player;

	public PlayerLogic(Player player) {
		this.player = player;
	}

	public void logic() {
		// ���������ƶ�
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
		// �ж���ĻX�߽�
		if (player.x + player.bmpPlayer.getWidth() >= MySurfaceView.screenW) {
			player.x = MySurfaceView.screenW - player.bmpPlayer.getWidth();
		} else if (player.x <= 0) {
			player.x = 0;
		}
		// �ж���ĻY�߽�
		if (player.y + player.bmpPlayer.getHeight() >= MySurfaceView.screenH) {
			player.y = MySurfaceView.screenH - player.bmpPlayer.getHeight();
		} else if (player.y <= 0) {
			player.y = 0;
		}
		// �����޵�״̬
		if (player.isCollision) {
			// ��ʱ����ʼ��ʱ
			player.noCollisionCount++;
			if (player.noCollisionCount >= player.noCollisionTime) {
				// �޵�ʱ����󣬽���޵�״̬����ʼ����ʱ��
				player.isCollision = false;
				player.noCollisionCount = 0;
			}
		}
	}
}