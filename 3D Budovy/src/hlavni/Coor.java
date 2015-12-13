package hlavni;

public class Coor {
	public final float x;
	public final float y;
	public final float z;
	
	public Coor(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public String toString() {
		return (int) x+","+(int) y+","+(int) z;
	}
}
