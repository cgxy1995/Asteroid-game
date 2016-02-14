package game;

import java.awt.Polygon;

public class Gravobject extends Ship {
	public static final int RADIUS = 10;
	public static final float GRAVITY = .02f;
	public Gravobject() {
		// TODO Auto-generated constructor stub
		x=400;
		y=300;
	}
	public boolean ifOut(int x,int y){
		if(Math.sqrt(Math.pow((x-400),2)+Math.pow((y-300),2))>RADIUS){
			return true;
		}
		return false;
	}
	public float calcAngle(float x, float y){
		if(y>this.y)
			return (float) (Math.atan((x-400)/(y-300))+Math.PI);
		else
			return (float) (Math.atan((x-400)/(y-300)));
	}
}
