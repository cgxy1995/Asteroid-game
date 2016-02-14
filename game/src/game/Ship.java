package game;
import java.awt.Image;
public class Ship {
	protected float x;
	protected float y;
	protected float dx;
	protected float dy;
    
    public static final float GRAVITY = .002f;
    public Ship(){
    }
    
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getVelocityX() {
        return dx;
    }
    public float getVelocityY() {
        return dy;
    }

    public void setVelocityX(float dx) {
        this.dx = dx;
    }

    public void setVelocityY(float dy) {
        this.dy = dy;
    }
}
