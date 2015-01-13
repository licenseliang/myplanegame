package cn.license.collsionwith;

import cn.license.Bullet;
import cn.license.Player;

public class PlayerCW implements ICollsionWith {
	private Player player;
	public PlayerCW(Player player) {
		this.player = player;
	}

	// �ж���ײ(�л��������ӵ���ײ)
	public boolean isCollsionWith(Bullet bullet) {
		// �Ƿ����޵�ʱ��
		if (!player.isCollision) {
			int x2 = bullet.bulletX;
			int y2 = bullet.bulletY;
			int w2 = bullet.bmpBullet.getWidth();
			int h2 = bullet.bmpBullet.getHeight();
			if (player.x >= x2 && player.x >= x2 + w2) {
				return false;
			} else if (player.x <= x2
					&& player.x + player.bmpPlayer.getWidth() <= x2) {
				return false;
			} else if (player.y >= y2 && player.y >= y2 + h2) {
				return false;
			} else if (player.y <= y2
					&& player.y + player.bmpPlayer.getHeight() <= y2) {
				return false;
			}
			// ��ײ�������޵�״̬
			player.isCollision = true;
			return true;
			// �����޵�״̬��������ײ
		} else {
			return false;
		}
	}
}
