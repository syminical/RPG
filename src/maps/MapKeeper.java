
//theworldisquiethere

import java.awt.*;

public class MapKeeper {

	private Map[][] dungeon = new Map[5][5];
	private int x, y;
	private Player player;

	public MapKeeper() {

		generate();

		x = 2;
		y = 2;

	}

	public int getX() { return x; }

	public int getY() { return y; }

	public void collision(int container, int container2, int container3, int container4, int container5) {

		dungeon[y][x].collision(container, container2, container3, container4, container5);

	}

	private void generate() { //no time for auto-gen ;_;

		int[][] draft = new int[5][5];

		switch ((int)(Math.random() * 4)) { //why are arrays so shady :c

			case 0:

				int[] holder = {2, 2, 1, 2, 0, 2, 2, 3, 3, 2, 2, 1};
				implement(fill(holder), draft);
				break;

			case 1:

				int[] holder2 = {2, 2, 1, 2, 1, 3, 2, 3, 2, 4, 3, 4};
				implement(fill(holder2), draft);
				break;

			case 2:

				int[] holder3 = {2, 2, 3, 2, 4, 2, 4, 3, 4, 4, 2, 1};
				implement(fill(holder3), draft);
				break;

			case 3:

				int[] holder4 = {2, 2, 2, 1, 2, 0, 2, 3, 2, 4, 1, 3};
				implement(fill(holder4), draft);
				break;

		}

	}

	private int[][] fill(int[] container) {

		int[][] holder = new int[6][2];
		int i2 = 0;

		for (int i = 0; i < container.length - 1; i += 2) {

			holder[i2][0] = container[i];
			holder[i2][1] = container[i + 1];

			i2++;

		}

		return holder;

	}

	private void implement(int[][] container, int[][] container2) {

		for (int i = 0; i < container.length; i++) { //fill in template

			container2[container[i][0]][container[i][1]] = -1;

		}

		int doors, x, y;
		String name;

		for (int i = 0; i < container.length; i++) { //build rooms

			doors = 0;
			name = "";
			x = container[i][1];
			y = container[i][0];

			if (y != 0 && container2[y - 1][x] == -1) { doors++; name += "u"; }

			if (x != 4 && container2[y][x + 1] == -1) { doors++; name += ((name.length() == 0)? "r" : ""); }

			if (y != 4 && container2[y + 1][x] == -1) { doors++; name += ((name.length() == 0 || (doors == 2 && name.equals("u")))? "d" : ""); }

			if (x != 0 && container2[y][x - 1] == -1) { doors++; name += ((name.length() == 0 || (doors == 2 && name.equals("r")))? "l" : ""); }

			if (doors == 4 || doors == 0) name = "";

			dungeon[y][x] = new Map(doors, name);

		}

	}

	public void update() { //sketchy...

		player = Sorcery.magic.player;

		if (player.mp() < 10) player.influenceMp(.05);

		if (player == null) return;

		if (player.getX() < 19) player.setX(19);

		if (player.getX() > 342) player.setX(342);

		if (player.getY() < 21) player.setY(21);

		if (player.getY() > 315) player.setY(315);

		int y2 = y, x2 = x;		

		if ((player.getY() < 22) && (player.getX() > 125 && player.getX() < 260)) { //top opening

			String[] holder = {"1u", "2u", "2l", "2ud", "3u", "3r", "3l", "4"};

			for (int i = 0; i < holder.length; i++)

				if (((dungeon[y][x].doors()) + (dungeon[y][x].config())).equals(holder[i])) {

					player.setY(310);
					y = y2 - 1;					

				}

		} 

		if ((player.getX() > 341) && (player.getY() > 103 && player.getY() < 251)) { //right opening

			String[] holder = {"1r", "2r", "2u", "2rl", "3u", "3r", "3d", "4"};

			for (int i = 0; i < holder.length; i++)

				if (((dungeon[y][x].doors()) + (dungeon[y][x].config())).equals(holder[i])) {

					player.setX(23);
					x = x2 + 1;

				}

		}

		if ((player.getY() > 314) && (player.getX() > 139 && player.getX() < 262)) { //bottom opening

			String[] holder = {"1d", "2d", "2r", "2ud", "3r", "3d", "3l", "4"};

			for (int i = 0; i < holder.length; i++)

				if (((dungeon[y][x].doors()) + (dungeon[y][x].config())).equals(holder[i])) {

					player.setY(23);
					y =  y2 + 1;

				}

		}

		if ((player.getX() < 20) && (player.getY() > 110 && player.getY() < 236)) { //left opening

			String[] holder = {"1l", "2l", "2d", "2rl", "3u", "3d", "3l", "4"};

			for (int i = 0; i < holder.length; i++)

				if (((dungeon[y][x].doors()) + (dungeon[y][x].config())).equals(holder[i])) {

					player.setX(338);
					x = x2 - 1;
					
				}

		} 


	}

	public void draw(Graphics g) {

		dungeon[y][x].draw(g);

	}

}
