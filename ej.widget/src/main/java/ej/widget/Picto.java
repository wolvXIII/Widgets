/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.style.Style;
import ej.style.util.Rectangle;
import ej.style.util.Size;
import ej.widget.util.Styles;

/**
 *
 */
public class Picto extends StyledWidget {

	private char picto;

	/**
	 * @param picto
	 */
	public Picto(char picto) {
		super();
		this.picto = picto;
	}

	/**
	 * Gets the picto.
	 *
	 * @return the picto.
	 */
	public char getPicto() {
		return this.picto;
	}

	/**
	 * Sets the picto.
	 *
	 * @param picto
	 *            the picto to set.
	 */
	public void setPicto(char picto) {
		this.picto = picto;
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Rectangle remainingSize) {
		g.setFont(Styles.getFont(style));
		g.setColor(style.getForegroundColor());
		g.drawChar(this.picto, remainingSize.getWidth() / 2, remainingSize.getHeight() / 2, GraphicsContext.HCENTER
				| GraphicsContext.VCENTER);
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		DisplayFont font = Styles.getFont(style);
		contentSize.setSize(font.charWidth(this.picto), font.getHeight());
		return contentSize;
	}
}
