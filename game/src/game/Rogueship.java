package game;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Random;
import java.lang.Object;
public class Rogueship extends Ship {
	public static final float SPEED = .1f;
	public Polygon top;
	public Rectangle boundbox;
	private long lastMoveTime;
	public long lastFireTime;
	public long nowTime;
	private float angle;
	private int cx;
    private int cy;
    private int life;
	public Rogueship() {
		// TODO Auto-generated constructor stub
		dy=0;
		dx=SPEED;
		angle=0;
		lastMoveTime=0;
		nowTime=0;
		life=3;
	}
	public void setCenter(int x, int y){
		this.x=x;
		this.y=y;
	}
	public boolean getHit(){
		life--;
		return (life==0);
	}
	public void changeDirection(){
		Random generator = new Random();
		float newangle = (float) (generator.nextFloat()*2*Math.PI);
		dx=(float) (Math.sin(newangle)*SPEED);
		dy=(float) (Math.cos(newangle)*SPEED);
	}
	public Polygon createPolygon(){
		cx=(int)x;
    	cy=(int)y;
    	int pointsx1[]={cx-4,cx+4,cx+4,cx-4};
		int pointsy1[]={cy-12,cy-12,cy-7,cy-7};
		top = new Polygon(pointsx1,pointsy1,4);
		return top;
	}
	public void update(long elapsedTime) {
		Random generator = new Random();
		cx=(int)x;
    	cy=(int)y;
        x += dx * elapsedTime;
        y += dy * elapsedTime;
        nowTime+=elapsedTime;
        int changeTime = generator.nextInt(2000)+5000;
        if(nowTime-lastMoveTime>changeTime){
        	changeDirection();
        	lastMoveTime=nowTime;
        }
        boundbox = new Rectangle(cx-20,cy-7,40, 14);
        if(boundbox.y>600){
        	y=y-600-boundbox.height;
        }
        else if(boundbox.y-boundbox.height<0){
        	y=y+600+boundbox.height;
        }
        else if(boundbox.x+boundbox.width>800){
        	x=x-800-boundbox.width;
        }
        else if(boundbox.x<0){
        	x=x+800+boundbox.width;
        }        
    }

}
