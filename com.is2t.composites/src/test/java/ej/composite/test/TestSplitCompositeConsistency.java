/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.composite.SplitComposite;
import ej.composite.widget.Item;
import ej.microui.MicroUI;

/**
 *
 */
public class TestSplitCompositeConsistency {

	public static void main(String[] args) {
		MicroUI.errorLog(true);
		CheckHelper.startCheck(TestSplitCompositeConsistency.class);

		final int baseWidth = 30;
		final int baseHeight = 20;
		Item item1 = new Item(baseWidth, baseHeight);
		Item item2 = new Item(baseWidth, baseHeight);
		Item item3 = new Item(baseWidth, baseHeight);
		SplitComposite splitComposite = new SplitComposite();
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 0);
		splitComposite.add(item1);
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 1);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item1);
		splitComposite.add(item2);
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 2);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item1);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item2);

		try {
			// test add a third
			splitComposite.add(item3);
			CheckHelper.check(TestSplitCompositeConsistency.class, "3 children", false);
		} catch (IllegalArgumentException e) {
			CheckHelper.check(TestSplitCompositeConsistency.class, "3 children", true);
			TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 2);
			TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item1);
			TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item2);
		}

		// test remove
		splitComposite.remove(item1);
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 1);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item2);
		splitComposite.add(item3);
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 2);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item2);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item3);

		// test remove all
		splitComposite.removeAllWidgets();
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 0);
		splitComposite.add(item2);
		splitComposite.add(item1);
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 2);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item1);
		TestHelper.checkContains(TestSplitCompositeConsistency.class, splitComposite, item2);

		// test empty validation
		splitComposite.removeAllWidgets();
		TestHelper.checkItemsCount(TestSplitCompositeConsistency.class, splitComposite, 0);
		TestHelper.showAndWait(splitComposite, false);
		CheckHelper.check(TestSplitCompositeConsistency.class, "composite width", splitComposite.getWidth(), 0);
		CheckHelper.check(TestSplitCompositeConsistency.class, "composite height", splitComposite.getHeight(), 0);

		CheckHelper.endCheck(TestSplitCompositeConsistency.class);
	}

}
