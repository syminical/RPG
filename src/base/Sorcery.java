
//theworldisquiethere

import javax.swing.*;
import java.awt.*;

public class Sorcery extends JFrame {

	public static Sorcery spell;
	public static Witchcraft magic;
	public static ImgContainer imgs = new ImgContainer();
	public static int length = 400;
	private JPanel atlas;
	
	public Sorcery(String container) {

		super(container);

		burden();

		buildAbox();

		magic.start();

	}

	private void burden() {

		magic = new Witchcraft();

		atlas = new JPanel();

		atlas.setLayout(new BoxLayout(atlas, BoxLayout.Y_AXIS));

		atlas.add(magic);

	}

	private void buildAbox() {

		setContentPane(atlas);
		setPreferredSize(new Dimension(length, length));
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String args[]) {

		spell = new Sorcery("Roleplaying Precision Game");

	}

}
