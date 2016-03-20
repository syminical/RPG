
//theworldisquiethere

import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class ImgWrapper {

	private BufferedImage img;
	private String name;

	public ImgWrapper(String container) {

		name = container;

		try {

			img = ImageIO.read(new File(container));

		} catch (IOException e) {};

	}

	public String getName() { return name; }

	public BufferedImage getImg() { return img; }

}
