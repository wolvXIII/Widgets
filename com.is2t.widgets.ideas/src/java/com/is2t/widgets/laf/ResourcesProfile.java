/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.laf;

import com.is2t.widgets.font.FontProfile;

import ej.microui.io.DisplayFont;
import ej.microui.io.Image;

public interface ResourcesProfile {

	DisplayFont getFont(FontProfile fontProfile);

	Image getImage(String name);

	int getDefaultMargin();

	int getDefaultPadding();

}
