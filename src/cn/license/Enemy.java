package cn.license;

import android.graphics.Bitmap;

public class Enemy extends Plane{
	// 苍蝇
	public static final int TYPE_FLY = 1;
	// 鸭子(从左往右运动)
	public static final int TYPE_DUCKL = 2;
	// 鸭子(从右往左运动)
	public static final int TYPE_DUCKR = 3;

	// 敌机的构造函数
	public Enemy(Bitmap bmpEnemy, int enemyType, int x, int y) {
		this.bmpEnemy = bmpEnemy;
		frameW = bmpEnemy.getWidth() / 10;
		frameH = bmpEnemy.getHeight();
		this.type = enemyType;
		this.x = x;
		this.y = y;
		// 不同种类的敌机血量不同
		switch (type) {
		// 苍蝇
		case TYPE_FLY:
			speed = 25;
			break;
		// 鸭子
		case TYPE_DUCKL:
			speed = 3;
			break;
		case TYPE_DUCKR:
			speed = 3;
			break;
		}
	}
}
