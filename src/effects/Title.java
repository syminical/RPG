
//theworldisquiethere

import java.awt.*;

public class Title extends Effect {

	private String R = "R", P = "P", G = "G", popin = "Roleplaying Precision Game";
	private int i = 0;
	private Font big = new Font("Monospaced", Font.BOLD, 120);
	private Font small = new Font("Monospaced", Font.PLAIN, 12);

	public Title() {};

	public Title(Effect container) {super(container);}

	public boolean update() {

		if (super.update()) return true;

		i++;

		if (i > 30) done = true;

		return false;

	}

	public void draw(Graphics g) {

		g.setColor(Color.WHITE);
		g.setFont(big);

		if (i % 2 == 0) {

			g.drawString(R, 90, 198);
			g.drawString(P, 165, 202);
			g.drawString(G, 240, 198);

		} else {

			g.drawString(R, 90, 202);
			g.drawString(P, 165, 198);
			g.drawString(G, 240, 202);

		}

		g.setFont(small);

		if (i >= 15) g.drawString(popin, 115, 220);

	}

}
