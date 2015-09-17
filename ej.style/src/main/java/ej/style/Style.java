/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style;

import ej.style.background.Background;
import ej.style.boxmodel.Border;
import ej.style.boxmodel.Box;
import ej.style.dimension.Dimension;
import ej.style.font.FontProfile;
import ej.style.text.TextManager;

/**
 *
 */
public interface Style {

	int getForegroundColor();

	Background getBackground();

	FontProfile getFontProfile();

	TextManager getTextManager();

	Dimension getDimension();

	Box getPadding();

	Border getBorder();

	Box getMargin();

}
