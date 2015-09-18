/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.flow;

import ej.composite.FlowComposite;
import ej.composite.test.Test;
import ej.composite.test.TestHelper;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestFlowCompositeNone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestFlowCompositeNone().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private void testHorizontal() {
		FlowComposite composite = new FlowComposite();
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
		FlowComposite composite = new FlowComposite();
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
