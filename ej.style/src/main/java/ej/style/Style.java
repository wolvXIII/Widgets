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

/**
 *
 */
public interface Style {

	int getForegroundColor();

	Background getBackground();

	FontProfile getFontProfile();

	// TODO manage text decoration & text indent & text tranform & vertical align
	int getTextAlign();

	Dimension getDimension();

	Box getPadding();

	Border getBorder();

	Box getMargin();

}
