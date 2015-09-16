/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.io.Display;
import ej.mwt.Composite;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.mwt.Widget;

/**
 *
 */
public class TestHelper {

	private static Desktop desktop;
	private static Panel panel;

	public static void showAndWait(Widget widget, boolean fill) {
		desktop = new Desktop();
		panel = new Panel();
		panel.setWidget(widget);
		panel.show(desktop, fill);
		desktop.show();

		// wait for show
		Display display = Display.getDefaultDisplay();
		display.waitForEvent();
		display.waitForEvent();
	}

	public static void hide(Widget widget) {
		panel.setWidget(null);
	}

	public static boolean contains(Widget[] widgets, Widget widget) {
		for (Widget candidate : widgets) {
			if (candidate == widget) {
				return true;
			}
		}
		return false;
	}

	public static void checkItemsCount(Class<?> clazz, Composite composite, int count) {
		CheckHelper.check(clazz, "contains " + count + " item" + (count > 1 ? "s" : ""), composite.getWidgetsCount(),
				count);
	}

	public static void checkContains(Class<?> clazz, Composite composite, Widget widget) {
		CheckHelper.check(clazz, "contains item", contains(composite.getWidgets(), widget));
	}

	public static void checkDoesNotContain(Class<?> clazz, Composite composite, Widget widget) {
		CheckHelper.check(clazz, "does not contain item", !contains(composite.getWidgets(), widget));
	}

}
