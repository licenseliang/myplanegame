package cn.license.collsionwith;

import cn.license.Bullet;
import cn.license.Plane;

public class BossCW  implements ICollsionWith{
	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	/**
	 * ÅĞ¶ÏÅö×²(Boss±»Ö÷½Ç×Óµ¯»÷ÖĞ)
	 */
	public boolean isCollsionWith(Bullet bullet) {
		int x2 = bullet.bulletX;
		int y2 = bullet.bulletY;
		int w2 = bullet.bmpBullet.getWidth();
		int h2 = bullet.bmpBullet.getHeight();
		if (plane.x >= x2 && plane.x >= x2 + w2) {
			return false;
		} else if (plane.x <= x2 && plane.x + plane.frameW <= x2) {
			return false;
		} else if (plane.y >= y2 && plane.y >= y2 + h2) {
			return false;
		} else if (plane.y <= y2 && plane.y + plane.frameH <= y2) {
			return false;
		}
		return true;
	}
}
