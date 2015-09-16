/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.widget.Style;
import ej.widget.background.PlainBackground;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.SimpleBox;
import ej.widget.dimension.FixedDimension;
import ej.widget.font.FontProfile;
import ej.widget.font.FontProfile.FontSize;
import ej.widget.style.SimpleStyle;

/**
 *
 */
public abstract class StyledWidgetTest {

	/**
	 *
	 */
	public StyledWidgetTest() {
		super();
	}

	public void run() {
		CheckHelper.startCheck(getClass());

		check();

		CheckHelper.endCheck(getClass());
	}

	protected abstract void check();

	protected Style createCompleteStyle() {
		SimpleStyle simpleStyle = new SimpleStyle();
		simpleStyle.setForegroundColor(Colors.RED);
		PlainBackground background = new PlainBackground();
		background.setColor(Colors.BLUE);
		simpleStyle.setBackground(background);
		FontProfile fontProfile = new FontProfile();
		fontProfile.setFamily("Comic Sans MS");
		fontProfile.setSize(FontSize.MEDIUM);
		simpleStyle.setFontProfile(fontProfile);
		FixedDimension dimension = new FixedDimension();
		dimension.setSize(20, 20);
		simpleStyle.setDimension(dimension);
		simpleStyle.setTextAlign(GraphicsContext.LEFT | GraphicsContext.TOP);
		SimpleBox padding = new SimpleBox();
		padding.setSize(10);
		simpleStyle.setPadding(padding);
		Border border = new Border();
		border.setWidth(2);
		border.setRadius(1);
		border.setColor(Colors.MAGENTA);
		simpleStyle.setBorder(border);
		SimpleBox margin = new SimpleBox();
		margin.setSize(5);
		simpleStyle.setMargin(margin);
		return simpleStyle;
	}

	protected Style createForegroundStyle() {
		SimpleStyle simpleStyle = new SimpleStyle();
		simpleStyle.setForegroundColor(Colors.MAGENTA);
		return simpleStyle;
	}

	protected Style createBackgroundStyle() {
		SimpleStyle simpleStyle = new SimpleStyle();
		PlainBackground background = new PlainBackground();
		background.setColor(Colors.GREEN);
		simpleStyle.setBackground(background);
		return simpleStyle;
	}

	protected Style createForegroundBackgroundStyle(int foregroundColor, int backgroundColor) {
		SimpleStyle simpleStyle = new SimpleStyle();
		simpleStyle.setForegroundColor(foregroundColor);
		PlainBackground background = new PlainBackground();
		background.setColor(backgroundColor);
		simpleStyle.setBackground(background);
		return simpleStyle;
	}

}