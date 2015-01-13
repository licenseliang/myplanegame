package cn.license;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Boom {
	//��ըЧ����Դͼ
	private Bitmap bmpBoom;
	//��ըЧ����λ������
	private int boomX,boomY;
	//��ը�������ŵ�ǰ��֡�±�
	private int currentFrameIndex;
	//��ըЧ������֡��
	private int totalFrame;
	//ÿ֡�ĸ߶�
	private int frameW,frameH;
	//�Ƿ񲥷���ϣ��Ż�����
	public boolean playEnd;
	
	//��ըЧ���Ĺ��캯��
	public Boom(Bitmap bmpBoom,int x,int y,int totalFrame){
		this.bmpBoom = bmpBoom;
		this.boomX = x;
		this.boomY = y;
		this.totalFrame = totalFrame;
		frameW = bmpBoom.getWidth() / totalFrame;
		frameH = bmpBoom.getHeight();
	}
	
	//��ըЧ������
	public void draw(Canvas canvas,Paint paint){
		canvas.save();
		canvas.clipRect(boomX,boomY,boomX+frameW,boomY+frameH);
		canvas.drawBitmap(bmpBoom, boomX - currentFrameIndex * frameW, boomY,paint);
		canvas.restore();
	}
	
	//��ըЧ�����߼�
	public void logic(){
		if(currentFrameIndex < totalFrame){
			currentFrameIndex ++;
		}else{
			playEnd = true;
		}
	}
}
