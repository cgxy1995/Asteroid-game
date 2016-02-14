package game;

import java.awt.Polygon;

public class PlayerShip extends Ship {
	private float angle;
	public float width;
	public float height;
	public float adj;
	public float theta1;
	public float p1x=300;
	public float p1y=300;
	public float p2x=300;
	public float p2y=300;
	public float p3x=300;
	public float p3y=300;
	public static final float ACCL = 0.0025f;
	public static final float SPEED = .325f;
	public float speed;
	public Polygon ship;
	public PlayerShip() {
		super();
		angle=0;
		width=15;
		height=25;
		adj=26.1f;
		theta1=0.2914568f;
		speed=0;
		// TODO Auto-generated constructor stub
	}
	public void setPoints(int p1x,int p1y, int p2x, int p2y, int p3x, int p3y){
		this.p1x=p1x;
		this.p1y=p1y;
		this.p2x=p2x;
		this.p2y=p2y;
		this.p3x=p3x;
		this.p3y=p3y;
	}
	public Polygon createPolygon(){
    	int verx2=Math.round(x-(float)Math.sin(angle)*height/2);
		int very2=Math.round(y-(float)Math.cos(angle)*height/2);
		int bx2=verx2+Math.round((float)Math.sin(angle)*20);
		int by2=very2+Math.round((float)Math.cos(angle)*20);
		int lx2=verx2-Math.round(adj*(float)Math.sin(theta1-angle));
		int rx2=verx2+Math.round(adj*(float)Math.sin(theta1+angle));
		int ly2=very2+Math.round(adj*(float)Math.cos(theta1-angle));
		int ry2=very2+Math.round(adj*(float)Math.cos(theta1+angle));
		setPoints(lx2, ly2, verx2, very2, rx2, ry2);
		int x2[] = {lx2,
				verx2,
				rx2,bx2};
		int y2[] = {ly2,
				very2,
				ry2,by2};
		ship=new Polygon(x2,y2,4);
    	return ship;
	}
	public void update(long elapsedTime) {
        x += dx * elapsedTime;
        y += dy * elapsedTime;
        if(p1x<0 && p2x<0 && p3x<0)
        	x+=800;
        else if(p1x>800 && p2x>800 && p3x>800)
        	x-=800;
        if(p1y<0 && p2y<0 && p3y<0)
        	y+=600;
        else if(p1y>600 && p2y>600 && p3y>600)
        	y-=600;
    }
	public float getAngle(){
		return angle;
	}
	public void setAngle(float angle){
		this.angle=angle;
	}
	
	
}