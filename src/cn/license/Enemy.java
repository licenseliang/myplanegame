package cn.license;

import android.graphics.Bitmap;

public class Enemy extends Plane{
	// ��Ӭ
	public static final int TYPE_FLY = 1;
	// Ѽ��(���������˶�)
	public static final int TYPE_DUCKL = 2;
	// Ѽ��(���������˶�)
	public static final int TYPE_DUCKR = 3;

	// �л��Ĺ��캯��
	public Enemy(Bitmap bmpEnemy, int enemyType, int x, int y) {
		this.bmpEnemy = bmpEnemy;
		frameW = bmpEnemy.getWidth() / 10;
		frameH = bmpEnemy.getHeight();
		this.type = enemyType;
		this.x = x;
		this.y = y;
		// ��ͬ����ĵл�Ѫ����ͬ
		switch (type) {
		// ��Ӭ
		case TYPE_FLY:
			speed = 25;
			break;
		// Ѽ��
		case TYPE_DUCKL:
			speed = 3;
			break;
		case TYPE_DUCKR:
			speed = 3;
			break;
		}
	}
}
