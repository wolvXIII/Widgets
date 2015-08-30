/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.widget.background.Background;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.Boxing;
import ej.widget.font.FontProfile;

/**
 *
 */
public interface Style {

	int getForegroundColor();

	Background getBackground();

	FontProfile getFontProfile();

	// TODO manage text decoration & text indent & text tranform
	int getTextAlign();

	Dimension getDimension();

	Boxing getPadding();

	Border getBorder();

	Boxing getMargin();

}
