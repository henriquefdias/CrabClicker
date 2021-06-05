import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	public static int WIDTH = 480;
	public static int HEIGHT = 480;
	
	public Game() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	public void update() {
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(255, 229, 102));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.setTitle("Crab Clicker");
		frame.add(game);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		new Thread(game).start();
	}

	@Override
	public void run() {
		double fps = 60.0;
		while(true) {
			update();
			render();
			try {
				Thread.sleep((int)(1000/fps));
			} catch (InterruptedException e) {}
		}
	}
	
}
