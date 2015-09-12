/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.border;

import com.is2t.testsuite.support.CheckHelper;

import ej.composite.BorderComposite;
import ej.composite.SplitComposite;
import ej.composite.test.TestHelper;
import ej.composite.widget.Item;

/**
 *
 */
public class TestBorderCompositeCenterAlone {

	public static void main(String[] args) {
		CheckHelper.startCheck(TestBorderCompositeCenterAlone.class);

		testHorizontal();
		// testVertical();

		CheckHelper.endCheck(TestBorderCompositeCenterAlone.class);
	}

	private static void testHorizontal() {
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
	}

	private static void testVertical() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item topLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = new SplitComposite();
		splitComposite.setHorizontal(false);
		splitComposite.setRatio(ratio);
		splitComposite.add(topLabel);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v top width", topLabel.getWidth(), baseWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v composite width", splitComposite.getWidth(),
				baseWidth);
		CheckHelper.check(TestBorderCompositeCenterAlone.class, "v composite height", splitComposite.getHeight(),
				baseHeight * 3);
	}

}
