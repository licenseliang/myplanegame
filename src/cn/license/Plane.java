package cn.license;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import cn.license.collsionwith.EmptyCW;
import cn.license.collsionwith.ICollsionWith;
import cn.license.draw.EmptyDraw;
import cn.license.draw.IDraw;
import cn.license.logic.EmptyLogic;
import cn.license.logic.ILogic;

public class Plane {
	// 绘制
	private IDraw draw = new EmptyDraw(this);;
	// 逻辑
	private ILogic logic = new EmptyLogic(this);
	//碰撞
	private ICollsionWith collsionWith = new EmptyCW(this);
	// 敌机的种类标识
	public int type;
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
	
	// 血量
	public int hp;

	public Plane(){
		
	}
	
	/**
	 * 设置Boss血量
	 */
	public void setHp(int hp) {
		this.hp = hp;
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



	public void setDraw(IDraw draw) {
		this.draw = draw;
	}



	public void setLogic(ILogic logic) {
		this.logic = logic;
	}



	public void setCollsionWith(ICollsionWith collsionWith) {
		this.collsionWith = collsionWith;
	}
	
	
}
