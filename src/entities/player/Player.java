
//theworldisquiethere

import java.awt.*;

public class Player extends Entity {

	private int destiny, speed = 5;
	private double mp;
	public boolean shield = false;

	public Player(int container) {

		x = (Sorcery.length / 2) - 14;
		y = x;

		hp = 5;
		mp = 10.0;

		destiny = container;

	}

	public int mp() { return (int)mp; }

	public void influenceMp(double container) { mp += container; }

	public int destiny() { return destiny; }

	public void up() { this.influenceY(-speed); }

	public void right() { this.influenceX(speed); }

	public void down() { this.influenceY(speed); }

	public void left() { this.influenceX(-speed); }

	public void setX(int container) { this.x = container; }

	public void setY(int container) { this.y = container; }

	public void draw(Graphics g) {

		g.drawImage(Sorcery.imgs.get("img/entities/player/" + destiny + ".png"), this.x, this.y, null);

	}

}
