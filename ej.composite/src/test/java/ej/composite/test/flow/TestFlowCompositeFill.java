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
import ej.composite.test.framework.widget.FillItem;
import ej.composite.test.framework.widget.Item;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 *
 */
public class TestFlowCompositeFill extends Test {

	public static void main(String[] args) {
		MicroUI.start();
		new TestFlowCompositeFill().start();
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

		final int width0 = 18;
		final int height0 = 15;
		FillItem item0 = new FillItem(true, width0, height0);
		final int width1 = 20;
		final int height1 = 30;
		Item item1 = new Item(width1, height1);
		final int width2 = 15;
		final int height2 = 20;
		FillItem item2 = new FillItem(true, width2, height2);
		FlowComposite flowComposite = new FlowComposite();
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 0);
		flowComposite.add(item0);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 1);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item0);
		flowComposite.add(item1);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 2);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item0);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item1);
		flowComposite.add(item2);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 3);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item0);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item1);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item2);

		TestHelper.showAndWait(flowComposite, false);
		TestHelper.checkWidget(getClass(), "item0", item0, 0, 0, width0, height0);
		TestHelper.checkWidget(getClass(), "item1", item1, width0, 0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, width0 + width1, 0, width2, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0,
				width0 + width1 + width2, Math.max(height0, Math.max(height1, height2)));
		TestHelper.hide(flowComposite);

		TestHelper.showAndWait(flowComposite, true);
		TestHelper.checkWidget(getClass(), "item0", item0, 0, 0, displayWidth, height0);
		TestHelper.checkWidget(getClass(), "item1", item1, 0, height0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, 0, height0 + height1, displayWidth, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0, displayWidth, displayHeight);
		TestHelper.hide(flowComposite);
	}

	private void testVertical() {
		Display display = Display.getDefaultDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();

		final int width0 = 18;
		final int height0 = 15;
		FillItem item0 = new FillItem(false, width0, height0);
		final int width1 = 20;
		final int height1 = 30;
		Item item1 = new Item(width1, height1);
		final int width2 = 15;
		final int height2 = 20;
		FillItem item2 = new FillItem(false, width2, height2);
		FlowComposite flowComposite = new FlowComposite();
		flowComposite.setHorizontal(false);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 0);
		flowComposite.add(item0);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 1);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item0);
		flowComposite.add(item1);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 2);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item0);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item1);
		flowComposite.add(item2);
		TestHelper.checkItemsCount(TestFlowCompositeFill.class, flowComposite, 3);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item0);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item1);
		TestHelper.checkContains(TestFlowCompositeFill.class, flowComposite, item2);

		TestHelper.showAndWait(flowComposite, false);
		TestHelper.checkWidget(getClass(), "item0", item0, 0, 0, width0, height0);
		TestHelper.checkWidget(getClass(), "item1", item1, 0, height0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, 0, height0 + height1, width2, height2);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0,
				Math.max(width0, Math.max(width1, width2)), height0 + height1 + height2);
		TestHelper.hide(flowComposite);

		TestHelper.showAndWait(flowComposite, true);
		TestHelper.checkWidget(getClass(), "item0", item0, 0, 0, width0, displayHeight);
		TestHelper.checkWidget(getClass(), "item1", item1, width0, 0, width1, height1);
		TestHelper.checkWidget(getClass(), "item2", item2, width0 + width1, 0, width2, displayHeight);
		TestHelper.checkWidget(getClass(), "composite", flowComposite, 0, 0, displayWidth, displayHeight);
		TestHelper.hide(flowComposite);
	}

}
