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
import ej.style.Size;
import ej.style.Style;
import ej.style.background.Background;
import ej.style.boxmodel.Box;
import ej.style.dimension.Dimension;
import ej.style.font.FontLoader;
import ej.style.font.FontProfile;

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
		// Content size…
		Dimension dimension = style.getDimension();
		dimension.apply(contentSize, widthHint, heightHint);

		// … plus padding size…
		Box padding = style.getPadding();
		padding.box(contentSize);

		// … plus border size…
		Box border = style.getBorder();
		border.box(contentSize);

		// … plus margin size…
		Box margin = style.getMargin();
		margin.box(contentSize);

		return contentSize;
	}

	public static void renderWithoutContent(GraphicsContext g, Size remainingSize, Style style) {
		// Apply margin.
		Box margin = style.getMargin();
		margin.apply(g, remainingSize);

		// Draw border.
		Box border = style.getBorder();
		border.apply(g, remainingSize);

		// Draw background.
		Background background = style.getBackground();
		background.draw(g, remainingSize.getWidth(), remainingSize.getHeight());

		// Apply padding.
		Box padding = style.getPadding();
		padding.apply(g, remainingSize);
	}
}
