package cn.license;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import cn.license.collsionwith.ICollsionWithPlane;
import cn.license.collsionwith.PlayerCW;
import cn.license.collsionwith.PlayerCWPlane;
import cn.license.draw.PlayerDraw;
import cn.license.logic.PlayerLogic;

public class Player extends Plane{
	private ICollsionWithPlane playerCWPlane;
	//主角的血量和血量位图
	//默认3血
	public int playerHp = 30;
	public Bitmap bmpPlayerHp;
	//主角的坐标以及位图
	public int x,y;
	public Bitmap bmpPlayer;
	//z主角移动速度
	public int speed = 5;
	//主角移动标识(基础章节已讲解，你懂得)
	public boolean isUp,isDown,isLeft,isRight;
	//碰撞后处于无敌时间
	//计时器
	public int noCollisionCount = 0;
	//因为无敌时间
	public int noCollisionTime = 60;
	//是否碰撞的标识位
	public boolean isCollision;
	
	//主角的构造函数
	public Player(Bitmap bmpPlayer,Bitmap bmpPlayerHp){
		this.bmpPlayer = bmpPlayer;
		this.bmpPlayerHp = bmpPlayerHp;
		x = MySurfaceView.screenW /2 - bmpPlayer.getWidth()/2;
		y = MySurfaceView.screenH - bmpPlayer.getHeight();
		this.setDraw(new PlayerDraw(this));
		this.setLogic(new PlayerLogic(this));
		this.setCollsionWith(new PlayerCW(this));
		this.playerCWPlane = new PlayerCWPlane(this);
	}
	
	
	/**
	 * 实体按键
	 */
	public void onKeyDown(int keyCode,KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_DPAD_UP){
			isUp = true;
		}
		if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
			isDown = true;
		}
		if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT){
			isLeft = true;
		}
		if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT){
			isRight = true;
		}
	}
	
	/**
	 * 实体按键抬起
	 */
	public void onKeyUp(int keyCode,KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_DPAD_UP){
			isUp = false;
		}
		if(keyCode == KeyEvent.KEYCODE_DPAD_DOWN){
			isDown = false;
		}
		if(keyCode == KeyEvent.KEYCODE_DPAD_LEFT){
			isLeft = false;
		}
		if(keyCode == KeyEvent.KEYCODE_DPAD_RIGHT){
			isRight = false;
		}
	}
	
	// 菜单触屏事件函数，主要用于处理按钮事件
		public void onTouchEvent(MotionEvent event) {
			// 获取用户当前触屏位置
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			// 当用户是按下动作或移动动作
			if (event.getAction() == MotionEvent.ACTION_DOWN
					|| event.getAction() == MotionEvent.ACTION_MOVE) {
				// 判定用户是否点击了按钮
				if (pointX > x) {
					isRight = true;
				} else {
					isLeft = true;
				}
				if (pointY > y) {
					isDown = true;
				} else {
					isUp = true;
				}
				// 当用户是抬起动作
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				// 抬起判断是否点击按钮，防止用户移动到别处
				isUp = false;
				isDown = false;
				isLeft = false;
				isRight = false;
			}
		}
	
	
	/**
	 * 设置主角血量
	 */
	public void setPlayerHp(int hp){
		this.playerHp = hp;
	}
	
	/**
	 * 获取主角血量
	 */
	public int getPlayerHp(){
		return playerHp;
	}
	
	//判断碰撞(主角与敌机)
	public boolean isCollsionWith(Plane plane){
		return this.playerCWPlane.isCollsionWith(plane);
	}
}
