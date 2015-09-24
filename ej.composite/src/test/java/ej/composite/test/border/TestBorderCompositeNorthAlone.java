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
import ej.mwt.MWT;

/**
 *
 */
public class TestBorderCompositeNorthAlone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestBorderCompositeNorthAlone().start();
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

		Item topLabel = new Item(baseWidth, baseHeight);
		BorderComposite borderComposite = new BorderComposite();
		borderComposite.setHorizontal(true);
		borderComposite.add(topLabel, MWT.NORTH);
		TestHelper.showAndWait(borderComposite, false);

		// get widgets size
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h top width", topLabel.getWidth(), baseWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h composite width", borderComposite.getWidth(),
				baseWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h composite height", borderComposite.getHeight(),
				baseHeight);

		TestHelper.hide(borderComposite);
		TestHelper.showAndWait(borderComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h top width", topLabel.getWidth(), baseWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h top height", topLabel.getHeight(), displayHeight);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h composite width", borderComposite.getWidth(),
				displayWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h composite height", borderComposite.getHeight(),
				displayHeight);
	}

	private void testVertical() {
		final int baseWidth = 30;
		final int baseHeight = 20;

		Item topLabel = new Item(baseWidth, baseHeight);
		BorderComposite borderComposite = new BorderComposite();
		borderComposite.setHorizontal(false);
		borderComposite.add(topLabel, MWT.NORTH);
		TestHelper.showAndWait(borderComposite, false);

		// get widgets size
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "v top width", topLabel.getWidth(), baseWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "v top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "v composite width", borderComposite.getWidth(),
				baseWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "v composite height", borderComposite.getHeight(),
				baseHeight);

		TestHelper.hide(borderComposite);
		TestHelper.showAndWait(borderComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h top width", topLabel.getWidth(), displayWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h composite width", borderComposite.getWidth(),
				displayWidth);
		CheckHelper.check(TestBorderCompositeNorthAlone.class, "h composite height", borderComposite.getHeight(),
				displayHeight);
	}

}
