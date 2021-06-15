import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crab {

	public double x, y, dx, dy;
	public double spd = 4;

	public static BufferedImage[] crabSprite;
	
	public int curFrames = 0, maxFrames = 10, maxAnim = 2, curAnim = 0;

	public Crab(double x, double y) {
		this.x = x;
		this.y = y;
		double radius = Math.atan2((Game.HEIGHT / 2 - 20) - y, (Game.WIDTH/2 - 20) - x);
		this.dx = Math.cos(radius);
		this.dy = Math.sin(radius);
		crabSprite = new BufferedImage[2];
		crabSprite[0] = Game.spritesheet.getSprite(0, 0);
		crabSprite[1] = Game.spritesheet.getSprite(16, 0);
		// TODO: C�lculo caminho do caranguejo
	}

	public void update() {
		x += (dx * spd);
		y += (dy * spd);
		if(new Rectangle((int)x,(int) y, 40, 40).intersects(Game.maskHole)) {
			Game.crabs.remove(this);
			return;
		}
		curFrames++;
		if(curFrames == maxFrames) {
			curAnim++;
			if(curAnim == maxAnim) {
				curAnim = 0;
			}
			curFrames = 0;
		}
	}

	public void render(Graphics g) {
		g.drawImage(crabSprite[curAnim], (int) x, (int) y, 40, 40, null);
		/*
		 * g.setColor(Color.red); g.fillRect((int) x, (int) y, 40, 40);
		 */
	}

}
