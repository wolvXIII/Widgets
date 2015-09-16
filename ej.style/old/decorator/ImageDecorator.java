/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.decorator;

import com.is2t.widgets.laf.ColorProfile;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

public class ImageDecorator extends AbstractDecorator implements Decorator {

	private final Image image;

	public ImageDecorator(Image image) {
		this.image = image;
	}

	@Override
	public int getWidth() {
		return this.image.getWidth();
	}

	@Override
	public int getHeight() {
		return this.image.getHeight();
	}

	@Override
	public void draw(GraphicsContext g, ColorProfile colorProfile) {
		// TODO manage alignment?
		g.drawImage(this.image, 0, 0, GraphicsContext.LEFT
				| GraphicsContext.TOP);
	}

}
