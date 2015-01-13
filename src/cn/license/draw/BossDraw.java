package cn.license.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import cn.license.Plane;

public class BossDraw extends BaseAction implements IDraw {
	public BossDraw(Plane plane) {
		super(plane);
	}

	@Override
	public void draw(Canvas canvas, Paint paint) {
		canvas.save();
		canvas.clipRect(plane.x, plane.y, plane.x + plane.frameW, plane.y
				+ plane.frameH);
		canvas.drawBitmap(plane.bmpEnemy, plane.x - plane.frameIndex
				* plane.frameW, plane.y, paint);
		canvas.restore();
	}

}
