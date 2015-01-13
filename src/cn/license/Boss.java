package cn.license;

import android.graphics.Bitmap;
import cn.license.collsionwith.BossCW;
import cn.license.draw.BossDraw;
import cn.license.logic.BossLogic;

public class Boss extends Plane {
	// Boss�Ĺ��캯��
	public Boss(Bitmap bmpEnemy) {
		this.bmpEnemy = bmpEnemy;
		frameW = bmpEnemy.getWidth() / 10;
		frameH = bmpEnemy.getHeight();
		// Boss��x�������
		x = MySurfaceView.screenW / 2 - frameW / 2;
		y = 0;
		this.hp = 50;
		this.setDraw(new BossDraw(this));
		this.setLogic(new BossLogic(this));
		this.setCollsionWith(new BossCW(this));
	}
}
