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
		// ��������
		// �������޵�ʱ��ʱ����������˸
		if (player.isCollision) {
			// ÿ2����Ϸѭ��������һ������
			if (player.noCollisionCount % 2 == 0) {
				canvas.drawBitmap(player.bmpPlayer, player.x, player.y, paint);
			}
		} else {
			canvas.drawBitmap(player.bmpPlayer, player.x, player.y, paint);
		}
		// ��������Ѫ��
		for (int i = 0; i < player.playerHp; i++) {
			canvas.drawBitmap(player.bmpPlayerHp, i * player.bmpPlayerHp.getWidth(),
					MySurfaceView.screenH - player.bmpPlayerHp.getHeight(), paint);
		}
	}

}
