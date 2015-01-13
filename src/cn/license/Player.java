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
	//���ǵ�Ѫ����Ѫ��λͼ
	//Ĭ��3Ѫ
	public int playerHp = 30;
	public Bitmap bmpPlayerHp;
	//���ǵ������Լ�λͼ
	public int x,y;
	public Bitmap bmpPlayer;
	//z�����ƶ��ٶ�
	public int speed = 5;
	//�����ƶ���ʶ(�����½��ѽ��⣬�㶮��)
	public boolean isUp,isDown,isLeft,isRight;
	//��ײ�����޵�ʱ��
	//��ʱ��
	public int noCollisionCount = 0;
	//��Ϊ�޵�ʱ��
	public int noCollisionTime = 60;
	//�Ƿ���ײ�ı�ʶλ
	public boolean isCollision;
	
	//���ǵĹ��캯��
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
	 * ʵ�尴��
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
	 * ʵ�尴��̧��
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
	
	// �˵������¼���������Ҫ���ڴ���ť�¼�
		public void onTouchEvent(MotionEvent event) {
			// ��ȡ�û���ǰ����λ��
			int pointX = (int) event.getX();
			int pointY = (int) event.getY();
			// ���û��ǰ��¶������ƶ�����
			if (event.getAction() == MotionEvent.ACTION_DOWN
					|| event.getAction() == MotionEvent.ACTION_MOVE) {
				// �ж��û��Ƿ����˰�ť
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
				// ���û���̧����
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				// ̧���ж��Ƿ�����ť����ֹ�û��ƶ�����
				isUp = false;
				isDown = false;
				isLeft = false;
				isRight = false;
			}
		}
	
	
	/**
	 * ��������Ѫ��
	 */
	public void setPlayerHp(int hp){
		this.playerHp = hp;
	}
	
	/**
	 * ��ȡ����Ѫ��
	 */
	public int getPlayerHp(){
		return playerHp;
	}
	
	//�ж���ײ(������л�)
	public boolean isCollsionWith(Plane plane){
		return this.playerCWPlane.isCollsionWith(plane);
	}
}
