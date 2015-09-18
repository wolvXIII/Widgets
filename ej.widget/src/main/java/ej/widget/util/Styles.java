/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.util;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.display.DisplayFont;
import ej.microui.display.GraphicsContext;
import ej.style.Style;
import ej.style.background.Background;
import ej.style.dimension.Dimension;
import ej.style.font.FontLoader;
import ej.style.font.FontProfile;
import ej.style.outline.Outline;
import ej.style.util.Size;

public class Styles {

	// Prevents initialization.
	private Styles() {
	}

	public static DisplayFont getFont(Style style) {
		FontProfile fontProfile = style.getFontProfile();
		FontLoader fontLoader = ServiceLoaderFactory.getServiceLoader().getService(FontLoader.class);
		DisplayFont font = fontLoader.getFont(fontProfile);
		return font;
	}

	public static Size computePreferredSize(int widthHint, int heightHint, Style style, Size contentSize) {
		Size preferredSize = new Size();

		// Content size…
		Dimension dimension = style.getDimension();
		dimension.apply(contentSize, widthHint, heightHint);

		// … plus padding size…
		Outline padding = style.getPadding();
		padding.wrap(preferredSize);

		// … plus border size…
		Outline border = style.getBorder();
		border.wrap(preferredSize);

		// … plus margin size…
		Outline margin = style.getMargin();
		margin.wrap(preferredSize);

		return preferredSize;
	}

	public static void renderWithoutContent(GraphicsContext g, Size remainingSize, Style style) {
		// Apply margin.
		Outline margin = style.getMargin();
		margin.apply(g, remainingSize);

		// Draw border.
		Outline border = style.getBorder();
		border.apply(g, remainingSize);

		// Draw background.
		Background background = style.getBackground();
		background.draw(g, remainingSize.getWidth(), remainingSize.getHeight());

		// Apply padding.
		Outline padding = style.getPadding();
		padding.apply(g, remainingSize);
	}
}
