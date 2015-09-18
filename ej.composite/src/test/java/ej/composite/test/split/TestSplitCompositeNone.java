/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.split;

import ej.composite.SplitComposite;
import ej.composite.test.Test;
import ej.composite.test.TestHelper;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestSplitCompositeNone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestSplitCompositeNone().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private void testHorizontal() {
		SplitComposite composite = new SplitComposite();
		composite.setHorizontal(true);
		TestHelper.showAndWait(composite, false);

		// get widgets size
		TestHelper.checkWidget(getClass(), "h composite", composite, 0, 0, 0, 0);

		TestHelper.hide(composite);
		TestHelper.showAndWait(composite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		TestHelper.checkWidget(getClass(), "h composite", composite, 0, 0, displayWidth, displayHeight);
	}

	private void testVertical() {
		SplitComposite composite = new SplitComposite();
		composite.setHorizontal(false);
		TestHelper.showAndWait(composite, false);

		// get widgets size
		TestHelper.checkWidget(getClass(), "v composite", composite, 0, 0, 0, 0);

		TestHelper.hide(composite);
		TestHelper.showAndWait(composite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		TestHelper.checkWidget(getClass(), "v composite", composite, 0, 0, displayWidth, displayHeight);
	}

}
