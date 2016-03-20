
//theworldisquiethere

import java.awt.*;

public class NextStage extends Effect {

	public NextStage() {}

	public NextStage(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

			Sorcery.magic.nextStage();

			done = true;

		return false;

	}

	public void draw(Graphics g) {

	}

}
