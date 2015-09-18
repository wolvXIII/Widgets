/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.border;

import ej.composite.BorderComposite;
import ej.composite.test.Test;
import ej.composite.test.TestHelper;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestBorderCompositeNone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestBorderCompositeNone().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private void testHorizontal() {
		BorderComposite composite = new BorderComposite();
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
		BorderComposite composite = new BorderComposite();
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
