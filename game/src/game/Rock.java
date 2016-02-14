package game;
import java.awt.*;
import java.awt.geom.Point2D;
public class Rock extends Ship {
    private Point2D center;
    private int cx;
    private int cy;
    private int radius;
    public int size;
    public Polygon rock;
    public int shape;
    public Rectangle boundbox;
    public float speed;
	public Rock() {
		super();
		size=3;
		// TODO Auto-generated constructor stub
	}
	public void setSpeed(float speed){
		this.speed=speed;
	}
	public Point2D getCenter(){
		return center;
	}
	public int getradius(){
		return radius;
	}
	public int getSize(){
		return size;
	}
	public void setCenter(int x, int y){
		this.x=x;
		this.y=y;
	}
	public void setShape(int shape){
		this.shape=shape;
	}
	public void setSize(int size){
		this.size=size;
	}
    public Polygon createPolygon(){
    	cx=(int)x;
    	cy=(int)y;
    	if(shape==1 && size==3){
    		//int pointsx[]={cx,cx+13,cx+16,cx+30,cx+24,cx+19,cx-9,cx-8,cx-28,cx-20};
    		//int pointsy[]={cy-23,cy-22,cy-10,cy-7,cy+19,cy+14,cy+24,cy+19,cy+2,cy-20};
    		int pointsx[]={cx,cx+21,cx+26,cx+48,cx+38,cx+30,cx-14,cx-13,cx-45,cx-32};
    		int pointsy[]={cy-37,cy-35,cy-16,cy-11,cy+30,cy+22,cy+38,cy+30,cy+3,cy-32};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);   		
    	}
    	else if(shape==2 && size==3){
    		int pointsx[]={cx-2,cx+33,cx+50,cx+47,cx+32,cx+44,cx+7,cx-27,cx-49,cx-38,cx-6,cx-29};
    		int pointsy[]={cy-50,cy-38,cy-13,cy+18,cy+14,cy+38,cy+48,cy+44,cy+15,cy-22,cy+1,cy-39};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==3 && size==3){
    		int pointsx[]={cx+22,cx+42,cx+41,cx+20,cx+4,cx+5,cx-23,cx-43,cx-29,cx-45,cx-18};
    		int pointsy[]={cy-43,cy-8,cy+22,cy+49,cy+50,cy+10,cy+48,cy+14,cy+2,cy-5,cy-46};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==1 && size==2){
    		int pointsx[]={cx,cx+13,cx+16,cx+30,cx+24,cx+19,cx-9,cx-8,cx-28,cx-20};
    		int pointsy[]={cy-23,cy-22,cy-10,cy-7,cy+19,cy+14,cy+24,cy+19,cy+2,cy-20};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==2 && size==2){
    		int pointsx[]={cx-1,cx+21,cx+31,cx+29,cx+20,cx+28,cx+4,cx-17,cx-31,cx-24,cx-4,cx-18};
    		int pointsy[]={cy-31,cy-24,cy-8,cy+11,cy+9,cy+24,cy+30,cy+28,cy+9,cy-14,cy+1,cy-24};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==3 && size==2){
    		int pointsx[]={cx+14,cx+26,cx+26,cx+23,cx+3,cx+3,cx-14,cx-27,cx-18,cx-28,cx-11};
    		int pointsy[]={cy-27,cy-5,cy+14,cy+31,cy+31,cy+6,cy+30,cy+9,cy+1,cy-3,cy-29};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==1 && size==1){
    		int pointsx[]={cx,cx+4,cx+5,cx+10,cx+8,cx+6,cx-3,cx-3,cx-9,cx-7};
    		int pointsy[]={cy-8,cy-7,cy-3,cy-2,cy+6,cy+5,cy+8,cy+6,cy+1,cy-7};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==2 && size==1){
    		int pointsx[]={cx,cx+7,cx+10,cx+10,cx+7,cx+9,cx+1,cx-6,cx-10,cx-8,cx-1,cx-6};
    		int pointsy[]={cy-10,cy-8,cy-3,cy+4,cy+3,cy+8,cy+10,cy+9,cy+3,cy-5,cy,cy-8};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	else if(shape==3 && size==1){
    		int pointsx[]={cx+5,cx+9,cx+9,cx+8,cx+1,cx+1,cx-5,cx-9,cx-6,cx-9,cx-4};
    		int pointsy[]={cy-9,cy-2,cy+6,cy+10,cy+10,cy+2,cy+10,cy+3,cy,cy-1,cy-10};
    		rock = new Polygon(pointsx,pointsy,pointsx.length);
    	}
    	boundbox=rock.getBounds();
		return rock;
    }
    public void update(long elapsedTime) {
        x += dx * elapsedTime;
        y += dy * elapsedTime;
        if(boundbox.y>600){
        	y=y-600-boundbox.height;
        }
        if(boundbox.y-boundbox.height<0){
        	y=y+600+boundbox.height;
        }
        if(boundbox.x+boundbox.width>800){
        	x=x-800-boundbox.width;
        }
        if(boundbox.x<0){
        	x=x+800+boundbox.width;
        }
        
    }
}
