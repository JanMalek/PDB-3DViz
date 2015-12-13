package hlavni;

public class Projekce {
	private float a = (float) (0.25*Math.PI);
	private float b = (float) (0.25*Math.PI);
	private float c = 0;
	private float sa = (float) Math.sin(a);
	private float ca = (float) Math.cos(a);
	private float sb = (float) Math.sin(b);
	private float cb = (float) Math.cos(b);
	private float sc = (float) Math.sin(c);
	private float cc = (float) Math.cos(c);
//	private float x = d*ca
//	private float y = d*sa
//	private float z = 
	private float d = 100;
	
	private int zvetseni = 1000;
	
	public Coor2D zobraz(Coor c) throws Exception {
		return projekce(afinniPosun(otocYpost(otocX(otocZ(c)))));
	}
	
	private Coor2D projekce(Coor c) throws Exception {
		if (c.z >= d) throw new Exception();
		float tmp = d/(d-c.z);
		return new Coor2D(c.x*tmp*zvetseni/d, c.y*tmp*zvetseni/d);
	}

	private Coor otocX(Coor c) {
		return new Coor(c.x, c.y*cb+c.z*sb, c.y*sb-c.z*cb);
	}

	private Coor otocZ(Coor c) {
		return new Coor(c.x*ca-c.y*sa, c.x*sa+c.y*ca, c.z);
	}
	
	private Coor otocYpost(Coor c) {
		return new Coor(c.x*cc-c.z*sc, c.y, c.x*sc+c.z*cc);
	}
	
	public float posun = (float) 0.01;
	public boolean smer = true;
	
	public Coor afinniPosun(Coor c) {
		float pm = (smer) ? 1 : -1;
		return new Coor(c.x+pm*c.z*posun, c.y, c.z);
	}
	
	public void setA(double alpha) {
		a = (float) alpha;
		sa = (float) Math.sin(alpha);
		ca = (float) Math.cos(alpha);
	}
	
	public void setB(double alpha) {
		b = (float) alpha;
		sb = (float) Math.sin(alpha);
		cb = (float) Math.cos(alpha);
	}
	
	public void setC(double alpha) {
		c = (float) alpha;
		sc = (float) Math.sin(alpha);
		cc = (float) Math.cos(alpha);
	}
	
	public void setD(float d) {
		this.d = d;
	}
	
	public float getD() {
		return d;
	}
	
	public float getA() {
		return a;
	}
	
	public float getB() {
		return b;
	}
	
	public float getC() {
		return c;
	}
}
