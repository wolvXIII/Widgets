/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.decorator;

import com.is2t.widgets.laf.ColorProfile;

import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;

public class PictoDecorator extends AbstractDecorator implements Decorator {

	private final char picto;
	private final DisplayFont font;

	public PictoDecorator(char picto, DisplayFont font) {
		this.picto = picto;
		this.font = font;
	}

	@Override
	public int getWidth() {
		return this.font.charWidth(this.picto);
	}

	@Override
	public int getHeight() {
		return this.font.getHeight();
	}

	@Override
	public void draw(GraphicsContext g, ColorProfile colorProfile) {
		// TODO manage alignment?
		g.setFont(this.font);
		g.setColor(colorProfile.getForegroundColor());
		g.drawChar(this.picto, 0, 0, GraphicsContext.LEFT | GraphicsContext.TOP);
	}

}
