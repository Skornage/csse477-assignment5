import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Bubble {
	private Color color;
	private int[] vector;
	private Ellipse2D.Double circle;

	public Bubble(int x, int y) {

		Random generator = new Random();
		int radiusSelector = generator.nextInt(5);
		int radius = 45 + 7 * radiusSelector;

		int dx = generator.nextInt(5) + 1;
		int dy = generator.nextInt(5) + 1;

		if (generator.nextBoolean()) {
			dx *= -1;
		}
		if (generator.nextBoolean()) {
			dy *= -1;
		}
		int dg = generator.nextInt(106);
		int db = generator.nextInt(106);
		this.color = new Color(0, 150 + dg, 150 + db);

		this.vector = new int[] { dx, dy };
		this.circle = new Ellipse2D.Double(x, y, radius, radius);

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
