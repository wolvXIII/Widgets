/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.decorator;

import com.is2t.widgets.laf.ColorProfile;

import ej.microui.io.GraphicsContext;
import ej.mwt.Widget;

/**
 * Perhaps the idea, is not to have a decorator… but to propose layouts to assemble easily widgets together (a label and
 * an image for example).
 */
public class WidgetDecorator extends AbstractDecorator implements Decorator {

	private final Widget widget;

	public WidgetDecorator(Widget widget) {
		this.widget = widget;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public void draw(GraphicsContext g, ColorProfile colorProfile) {
		// TODO Auto-generated method stub

	}

}
