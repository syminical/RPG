
//theworldisquiethere

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Three extends Effect {

	private double t = 0;
	private AffineTransformOp op;
	private Player player = Sorcery.magic.player;

	public Three() {}

	public Three(Effect container) { super(container); }

	public boolean update() {

		if (super.update()) return true;

		player.influenceMp(-.1);

		if (!player.shield || player.mp() < 1) done = true;

		//op = new AffineTransformOp(AffineTransform.getRotateInstance(Math.toRadians(t), 22, 21), AffineTransformOp.TYPE_BILINEAR);

		//if (t < 359) t += 22.5; else t = 0;

		return false;

	}

	public void draw(Graphics g) {

		player = Sorcery.magic.player;
		
		g.drawImage(Sorcery.imgs.get("img/entities/player/spells/3.png"), player.getX() - 8, player.getY() - 8, null);
		//g.drawImage(op.filter(Sorcery.imgs.get("img/entities/player/spells/3.png"), null), player.getX() / 2, player.getY() / 2, null);

	}

}
