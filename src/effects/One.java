
//theworldisquiethere

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class One extends Effect {

	private Player player = Sorcery.magic.player;
	private double dX = Sorcery.magic.mX - player.getX(), dY = Sorcery.magic.mY - player.getY(), mag = Math.sqrt(dX*dX + dY*dY);
	private int x = player.getX() + 14, y = player.getY() + 14, vel = 5;
	private float opacity = 0;

	public One() {

		player.influenceMp(-3);

	}

	public One(Effect container) { 

		super(container); 

		player.influenceMp(-3);

	}

	public boolean update() {

		if (super.update()) return true;

		x += (int)(dX / mag * vel);
		y += (int)(dY / mag * vel);

		if (opacity < 1) opacity += .125;

		if ((x < 0 || x > 400) && (y < 0 || y > 400)) done = true;

		return false;

	}

	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D)g;
		player = Sorcery.magic.player;
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

		g.drawImage(Sorcery.imgs.get("img/entities/player/spells/1.png"), player.getX() - 8, player.getY() - 7, null);
		g2.drawImage(Sorcery.imgs.get("img/entities/player/spells/12.png"), x, y, null);

	}

}
