package cn.license.draw;

import cn.license.Plane;
import android.graphics.Canvas;
import android.graphics.Paint;

public class BossDraw implements IDraw {
	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
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
