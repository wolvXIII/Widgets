/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.visual;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.Image;

/**
 * 
 */
public class TestImage {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();

		ej.microui.display.Image source = createImage();
		Image image = new Image(source);
		panel.setWidget(image);
		panel.show(desktop, true);
		desktop.show();
	}

	private static ej.microui.display.Image createImage() {
		int imageSize = 128;
		ej.microui.display.Image source = ej.microui.display.Image.createImage(imageSize, imageSize);
		GraphicsContext g = source.getGraphicsContext();
		g.setColor(Colors.YELLOW);
		g.fillRect(0, 0, imageSize, imageSize);
		return source;
	}
}
