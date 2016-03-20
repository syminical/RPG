
//theworldisquiethere

import java.awt.*;

public class Shot extends Effect {

	private Player player = Sorcery.magic.player;
	private double dX = Sorcery.magic.mX - player.getX(), dY = Sorcery.magic.mY - player.getY(), mag = Math.sqrt(dX*dX + dY*dY);
	private int x = player.getX() + 14, y = player.getY() + 14, vel = 5;

	public Shot() {}

	public Shot(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

		Sorcery.magic.dungeon.collision(x, x + 4, y, y + 4, 1);

		x += (int)(dX / mag * vel);
		y += (int)(dY / mag * vel);

		if ((x < 0 || x > 400) && (y < 0 || y > 400)) done = true;

		return false;

	}

	public void draw(Graphics g) {

		g.setColor(Color.GREEN);

		g.fillOval(x, y, 4, 4);

	}

}
