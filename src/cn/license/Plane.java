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
	// ����
	private IDraw draw = new EmptyDraw(this);;
	// �߼�
	private ILogic logic = new EmptyLogic(this);
	//��ײ
	private ICollsionWith collsionWith = new EmptyCW(this);
	// �л��������ʶ
	public int type;
	// �л�ͼƬ��Դ
	public Bitmap bmpEnemy;
	// �л�����
	public int x, y;
	// �л�ÿ֡�ĸ߶�
	public int frameW, frameH;
	// �л���ǰ֡�±�
	public int frameIndex;
	// �л����ƶ��ٶ�
	public int speed;
	// �жϵл��Ƿ��Ѿ�����
	public boolean isDead;
	// boss���˶��켣
	// һ���¼���������Ļ�·��˶������ҷ����Χ�ӵ������Ƿ��̬��
	// ����״̬�£��ӵ���ֱ�����˶�
	public boolean isCrazy;
	// ������״̬��״̬ʱ����
	public int crazyTime = 200;
	// ������
	public int count;
	
	// Ѫ��
	public int hp;

	public Plane(){
		
	}
	
	/**
	 * ����BossѪ��
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	public void draw(Canvas canvas, Paint paint) {
		draw.draw(canvas, paint);
	}

	// �л��߼�
	public void logic() {
		logic.logic();
	}

	// �ж���ײ(�л��������ӵ���ײ)
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
