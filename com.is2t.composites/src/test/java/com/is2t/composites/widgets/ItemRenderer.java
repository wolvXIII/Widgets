/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.composites.widgets;

import ej.microui.io.GraphicsContext;
import ej.mwt.Renderable;
import ej.mwt.Widget;
import ej.mwt.rendering.WidgetRenderer;

/**
 *
 */
public class ItemRenderer extends WidgetRenderer {

	@Override
	public int getPreferredContentWidth(Widget widget) {
		Item item = (Item) widget;
		return item.getExpectedWidth();
	}

	@Override
	public int getPreferredContentHeight(Widget widget) {
		Item item = (Item) widget;
		return item.getExpectedHeight();
	}

	@Override
	public Class<Item> getManagedType() {
		return Item.class;
	}

	@Override
	public void render(GraphicsContext g, Renderable renderable) {
		Item label = (Item) renderable;
		int renderableWidth = renderable.getWidth();
		int renderableHeight = renderable.getHeight();
		g.setColor(label.getColor());
		g.fillRect(0, 0, renderableWidth, renderableHeight);
	}

}
