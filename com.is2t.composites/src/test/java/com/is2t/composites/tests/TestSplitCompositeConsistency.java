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

import ej.microui.MicroUI;
import ej.mwt.Widget;

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
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 0 item", splitComposite.getWidgetsCount(), 0);
		splitComposite.add(item1);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 1 item", splitComposite.getWidgetsCount(), 1);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 1st item",
				contains(splitComposite.getWidgets(), item1));
		splitComposite.add(item2);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2 item", splitComposite.getWidgetsCount(), 2);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 1st item",
				contains(splitComposite.getWidgets(), item1));
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2nd item",
				contains(splitComposite.getWidgets(), item2));

		try {
			// test add a third
			splitComposite.add(item3);
			CheckHelper.check(TestSplitCompositeConsistency.class, "3 children", false);
		} catch (IllegalArgumentException e) {
			CheckHelper.check(TestSplitCompositeConsistency.class, "3 children", true);
			CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2 item", splitComposite.getWidgetsCount(),
					2);
			CheckHelper.check(TestSplitCompositeConsistency.class, "contains 1st item",
					contains(splitComposite.getWidgets(), item1));
			CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2nd item",
					contains(splitComposite.getWidgets(), item2));
		}

		// test remove
		splitComposite.remove(item1);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 1 item", splitComposite.getWidgetsCount(), 1);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2nd item",
				contains(splitComposite.getWidgets(), item2));
		splitComposite.add(item3);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2 item", splitComposite.getWidgetsCount(), 2);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2nd item",
				contains(splitComposite.getWidgets(), item2));
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 3rd item",
				contains(splitComposite.getWidgets(), item3));

		// test remove all
		splitComposite.removeAllWidgets();
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 0 item", splitComposite.getWidgetsCount(), 0);
		splitComposite.add(item2);
		splitComposite.add(item1);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2 item", splitComposite.getWidgetsCount(), 2);
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 1st item",
				contains(splitComposite.getWidgets(), item1));
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 2nd item",
				contains(splitComposite.getWidgets(), item2));

		// test empty validation
		splitComposite.removeAllWidgets();
		CheckHelper.check(TestSplitCompositeConsistency.class, "contains 0 item", splitComposite.getWidgetsCount(), 0);
		TestHelper.showAndWait(splitComposite, false);
		CheckHelper.check(TestSplitCompositeAlone.class, "composite width", splitComposite.getWidth(), 0);
		CheckHelper.check(TestSplitCompositeAlone.class, "composite height", splitComposite.getHeight(), 0);

		CheckHelper.endCheck(TestSplitCompositeConsistency.class);
	}

	private static boolean contains(Widget[] widgets, Widget widget) {
		for (Widget candidate : widgets) {
			if (candidate == widget) {
				return true;
			}
		}
		return false;
	}

}
