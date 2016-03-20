
//theworldisquiethere

import java.awt.*;

public class Branding extends Effect {

	private String shamelessAdvertising = "Alex Manaila";
	private Font manaFont = new Font("Monospaced", Font.BOLD, 32);
	private int i = 0, holder;
	private boolean badCoding = false;

	public Branding() {};

	public Branding(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

		if (i == 8) badCoding = true;

		if (!badCoding) i++;

		else i--;

		if (i < 0) { done = true; Sorcery.magic.intro = true; }

		return false;

	}

	public void draw(Graphics g) { 

		holder = ((i >= 0)? (i * 25) : 0);

		g.setFont(manaFont);
		g.setColor(new Color(holder, holder, holder));

		g.drawString(shamelessAdvertising, 90, 200);

	}

}
