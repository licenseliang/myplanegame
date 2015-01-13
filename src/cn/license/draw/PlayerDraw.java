package cn.license.draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import cn.license.MySurfaceView;
import cn.license.Player;

public class PlayerDraw implements IDraw {
	private Player player;

	public PlayerDraw(Player player) {
		this.player = player;
	}

	@Override
	public void draw(Canvas canvas, Paint paint) {
		// 绘制主角
		// 当处于无敌时间时，让主角闪烁
		if (player.isCollision) {
			// 每2次游戏循环，绘制一次主角
			if (player.noCollisionCount % 2 == 0) {
				canvas.drawBitmap(player.bmpPlayer, player.x, player.y, paint);
			}
		} else {
			canvas.drawBitmap(player.bmpPlayer, player.x, player.y, paint);
		}
		// 绘制主角血量
		for (int i = 0; i < player.playerHp; i++) {
			canvas.drawBitmap(player.bmpPlayerHp, i * player.bmpPlayerHp.getWidth(),
					MySurfaceView.screenH - player.bmpPlayerHp.getHeight(), paint);
		}
	}

}
