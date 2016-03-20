
//theworldisquiethere

public class Entity {

	protected int hp, x, y;

	public int hp() { return hp; }

	public int getX() { return x; }

	public int getY() { return y; }

	public void influenceHp(int container) { hp += container; }

	public void influenceX(int container) { x += container; }

	public void influenceY(int container) { y += container; }

}
