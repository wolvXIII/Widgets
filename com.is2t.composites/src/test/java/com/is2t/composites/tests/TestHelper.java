/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.composites.tests;

import ej.microui.io.Display;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.mwt.Widget;

/**
 *
 */
public class TestHelper {

	public static void showAndWait(Widget widget, boolean fill) {
		// show it!
		Desktop desktop = new Desktop();
		Panel panel = new Panel();
		panel.setWidget(widget);
		panel.show(desktop, fill);
		desktop.show();

		// wait for show
		Display display = Display.getDefaultDisplay();
		display.waitForEvent();
		display.waitForEvent();
	}

}
