package cn.license.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import cn.license.Plane;

public class EmptyDraw extends BaseAction implements IDraw {
	public EmptyDraw(Plane plane) {
		super(plane);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void draw(Canvas canvas, Paint paint) {
		//do nothing
	}

}
