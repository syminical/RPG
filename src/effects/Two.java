
//theworldisquiethere

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Two extends Effect {

	private Player player = Sorcery.magic.player;
	private int x = Sorcery.magic.mX - 14, y = Sorcery.magic.mY - 14;
	private boolean check = false;
	private float opacity = 0;

	public Two() {

		player.influenceMp(-5);

	}

	public Two(Effect container) { 

		super(container); 

		player.influenceMp(-5);

	}

	public boolean update() {

		if (super.update()) return true;

		player.setX(x);
		player.setY(y);

		if (!check && opacity < 1) opacity += .125;

		if (check && opacity > 0) opacity -= .125;

		if (opacity == 1) check = true;

		if (check && opacity == 0) done = true;

		return false;

	}

	public void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D)g;
		player = Sorcery.magic.player;
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));

		g2.drawImage(Sorcery.imgs.get("img/entities/player/spells/2.png"), player.getX() - 17, player.getY() - 17, null);
		//g.drawImage(op.filter(Sorcery.imgs.get("img/entities/player/spells/3.png"), null), player.getX() / 2, player.getY() / 2, null);

	}

}
