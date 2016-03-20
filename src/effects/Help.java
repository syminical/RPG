
//theworldisquiethere

import java.awt.*;

public class Help extends Effect {

	private Font manaFont = new Font("Monospaced", Font.PLAIN, 13);
	private int holder = 0, i = 0;
	private boolean check = false;

	public Help() {}

	public Help(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

		i++;

		if (i > 120) done = true;

		return false;

	}

	public void draw(Graphics g) {

		g.setColor(Color.WHITE);

		g.drawString("W, A, S, D to move", 70, 70);
		g.drawString("F is the class ability", 169, 180);
		g.drawString("aim with mouse", 80, 260);

	}		

}
