package game;
import java.awt.*;
public class Bullet extends Ship {
	public static final float SPEED = .5f;
	public float angle;
	public static final int RADIUS = 2;
	private float distance;
	public int owner;
	private int bulletRange;
	public Bullet() {
		// TODO Auto-generated constructor stub
	}
	public void setOwner(int owner){
		this.owner=owner;
	}
	public void setAngle(float angle){
		this.angle=angle;
		distance=0;
		bulletRange=1000;
	}
	public void update(long elapsedTime) {
        x += dx * elapsedTime;
        y += dy * elapsedTime;
        distance+=SPEED*elapsedTime;
        if(y+RADIUS>600){
        	y=y-600-RADIUS*2;
        }
        else if(y-RADIUS<0){
        	y=y+600+RADIUS*2;
        }
        else if(x+RADIUS>800){
        	x=x-800-RADIUS*2;
        }
        else if(x-RADIUS<0){
        	x=x+800+RADIUS*2;
        }
	}
	public boolean ifOut(){
		if(distance>bulletRange){
			return true;
		}
		return false;
	}
	public void setBulletRange(int range){
		this.bulletRange=range;
	}
}
