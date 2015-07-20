/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets;

import com.is2t.widgets.background.Background;
import com.is2t.widgets.boxmodel.Border;
import com.is2t.widgets.boxmodel.Boxing;
import com.is2t.widgets.font.FontProfile;

/**
 *
 */
public interface Style {

	int getForegroundColor();

	Background getBackground();

	FontProfile getFontProfile();

	int getTextAlign();

	Dimension getDimension();

	Boxing getPadding();

	Border getBorder();

	Boxing getMargin();

}
