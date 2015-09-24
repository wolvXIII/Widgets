/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.border;

import com.is2t.testsuite.support.CheckHelper;

import ej.composite.BorderComposite;
import ej.composite.test.framework.Test;
import ej.composite.test.framework.TestHelper;
import ej.composite.test.framework.widget.Item;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestBorderCompositeCenterAlone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestBorderCompositeCenterAlone().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private void testHorizontal() {
		final int baseWidth = 30;
		final int baseHeight = 20;

		Item centerLabel = new Item(baseWidth, baseHeight);
		BorderComposite borderComposite = new BorderComposite();
		borderComposite.setHorizontal(true);
		borderComposite.add(centerLabel);
		TestHelper.showAndWait(borderComposite, false);

		// get widgets size
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h center width", centerLabel.getWidth(), baseWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h center height", centerLabel.getHeight(), baseHeight);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h composite width", borderComposite.getWidth(),
				baseWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h composite height", borderComposite.getHeight(),
				baseHeight);

		TestHelper.hide(borderComposite);
		TestHelper.showAndWait(borderComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h center width", centerLabel.getWidth(), displayWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h center height", centerLabel.getHeight(),
				displayHeight);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h composite width", borderComposite.getWidth(),
				displayWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "h composite height", borderComposite.getHeight(),
				displayHeight);
	}

	private void testVertical() {
		final int baseWidth = 30;
		final int baseHeight = 20;

		Item centerLabel = new Item(baseWidth, baseHeight);
		BorderComposite borderComposite = new BorderComposite();
		borderComposite.setHorizontal(false);
		borderComposite.add(centerLabel);
		TestHelper.showAndWait(borderComposite, false);

		// get widgets size
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v center width", centerLabel.getWidth(), baseWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v center height", centerLabel.getHeight(), baseHeight);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v composite width", borderComposite.getWidth(),
				baseWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v composite height", borderComposite.getHeight(),
				baseHeight);

		TestHelper.hide(borderComposite);
		TestHelper.showAndWait(borderComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v center width", centerLabel.getWidth(), displayWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v center height", centerLabel.getHeight(),
				displayHeight);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v composite width", borderComposite.getWidth(),
				displayWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v composite height", borderComposite.getHeight(),
				displayHeight);
	}

}
