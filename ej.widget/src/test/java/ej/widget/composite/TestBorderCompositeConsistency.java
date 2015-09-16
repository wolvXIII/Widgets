/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.composite;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.MicroUI;
import ej.mwt.MWT;
import ej.widget.composite.BorderComposite;

/**
 *
 */
public class TestBorderCompositeConsistency {

	public static void main(String[] args) {
		MicroUI.start();
		CheckHelper.startCheck(TestSplitCompositeConsistency.class);

		final int baseWidth = 30;
		final int baseHeight = 20;
		Item item1 = new Item(baseWidth, baseHeight);
		Item item2 = new Item(baseWidth, baseHeight);
		Item item3 = new Item(baseWidth, baseHeight);
		Item item4 = new Item(baseWidth, baseHeight);
		BorderComposite borderComposite = new BorderComposite();
		// add at center
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 0);
		borderComposite.add(item1);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 1);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item1);
		borderComposite.add(item2, MWT.CENTER);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 1);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item2);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item1);
		// add at west / north
		borderComposite.add(item3, MWT.WEST);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 2);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item3);
		borderComposite.add(item1, MWT.NORTH);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 2);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item1);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item3);
		// add at east / south
		borderComposite.add(item4, MWT.EAST);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 3);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item4);
		borderComposite.add(item3, MWT.SOUTH);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 3);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item3);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item4);

		// add erroneous
		try {
			borderComposite.add(item1, MWT.NONE);
			CheckHelper.check(TestSplitCompositeConsistency.class, "erroneous children", false);
		} catch (IllegalArgumentException e) {
			CheckHelper.check(TestSplitCompositeConsistency.class, "erroneous children", true);
			TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 3);
			TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item1);
			TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item2);
			TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item3);
		}

		// remove
		borderComposite.remove(item1);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 2);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item1);
		borderComposite.remove(item2);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 1);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item2);
		borderComposite.remove(item3);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 0);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item3);

		TestHelper.showAndWait(borderComposite, false);
		CheckHelper.check(TestBorderCompositeConsistency.class, "composite width after remove",
				borderComposite.getWidth(), 0);
		CheckHelper.check(TestBorderCompositeConsistency.class, "composite height after remove",
				borderComposite.getHeight(), 0);
		TestHelper.hide(borderComposite);

		borderComposite.add(item1, MWT.NORTH);
		borderComposite.add(item2);
		borderComposite.add(item3, MWT.SOUTH);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 3);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item1);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item2);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item3);

		// remove at
		borderComposite.remove(MWT.WEST);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 2);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item1);
		borderComposite.remove(MWT.CENTER);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 1);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item2);
		borderComposite.remove(MWT.EAST);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 0);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item3);

		TestHelper.showAndWait(borderComposite, false);
		CheckHelper.check(TestBorderCompositeConsistency.class, "composite width after remove at",
				borderComposite.getWidth(), 0);
		CheckHelper.check(TestBorderCompositeConsistency.class, "composite height after remove at",
				borderComposite.getHeight(), 0);
		TestHelper.hide(borderComposite);

		borderComposite.add(item1, MWT.NORTH);
		borderComposite.add(item2);
		borderComposite.add(item3, MWT.SOUTH);
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 3);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item1);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item2);
		TestHelper.checkContains(TestBorderCompositeConsistency.class, borderComposite, item3);

		// remove all
		borderComposite.removeAllWidgets();
		TestHelper.checkItemsCount(TestBorderCompositeConsistency.class, borderComposite, 0);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item1);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item2);
		TestHelper.checkDoesNotContain(TestBorderCompositeConsistency.class, borderComposite, item3);

		TestHelper.showAndWait(borderComposite, false);
		CheckHelper.check(TestBorderCompositeConsistency.class, "composite width after remove all",
				borderComposite.getWidth(), 0);
		CheckHelper.check(TestBorderCompositeConsistency.class, "composite height after remove all",
				borderComposite.getHeight(), 0);
		TestHelper.hide(borderComposite);

		CheckHelper.endCheck(TestBorderCompositeConsistency.class);
	}

}