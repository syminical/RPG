
//theworldisquiethere

import java.awt.*;

public class Enemy extends Entity {

	private boolean dead = false;

	public Enemy() {

		hp = 3;
		x = (int)(Math.random() * 300) + 30;
		y = (int)(Math.random() * 275) + 30;

	}

	public void draw(Graphics g) {

		if (dead) return;

		g.setColor(Color.WHITE);

		g.fillRect(x, y, 25, 25);

	}

	public void collision(int container, int container2, int container3, int container4, int container5) {

		if (x > container && x < container2 && y > container3 && y < container4)

			hp -= container5;

		if ( hp <= 0 ) dead = true;

	}

}
