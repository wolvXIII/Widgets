/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.split;

import com.is2t.testsuite.support.CheckHelper;

import ej.composite.SplitComposite;
import ej.composite.test.framework.Test;
import ej.composite.test.framework.TestHelper;
import ej.composite.test.framework.widget.Item;
import ej.microui.MicroUI;

/**
 *
 */
public class TestSplitCompositeAlone extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestSplitCompositeAlone().start();
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
		float ratio = (float) 1 / 3;

		Item leftLabel = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = new SplitComposite();
		splitComposite.setHorizontal(true);
		splitComposite.setRatio(ratio);
		splitComposite.add(leftLabel);
		TestHelper.showAndWait(splitComposite, false);

		// get widgets size
		CheckHelper.check(TestSplitCompositeAlone.class, "h left width", leftLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "h left height", leftLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeAlone.class, "h composite width", splitComposite.getWidth(), baseWidth * 3);
		CheckHelper.check(TestSplitCompositeAlone.class, "h composite height", splitComposite.getHeight(), baseHeight);
	}

	private void testVertical() {
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
		CheckHelper.check(TestSplitCompositeAlone.class, "v top width", topLabel.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "v top height", topLabel.getHeight(), baseHeight);
		CheckHelper.check(TestSplitCompositeAlone.class, "v composite width", splitComposite.getWidth(), baseWidth);
		CheckHelper.check(TestSplitCompositeAlone.class, "v composite height", splitComposite.getHeight(),
				baseHeight * 3);
	}

}
