
//theworldisquiethere

import java.awt.*;

public abstract class Effect {

	protected Effect chain = null;
	protected boolean done = false;

	public Effect() {};

	public Effect(Effect container) {

		chain = container;

	}

	public boolean update() {

		if (done) {

			if (chain != null) Sorcery.magic.addEffect(chain);

			return true;

		}

		return false;

	}

	public abstract void draw(Graphics g);

}
