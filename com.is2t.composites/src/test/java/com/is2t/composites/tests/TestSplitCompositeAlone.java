/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.composites.tests;

import com.is2t.composites.SplitComposite;
import com.is2t.composites.widgets.Item;
import com.is2t.testsuite.support.CheckHelper;

/**
 *
 */
public class TestSplitCompositeAlone {

	public static void main(String[] args) {
		CheckHelper.startCheck(TestSplitCompositeAlone.class);

		testHorizontal();
		testVertical();

		CheckHelper.endCheck(TestSplitCompositeAlone.class);
	}

	private static void testHorizontal() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = new SplitComposite();
		splitComposite.setHorizontal(true);
		splitComposite.setRatio(ratio);
		splitComposite.add(leftLabel);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeAlone.class, "left width", leftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "left height", leftLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeAlone.class, "composite width", splitComposite.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "composite height", splitComposite.getHeight(), baseHeight);
	}

	private static void testVertical() {
		final int baseWidth = 30;
		final int baseHeight = 20;
		float ratio = (float) 1 / 3;

		Item leftLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = new SplitComposite();
		splitComposite.setHorizontal(false);
		splitComposite.setRatio(ratio);
		splitComposite.add(leftLabel);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeAlone.class, "left width", leftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "left height", leftLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeAlone.class, "composite width", splitComposite.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "composite height", splitComposite.getHeight(), baseHeight);
	}

}
