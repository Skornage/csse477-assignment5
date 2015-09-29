import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class Bubble {
	private Color color;
	private int[] vector;
	private Ellipse2D.Double circle;

	public Bubble(int x, int y) {
		this.color = Color.BLACK;
		this.vector = new int[] { 5, 3 };
		this.circle = new Ellipse2D.Double(x, y, 30, 30);

	}

	public void updatePosition() {
		this.circle.x += this.vector[0];
		this.circle.y += this.vector[1];
	}

	private void bounceOffWall() {
		int temp = this.vector[0];
		this.vector[0] = this.vector[1];
		this.vector[1] = temp;
	}

	protected void bounceOffSideWall() {
		bounceOffWall();
		this.vector[0] *= -1;
	}

	protected void bounceOffTopBottomWall() {
		bounceOffWall();
		this.vector[1] *= -1;
	}

	public Color getColor() {
		return this.color;
	}

	public Ellipse2D.Double getShape() {
		return this.circle;
	}

	public int getMinX() {
		return (int) this.circle.getMinX();
	}

	public int getMinY() {
		return (int) this.circle.getMinY();
	}

	public int getMaxX() {
		return (int) this.circle.getMaxX();
	}

	public int getMaxY() {
		return (int) this.circle.getMaxY();
	}

}
