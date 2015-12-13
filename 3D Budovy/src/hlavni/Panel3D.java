package hlavni;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel3D extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean anaglyph = false;

	//////////////////////////////////// VYKRESLENI ////////////////////////////////////
	public Panel3D(ArrayList<ArrayList<Polygon3D>> budovy) {
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		Polygony3D = prevedNaPolygony3D(budovy);
		instance = this;
	}
	
	public static Panel3D instance = null;
	
	private ArrayList<Polygon3D> prevedNaPolygony3D(
			ArrayList<ArrayList<Polygon3D>> budovy) {
		ArrayList<Polygon3D> Polygony3D = new ArrayList<Polygon3D>();
		for (int i = 0; i < budovy.size(); i++) {
			for (int j = 0; j < budovy.get(i).size(); j++) {
				Polygony3D.add(budovy.get(i).get(j));
			}
		}
		return Polygony3D;
	}

	private final ArrayList<Polygon3D> Polygony3D;
	static Projekce proj = new Projekce();
		
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	int h = dim.height/2;
	int w = dim.width/2;
	
	Graphics2D g2 = null;
	
	public void paintComponent(Graphics g) {
		g2 = (Graphics2D) g;
		super.paintComponent(g);
		g2.translate(w, h);
		g2.setStroke(new BasicStroke((float) 2.0));
		draw();
	}
	
	private void draw() {
		if (anaglyph) {
			proj.smer = true;
			g2.setColor(Color.cyan);
			for (Polygon3D polygon3d : Polygony3D) {
				drawPolygon(polygon3d);
			}
			proj.smer = false;
			g2.setColor(Color.red);
			for (Polygon3D polygon3d : Polygony3D) {
				drawPolygon(polygon3d);
			}
		} else {
			proj.smer = true;
			g2.setColor(Color.black);
			for (Polygon3D polygon3d : Polygony3D) {
				drawPolygon(polygon3d);
			}
		}
	}
	
	private void drawPolygon(Polygon3D polygon3D) {
		Coor2D[] coor2D = PolygonTo2DField(polygon3D);
		int[] xPoints = new int[coor2D.length-1];
		int[] yPoints = new int[coor2D.length-1];
		for (int i = 0; i < coor2D.length-1; i++) {
			xPoints[i] = (int)coor2D[i].x;
			yPoints[i] = (int)coor2D[i].y;
		}
//		g2.setColor(new Color(170,222,140));
//		g2.fillPolygon(xPoints, yPoints, xPoints.length);
//		g2.setColor(Color.BLACK);
		for (int i = 0; i < coor2D.length-1; i++) {
			drawLine(coor2D[i], coor2D[i+1]);
		}
	}

	private void drawLine(Coor c1, Coor c2) {
		try {
			Coor2D c11 = proj.zobraz(c1);
			Coor2D c12 = proj.zobraz(c2);
			g2.drawLine((int) c11.x, (int) c11.y, (int) c12.x, (int) c12.y);
		} catch (Exception e) {}
	}
	
	private void drawLine(Coor2D c1, Coor2D c2) {
		try {
			g2.drawLine((int) c1.x, (int) c1.y, (int) c2.x, (int) c2.y);
		} catch (Exception e) {}
	}	
	
/// POSUN ///
	Point p1;
	
	@Override
	public void mouseDragged(MouseEvent ev) {
		Point p2 = ev.getPoint();
		switch (ev.getModifiers()) {
		case 4:
			proj.setC(proj.getC()+(float)(p1.x-p2.x)/100);
			proj.setB(proj.getB()+(float)(p1.y-p2.y)/100);
			p1 = p2;
			break;
		case 16:
			proj.setA(proj.getA()+(float)(p1.x-p2.x)/100);
			proj.setB(proj.getB()+(float)(p1.y-p2.y)/100);
			p1 = p2;
			break;
		default:
			break;
		}
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		p1 = ev.getPoint();
	}
/// PRIBLIZENI ///
	
	/**
	 * zmena meritka funkce
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent ev) {
		if (ev.isShiftDown()) proj.posun += (Math.atan(10*proj.posun)*ev.getWheelRotation()/50);
		else if (proj.getD()>=1) proj.setD(proj.getD()+(float)ev.getWheelRotation());
		else proj.setD(1);
		repaint();
	}

	public static Coor2D[] PolygonTo2DField(Polygon3D polygon3D) {
		Coor2D[] coor2D = new Coor2D[polygon3D.coorField.length];
		try {
			for (int i = 0; i < coor2D.length; i++) {
				coor2D[i] = proj.zobraz(polygon3D.coorField[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coor2D;
	}
	
//////////////////////////////////// NEVYUZITE METODY ////////////////////////////////////
	
	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}
}
