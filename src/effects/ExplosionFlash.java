
//theworldisquiethere

import java.awt.*;

public class ExplosionFlash extends Effect {

	private int i = 0;

	public ExplosionFlash() {};

	public ExplosionFlash(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

		i++;

		if (i > 0) done = true;

		return false;

	}

	public void draw(Graphics g) {

		g.setColor(Color.WHITE);

		g.fillRect(0, 0, Sorcery.length, Sorcery.length);

	}

}
