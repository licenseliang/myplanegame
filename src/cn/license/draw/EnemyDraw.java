package cn.license.draw;

import cn.license.Plane;
import android.graphics.Canvas;
import android.graphics.Paint;


public class EnemyDraw extends BaseAction implements IDraw {
	public EnemyDraw(Plane plane) {
		super(plane);
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
