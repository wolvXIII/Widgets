/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.grid;

import ej.composite.GridComposite;
import ej.composite.test.Test;
import ej.composite.test.TestHelper;
import ej.composite.widget.Item;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestGridCompositeSimple extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestGridCompositeSimple().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private static void testHorizontal() {
		final int baseWidth = 30;
		final int baseHeight = 20;

		Item firstLabel = new Item(baseWidth, baseHeight);
		Item secondLabel = new Item(baseWidth, baseHeight);
		Item thirdLabel = new Item(baseWidth, baseHeight);
		GridComposite gridComposite = new GridComposite();
		gridComposite.setHorizontal(true);
		gridComposite.setCount(2);
		gridComposite.add(firstLabel);
		gridComposite.add(secondLabel);
		gridComposite.add(thirdLabel);
		TestHelper.showAndWait(gridComposite, false);

		// get widgets size
		TestHelper.checkWidget("h first", firstLabel, 0, 0, baseWidth, baseHeight);
		TestHelper.checkWidget("h second", secondLabel, baseWidth, 0, baseWidth, baseHeight);
		TestHelper.checkWidget("h third", thirdLabel, 0, baseHeight, baseWidth, baseHeight);
		TestHelper.checkWidget("h composite", gridComposite, 0, 0, baseWidth * 2, baseHeight * 2);

		TestHelper.hide(gridComposite);
		TestHelper.showAndWait(gridComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		TestHelper.checkWidget("h first", firstLabel, 0, 0, displayWidth / 2, displayHeight / 2);
		TestHelper.checkWidget("h second", secondLabel, displayWidth / 2, 0, displayWidth / 2, displayHeight / 2);
		TestHelper.checkWidget("h third", thirdLabel, 0, displayHeight / 2, displayWidth / 2, displayHeight / 2);
		TestHelper.checkWidget("h composite", gridComposite, 0, 0, displayWidth, displayHeight);
	}

	private static void testVertical() {
		final int baseWidth = 30;
		final int baseHeight = 20;

		Item firstLabel = new Item(baseWidth, baseHeight);
		Item secondLabel = new Item(baseWidth, baseHeight);
		Item thirdLabel = new Item(baseWidth, baseHeight);
		GridComposite gridComposite = new GridComposite();
		gridComposite.setHorizontal(false);
		gridComposite.setCount(2);
		gridComposite.add(firstLabel);
		gridComposite.add(secondLabel);
		gridComposite.add(thirdLabel);
		TestHelper.showAndWait(gridComposite, false);

		// get widgets size
		TestHelper.checkWidget("v first", firstLabel, 0, 0, baseWidth, baseHeight);
		TestHelper.checkWidget("v second", secondLabel, 0, baseHeight, baseWidth, baseHeight);
		TestHelper.checkWidget("v third", thirdLabel, baseWidth, 0, baseWidth, baseHeight);
		TestHelper.checkWidget("v composite", gridComposite, 0, 0, baseWidth * 2, baseHeight * 2);

		TestHelper.hide(gridComposite);
		TestHelper.showAndWait(gridComposite, true);

		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();
		// get widgets size
		TestHelper.checkWidget("v first", firstLabel, 0, 0, displayWidth / 2, displayHeight / 2);
		TestHelper.checkWidget("v second", secondLabel, 0, displayHeight / 2, displayWidth / 2, displayHeight / 2);
		TestHelper.checkWidget("v third", thirdLabel, displayWidth / 2, 0, displayWidth / 2, displayHeight / 2);
		TestHelper.checkWidget("v composite", gridComposite, 0, 0, displayWidth, displayHeight);
	}

}
