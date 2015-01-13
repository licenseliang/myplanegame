package cn.license.draw;

import cn.license.Plane;
import android.graphics.Canvas;
import android.graphics.Paint;

public interface IDraw {
	public void setPlane(Plane plane);
	public void draw(Canvas canvas, Paint paint);
}
