package cn.license.draw;

import android.graphics.Canvas;
import android.graphics.Paint;


public class EnemyDraw implements IDraw {
	private Plane plane;
	public void setPlane(Plane plane){
		this.plane = plane;
	}

	/**
	 * »æÖÆ
	 */
	@Override
	public void draw(Canvas canvas, Paint paint) {
		canvas.save();
		canvas.clipRect(plane.x, plane.y, plane.x + plane.frameW, plane.y + plane.frameH);
		canvas.drawBitmap(plane.bmpEnemy, plane.x - plane.frameIndex * plane.frameW, plane.y, paint);
		canvas.restore();
	}

}
