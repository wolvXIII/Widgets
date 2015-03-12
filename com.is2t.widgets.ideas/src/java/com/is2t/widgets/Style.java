/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets;

import com.is2t.widgets.background.Background;
import com.is2t.widgets.font.FontProfile;

/**
 *
 */
public interface Style {

	int getForegroundColor();

	Background getBackground();

	int getBorderColor();

	int getOutlineColor();

	int getBorderWidth();

	int getBorderRadius();

	FontProfile getFontProfile();

	int getTextAlign();

}
