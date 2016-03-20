
//theworldisquiethere

import java.awt.*;

public class CircleExplosion extends Effect {

	private int x = Sorcery.length / 2 - 1, r = 1;

	public CircleExplosion() {};

	public CircleExplosion(Effect container) {

		super(container);

	}

	public boolean update() {

		if (super.update()) return true;

		if (r < 40) {r += 6; x = Sorcery.length / 2 - r / 2;}

		else done = true;

		return false;

	}

	public void draw(Graphics g) {

		g.setColor(Color.WHITE);

		g.fillOval(x, x, r, r);

	};

}
