/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.microui.display.GraphicsContext;
import ej.style.Style;
import ej.style.util.Rectangle;
import ej.style.util.Size;

/**
 *
 */
public class Image extends StyledWidget {

	private ej.microui.display.Image source;

	public Image(ej.microui.display.Image source) {
		super();
		this.source = source;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source.
	 */
	public ej.microui.display.Image getSource() {
		return this.source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source
	 *            the source to set.
	 */
	public void setSource(ej.microui.display.Image source) {
		this.source = source;
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Rectangle remainingSize) {
		if (this.source != null) {
			g.drawImage(this.source, remainingSize.getWidth() / 2, remainingSize.getHeight() / 2,
					GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		}
	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();

		if (this.source != null) {
			contentSize.setSize(this.source.getWidth(), this.source.getHeight());
		}

		return contentSize;
	}

}
