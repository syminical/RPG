
//theworldisquiethere

import java.awt.*;
import java.util.ArrayList;

public class Map {

	private ArrayList<Enemy> badGuys = new ArrayList<Enemy>();
	private int doors;
	private String background, config;
	private boolean clear = false;

	public Map(int container, String container2) {

		doors = container;
		config = container2;

		for (int i = 0; i < (Math.random() * 4) + 1; i++)

			badGuys.add(new Enemy());

		background = "img/maps/" + doors + "" + config + ".png";

	} 

	public int doors() { return doors; }

	public String config() { return config; }

	public boolean clear() { return clear; }

	public void update() {

		//if (enemies != null) enemies.update();

	}

	public void collision(int container, int container2, int container3, int container4, int container5) {

		for (Enemy temp : badGuys)

			temp.collision(container, container2, container3, container4, container5);

	}

	public void draw(Graphics g) {

		for (Enemy temp : badGuys)

			temp.draw(g);

		g.drawImage(Sorcery.imgs.get(background), 0, 0, null);

	}

}
