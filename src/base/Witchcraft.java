
//theworldisquiethere

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Witchcraft extends JPanel {

	public boolean intro = false, selection = false;
	public int mX, mY;
	public Player player;
	public MapKeeper dungeon = new MapKeeper();
	private boolean gameRunning = false, up = false, right = false, down = false, left = false;
	private int fps = 0, stage = 0, destiny = 0, directionX = 0, directionY = 0;
	private ArrayList<Effect> effects = new ArrayList<Effect>();
	private Font manaFont = new Font("Monospaced", Font.PLAIN, 10);

	public Witchcraft() {

		setBackground(Color.BLACK);

		listeners();

	}

	public void start() {

		double target = 30, start = 0, end = start, totalTime = start, sleepTime = start, tracker = start, totalFrames = start, limit = start;

		while (true) {

			start = System.currentTimeMillis();

			stage();

			updateEffects();

			move();

			if (selection && stage > 3) dungeon.update();

			repaint();

			end = System.currentTimeMillis();

			totalTime += (end - start);

			sleepTime = (1000 / ((gameRunning)? target : 10)) - (end - start);

			if (sleepTime > 0) {

				if (tracker > sleepTime) {

					tracker -= sleepTime;

					sleepTime = 0;

				} else {

					sleepTime -= tracker;

					tracker = 0;

				}

			} else {

				tracker -= sleepTime;
				sleepTime = 0;

			}

			if (sleepTime > 0) {

				try {

					Thread.sleep(((int)sleepTime));

				} catch (InterruptedException e) {

				}

			}

			totalTime += System.currentTimeMillis() - end;

			if (totalTime >= 1000) {

				totalFrames++;
				fps = ((int)totalFrames);

				tracker = 0;
				totalFrames = 0;
				totalTime = 0;

			} else totalFrames++;

		}

	}

	public void paint(Graphics g) {

		super.paint(g);

		if (selection && stage > 3) { dungeon.draw(g); player.draw(g); drawBar(g); }
		//drawFps(g);
		drawEffects(g);

	}

	private void drawBar(Graphics g) {

		String mp = "", hp = "";

		g.setFont(manaFont);
		g.setColor(Color.BLUE);

		for (int i = 0; i < player.mp(); i++)

			mp += "**";

		g.drawString(mp, 40, 370);

		g.setColor(Color.WHITE);

		g.drawString(" :Mana | Health: ", 155, 370);

		for (int i = 0; i < player.hp(); i++)

			hp += "**";

		g.setColor(Color.RED);

		g.drawString(hp, 250, 370);

	}

	private void drawFps(Graphics g) {

		g.setColor(Color.WHITE);

		g.drawString("[" + fps + "] | [" + mX + "] | [" + mY + "]", 20, 20);

	}

	public void drawEffects(Graphics g) {

		for (int i = effects.size() - 1; i > -1; i--)

			effects.get(i).draw(g);

	}

	public void updateEffects() {

		for (int i = 0; i < effects.size(); i++)

			if (effects.get(i).update()) effects.remove(i);

	}

	public void addEffect(Effect container) {

		effects.add(container);

	}

	private void stage() {

		if (stage == 0 && !intro) {

			effects.add(new CircleExplosion(new ExplosionFlash(new Title(new Branding()))));

			stage = 1;

		} else if (stage == 1 && intro && !selection) {

			effects.add(new Selection(new NextStage()));

			stage = 2;

		} else if (stage == 3 && intro && selection) {

			player = new Player(destiny);

			gameRunning = true;

			stage = 4;

			effects.add(new Help());

		}

	}

	public void nextStage() { stage++; }

	private void move() {

		if (!selection || stage < 4) return;

		if (directionX != 0) {

			if (directionX == 1) player.right();

			else player.left();

		}

		if (directionY != 0) {

			if (directionY == 1) player.up();

			else player.down();

		}

	}

	private void listeners() {

		this.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				//JOptionPane.showMessageDialog(null,"x: [" + e.getX() + "] | y: [" + e.getY() + "]" , null, JOptionPane.PLAIN_MESSAGE);

				if (stage == 2 && !selection && e.getY() >= 180 && e.getY() <= 247) {

					if (e.getX() >= 87 && e.getX() <= 155) { destiny = 1; selection = true;}

					else if (e.getX() >= 166 && e.getX() <= 233) { destiny = 2; selection = true; }

					else if (e.getX() >= 244 && e.getX() <= 311) { destiny = 3; selection = true; }

				}

			}

		});

		this.addMouseMotionListener(new MouseAdapter() {

			public void mouseMoved(MouseEvent e) {

				mX = e.getX();

				mY = e.getY();

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "up");	
		this.getActionMap().put("up", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (!up) {

					up = true; 

					directionY = 1;

				}

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "notUp");
		this.getActionMap().put("notUp", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				up = false;

				if (down) directionY = -1; else directionY = 0;

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");	
		this.getActionMap().put("right", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (!right) {

					right = true; 

					directionX = 1;

				}

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "notRight");
		this.getActionMap().put("notRight", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				right = false;

				if (left) directionX = -1; else directionX = 0;

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "down");	
		this.getActionMap().put("down", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (!down) {

					down = true; 

					directionY = -1;

				}

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "notDown");
		this.getActionMap().put("notDown", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				down = false;

				if (up) directionY = 1; else directionY = 0;

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");	
		this.getActionMap().put("left", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (!left) {

					left = true; 

					directionX = -1;

				}

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "notLeft");
		this.getActionMap().put("notLeft", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				left = false;

				if (right) directionX = 1; else directionX = 0;

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "power");	
		this.getActionMap().put("power", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (stage < 3 || !selection) return;

				if (player.destiny() == 1 && player.mp() >= 3) effects.add(new One());
	
				else if (player.destiny() == 2 && player.mp() >= 5) effects.add(new Two());

				else if (player.destiny() == 3) {

					if (player.mp() > 1 && !player.shield) { 

						player.shield = true; 
						effects.add(new Three()); 

					} else if (player.shield) { player.shield = false; }

				}

			}

		});

		this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "space");	
		this.getActionMap().put("space", new AbstractAction() {

			public void actionPerformed(ActionEvent e) {

				if (stage > 3) effects.add(new Shot());

			}

		});

	}

}
