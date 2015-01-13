package cn.license.logic;

import cn.license.Bullet;
import cn.license.MySurfaceView;
import cn.license.draw.Plane;


public class BossLogic implements ILogic{

	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	//Boss的逻辑
		public void logic(){
			//不断循环播放帧形动画
			plane.frameIndex++;
			if(plane.frameIndex >= 10){
				plane.frameIndex = 0;
			}
			//没有疯狂的状态
			if(!plane.isCrazy){
				plane.x += plane.speed;
				if(plane.x+plane.frameW >= MySurfaceView.screenW){
					plane.speed = -plane.speed;
				}else if(plane.x <= 0){
					plane.speed = -plane.speed;
				}
				plane.count ++;
				if(plane.count % plane.crazyTime == 0){
					plane.isCrazy = true;
					plane.speed = 24;
				}
			}else{
				//疯狂的状态
				plane.speed -= 1;
				//当Boss返回时创建大量子弹
				if(plane.speed == 0){
					//添加8方向子弹
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet,plane.x+40,plane.y+10,Bullet.BULLET_BOSS,Bullet.DIR_UP));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet,plane.x+40,plane.y+10,Bullet.BULLET_BOSS,Bullet.DIR_DOWN));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet, plane.x+40, plane.y+10, Bullet.BULLET_BOSS, Bullet.DIR_LEFT));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet, plane.x+40, plane.y+10, Bullet.BULLET_BOSS, Bullet.DIR_RIGHT));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet, plane.x+40, plane.y+10, Bullet.BULLET_BOSS, Bullet.DIR_UP_LEFT));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet, plane.x+40, plane.y+10, Bullet.BULLET_BOSS, Bullet.DIR_UP_RIGHT));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet, plane.x+40, plane.y+10, Bullet.BULLET_BOSS, Bullet.DIR_DOWN_LEFT));
					MySurfaceView.vcBulletBoss.add(new Bullet(MySurfaceView.bmpBossBullet, plane.x+40, plane.y+10, Bullet.BULLET_BOSS, Bullet.DIR_DOWN_RIGHT));
				}
				plane.y += plane.speed;
				if(plane.y <= 0){
					//恢复正常状态
					plane.isCrazy = false;
					plane.speed = 5;
				}
			}
		}
}