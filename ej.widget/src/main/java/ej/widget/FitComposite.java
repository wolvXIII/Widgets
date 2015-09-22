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
public class FitComposite extends StyledComposite {

	public void setWidget(Widget widget) {
		removeAllWidgets();
		add(widget);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		if (getWidgetsCount() == 1) {
			Widget firstWidget = getWidget(0);
			firstWidget.validate(widthHint, heightHint);
			setPreferredSize(firstWidget.getPreferredWidth(), firstWidget.getPreferredHeight());
			// setPreferredSize(widthHint, heightHint);
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		if (getWidgetsCount() == 1) {
			getWidget(0).setBounds(0, 0, width, height);
		}
	}
}
