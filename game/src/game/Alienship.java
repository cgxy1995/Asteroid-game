package game;
import java.awt.*;
import java.util.Random;
public class Alienship extends Ship {
	public static final float SPEED = .1f;
	public Polygon top;
	public Polygon upper;
	public Polygon lower;
	public Rectangle boundbox;
	private long lastMoveTime;
	public long lastFireTime;
	public long nowTime;
	private float angle;
	private int cx;
    private int cy;
    private int life;
    private Polygon[] ship;
	public Alienship() {
		// TODO Auto-generated constructor stub
		dy=0;
		dx=SPEED;
		angle=0;
		ship = new Polygon[3];
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
	public Polygon[] createPolygon(){
		cx=(int)x;
    	cy=(int)y;
    	int pointsx1[]={cx-4,cx+4,cx+4,cx-4};
		int pointsy1[]={cy-14,cy-14,cy-10,cy-10};
		top=new Polygon(pointsx1, pointsy1,pointsx1.length);
		int pointsx2[]={cx-12,cx+12,cx+17,cx-17};
		int pointsy2[]={cy-10,cy-10,cy,cy};
		upper = new Polygon(pointsx2,pointsy2,4);
		int pointsx3[]={cx-17,cx+17,cx+12,cx-12};
		int pointsy3[]={cy,cy,cy+10,cy+10};
		lower = new Polygon(pointsx3,pointsy3,4);
		ship[0]=top;
		ship[1]=upper;
		ship[2]=lower;
		return ship;	
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
        boundbox = new Rectangle(cx-15,cy-12,30, 24);
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
