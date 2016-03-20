
//theworldisquiethere

import java.awt.image.*;
import java.util.ArrayList;

public class ImgContainer {

	private ArrayList<ImgWrapper> holder = new ArrayList<ImgWrapper>();

	public ImgContainer() {

		load("img/entities/player/1.png");
		load("img/entities/player/2.png");
		load("img/entities/player/3.png");
		load("img/menu/1.png");
		load("img/menu/2.png");
		load("img/menu/3.png");
		load("img/maps/0.png");
		load("img/maps/1u.png");
		load("img/maps/1r.png");
		load("img/maps/1d.png");
		load("img/maps/1l.png");
		load("img/maps/2u.png");
		load("img/maps/2r.png");
		load("img/maps/2d.png");
		load("img/maps/2l.png");
		load("img/maps/3u.png");
		load("img/maps/3r.png");
		load("img/maps/3d.png");
		load("img/maps/3l.png");
		load("img/maps/4.png");
		load("img/maps/2ud.png");
		load("img/maps/2rl.png");
		load("img/entities/player/spells/1.png");
		load("img/entities/player/spells/12.png");
		load("img/entities/player/spells/2.png");
		load("img/entities/player/spells/3.png");

	}

	private void load(String container) {

		holder.add(new ImgWrapper(container));

	}	

	public BufferedImage get(String container) {

		for (ImgWrapper temp : holder)

			if (temp.getName().equals(container)) return temp.getImg();

		return null;

	}

}
