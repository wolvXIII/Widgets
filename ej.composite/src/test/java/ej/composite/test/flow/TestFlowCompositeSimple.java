/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.composite.test.flow;

import ej.composite.FlowComposite;
import ej.composite.test.framework.Test;
import ej.composite.test.framework.TestHelper;
import ej.composite.test.framework.widget.Item;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestFlowCompositeSimple extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestFlowCompositeSimple().start();
		MicroUI.stop();
	}

	@Override
	protected void run() {
		testHorizontal();
		testVertical();
	}

	private void testHorizontal() {
		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();

		final int width1 = 20;
		final int height1 = 30;
		Item item1 = new Item(width1, height1);
		final int width2 = 15;
		final int height2 = 20;
		Item item2 = new Item(width2, height2);
		FlowComposite flowComposite = new FlowComposite();
		TestHelper.checkItemsCount(TestFlowCompositeSimple.class, flowComposite, 0);
		flowComposite.add(item1);
		TestHelper.checkItemsCount(TestFlowCompositeSimple.class, flowComposite, 1);
		TestHelper.checkContains(TestFlowCompositeSimple.class, flowComposite, item1);
		flowComposite.add(item2);
		TestHelper.checkItemsCount(TestFlowCompositeSimple.class, flowComposite, 2);
		TestHelper.checkContains(TestFlowCompositeSimple.class, flowComposite, item1);
		TestHelper.checkContains(TestFlowCompositeSimple.class, flowComposite, item2);

		TestHelper.showAndWait(flowComposite, false);
		TestHelper.checkWidget(getClass(), "item1", item1, 0, 0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, width1, 0, width2, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0, width1 + width2, Math.max(height1, height2));
		TestHelper.hide(flowComposite);

		TestHelper.showAndWait(flowComposite, true);
		TestHelper.checkWidget(getClass(), "item1", item1, 0, 0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, width1, 0, width2, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0, displayWidth, displayHeight);
		TestHelper.hide(flowComposite);
	}

	private void testVertical() {
		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();

		final int width1 = 20;
		final int height1 = 30;
		Item item1 = new Item(width1, height1);
		final int width2 = 15;
		final int height2 = 20;
		Item item2 = new Item(width2, height2);
		FlowComposite flowComposite = new FlowComposite();
		flowComposite.setHorizontal(false);
		TestHelper.checkItemsCount(TestFlowCompositeSimple.class, flowComposite, 0);
		flowComposite.add(item1);
		TestHelper.checkItemsCount(TestFlowCompositeSimple.class, flowComposite, 1);
		TestHelper.checkContains(TestFlowCompositeSimple.class, flowComposite, item1);
		flowComposite.add(item2);
		TestHelper.checkItemsCount(TestFlowCompositeSimple.class, flowComposite, 2);
		TestHelper.checkContains(TestFlowCompositeSimple.class, flowComposite, item1);
		TestHelper.checkContains(TestFlowCompositeSimple.class, flowComposite, item2);

		TestHelper.showAndWait(flowComposite, false);
		TestHelper.checkWidget(getClass(), "item1", item1, 0, 0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, 0, height1, width2, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0, Math.max(width1, width2), height1 + height2);
		TestHelper.hide(flowComposite);

		TestHelper.showAndWait(flowComposite, true);
		TestHelper.checkWidget(getClass(), "item1", item1, 0, 0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, 0, height1, width2, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0, displayWidth, displayHeight);
		TestHelper.hide(flowComposite);
	}

}
