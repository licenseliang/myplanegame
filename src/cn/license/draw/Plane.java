package cn.license.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import cn.license.Bullet;
import cn.license.MySurfaceView;
import cn.license.collsionwith.ICollsionWith;
import cn.license.logic.ILogic;

public class Plane {
	// 绘制
	private IDraw draw;
	// 逻辑
	private ILogic logic;
	//碰撞
	private ICollsionWith collsionWith;
	// 敌机的种类标识
	public int type;
	// 苍蝇
	public static final int TYPE_FLY = 1;
	// 鸭子(从左往右运动)
	public static final int TYPE_DUCKL = 2;
	// 鸭子(从右往左运动)
	public static final int TYPE_DUCKR = 3;
	// 敌机图片资源
	public Bitmap bmpEnemy;
	// 敌机坐标
	public int x, y;
	// 敌机每帧的高度
	public int frameW, frameH;
	// 敌机当前帧下标
	public int frameIndex;
	// 敌机的移动速度
	public int speed;
	// 判断敌机是否已经出屏
	public boolean isDead;
	// boss的运动轨迹
	// 一定事件会向着屏幕下方运动，并且发射大范围子弹，（是否狂态）
	// 正常状态下，子弹垂直朝下运动
	public boolean isCrazy;
	// 进入疯狂状态的状态时间间隔
	public int crazyTime = 200;
	// 计算器
	public int count;

	// Boss的构造函数
	public Plane(Bitmap bmpBoss) {
		this.bmpEnemy = bmpBoss;
		frameW = bmpBoss.getWidth() / 10;
		frameH = bmpBoss.getHeight();
		// Boss的x坐标居中
		x = MySurfaceView.screenW / 2 - frameW / 2;
		y = 0;
	}

	// 敌机的构造函数
	public Plane(Bitmap bmpEnemy, int enemyType, int x, int y) {
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

	public void draw(Canvas canvas, Paint paint) {
		draw.draw(canvas, paint);
	}

	// 敌机逻辑
	public void logic() {
		logic.logic();
	}

	// 判断碰撞(敌机与主角子弹碰撞)
	public boolean isCollsionWith(Bullet bullet) {
		return collsionWith.isCollsionWith(bullet);
	}
}
