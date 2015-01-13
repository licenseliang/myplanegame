package cn.license.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import cn.license.Bullet;
import cn.license.MySurfaceView;
import cn.license.collsionwith.ICollsionWith;
import cn.license.logic.ILogic;

public class Plane {
	// ����
	private IDraw draw;
	// �߼�
	private ILogic logic;
	//��ײ
	private ICollsionWith collsionWith;
	// �л��������ʶ
	public int type;
	// ��Ӭ
	public static final int TYPE_FLY = 1;
	// Ѽ��(���������˶�)
	public static final int TYPE_DUCKL = 2;
	// Ѽ��(���������˶�)
	public static final int TYPE_DUCKR = 3;
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

	// Boss�Ĺ��캯��
	public Plane(Bitmap bmpBoss) {
		this.bmpEnemy = bmpBoss;
		frameW = bmpBoss.getWidth() / 10;
		frameH = bmpBoss.getHeight();
		// Boss��x�������
		x = MySurfaceView.screenW / 2 - frameW / 2;
		y = 0;
	}

	// �л��Ĺ��캯��
	public Plane(Bitmap bmpEnemy, int enemyType, int x, int y) {
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
}
