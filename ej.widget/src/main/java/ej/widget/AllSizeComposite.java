/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget;

import ej.mwt.Widget;

/**
 * 
 */
public class AllSizeComposite extends StyledComposite {

	public void setWidget(Widget widget) {
		removeAllWidgets();
		add(widget);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		if (getWidgetsCount() == 1) {
			getWidget(0).validate(widthHint, heightHint);
			setPreferredSize(widthHint, heightHint);
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		if (getWidgetsCount() == 1) {
			getWidget(0).setBounds(x, y, width, height);
		}
	}
}
