/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.grid;

import ej.composite.GridComposite;
import ej.composite.test.Test;
import ej.composite.test.TestHelper;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestGridCompositeNone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestGridCompositeNone().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private static void testHorizontal() {
		GridComposite gridComposite = new GridComposite();
		gridComposite.setHorizontal(true);
		gridComposite.setCount(2);
		TestHelper.showAndWait(gridComposite, false);

		// get widgets size
		TestHelper.checkWidget("h composite", gridComposite, 0, 0, 0, 0);

		TestHelper.hide(gridComposite);
		TestHelper.showAndWait(gridComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		TestHelper.checkWidget("h composite", gridComposite, 0, 0, displayWidth, displayHeight);
	}

	private static void testVertical() {
		GridComposite gridComposite = new GridComposite();
		gridComposite.setHorizontal(false);
		gridComposite.setCount(2);
		TestHelper.showAndWait(gridComposite, false);

		// get widgets size
		TestHelper.checkWidget("v composite", gridComposite, 0, 0, 0, 0);

		TestHelper.hide(gridComposite);
		TestHelper.showAndWait(gridComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		TestHelper.checkWidget("v composite", gridComposite, 0, 0, displayWidth, displayHeight);
	}

}
