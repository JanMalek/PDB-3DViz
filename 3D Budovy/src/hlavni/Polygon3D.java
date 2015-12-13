package hlavni;


public class Polygon3D {
	public final Coor[] coorField;
	public final Coor center;
	
	public Polygon3D(Coor[] coorField) {
		this.coorField = coorField;
		center = prum(coorField);
	}
	
	public Coor prum(Coor[] coorField2) {
		float sumX = 0;
		float sumY = 0;
		float sumZ = 0;
		for (int i = 0; i < coorField2.length; i++) {
			sumX += coorField2[i].x;
			sumY += coorField2[i].y;
			sumZ += coorField2[i].z;
		}
		return new Coor(sumX/coorField2.length, sumY/coorField2.length, sumZ/coorField2.length);
	}

	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < coorField.length - 1; i++) {
			string += coorField[i] + "  ";
		}
			string += coorField[coorField.length - 1]+"  ";
		return string;
	}
}
