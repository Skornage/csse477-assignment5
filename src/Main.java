public class Main {

	public static void main(String[] args) {
		PluggableFrame f = new PluggableFrame();
		f.add(new BubbleComponent());
		f.setVisible(true);
		System.out.println("Testing");
	}

}
