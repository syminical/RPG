
//theworldisquiethere

import java.awt.*;

public class Selection extends Effect {

	private float opacity = 0;
	private String path = "img/menu/", help = "choose a path";
	private int i = 0, holder;
	private Font destinyFont = new Font("Monospaced", Font.BOLD, 20);
	private Font spoilerFont = new Font("Monospaced", Font.PLAIN, 12);
	private boolean selected = false;

	public Selection() {}

	public Selection(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

		if (!selected && opacity < 1) opacity += .125;

		if (selected && opacity > 0) opacity -= .125;

		if (Sorcery.magic.selection) {selected = true; holder = 255; }

		if (selected && opacity == 0) done = true;

		if (opacity == 1) i++;

		return false;

	}

	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D)g;
		
		if (!selected) holder = ((i - 7) * 25);

		else holder -= 63;

		if (!selected) g.setColor(((i > 7 && i < 17)? (new Color(holder, holder, holder)) : Color.WHITE));

		else g.setColor(((holder > 0)? (new Color(holder, holder, holder)) : Color.BLACK));

		g.setFont(destinyFont);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

		g2.drawImage(Sorcery.imgs.get(path + "1.png"), 88, 170, null);
		g2.drawImage(Sorcery.imgs.get(path + "2.png"), 166, 170, null);
		g2.drawImage(Sorcery.imgs.get(path + "3.png"), 244, 170, null);

		if (i > 7) g.drawString(help, 125, 150);

		if (i > 43) {

			g.setFont(spoilerFont);

			g.drawString ("(damage)", 95, 255);
			g.drawString ("(mobility)", 165, 255);
			g.drawString ("(defense)", 250, 255);

		}

	}

}
