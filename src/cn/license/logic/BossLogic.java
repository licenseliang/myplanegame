package cn.license.logic;

import cn.license.Bullet;
import cn.license.MySurfaceView;
import cn.license.draw.Plane;


public class BossLogic implements ILogic{

	private Plane plane;

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	//Boss���߼�
		public void logic(){
			//����ѭ������֡�ζ���
			plane.frameIndex++;
			if(plane.frameIndex >= 10){
				plane.frameIndex = 0;
			}
			//û�з���״̬
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
				//����״̬
				plane.speed -= 1;
				//��Boss����ʱ���������ӵ�
				if(plane.speed == 0){
					//���8�����ӵ�
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
					//�ָ�����״̬
					plane.isCrazy = false;
					plane.speed = 5;
				}
			}
		}
}