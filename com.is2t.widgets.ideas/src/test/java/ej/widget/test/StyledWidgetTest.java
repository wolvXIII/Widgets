/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.Colors;
import ej.microui.display.GraphicsContext;
import ej.widget.Dimension;
import ej.widget.Style;
import ej.widget.background.PlainBackground;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.SimpleBoxing;
import ej.widget.font.FontProfile;
import ej.widget.font.FontProfile.FontSize;
import ej.widget.implementation.SimpleStyle;

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
		Dimension dimension = new Dimension();
		dimension.setSize(20, 20);
		simpleStyle.setDimension(dimension);
		simpleStyle.setTextAlign(GraphicsContext.LEFT | GraphicsContext.TOP);
		SimpleBoxing padding = new SimpleBoxing();
		padding.setSize(10);
		simpleStyle.setPadding(padding);
		Border border = new Border();
		border.setWidth(2);
		border.setRadius(1);
		border.setColor(Colors.MAGENTA);
		simpleStyle.setBorder(border);
		SimpleBoxing margin = new SimpleBoxing();
		margin.setSize(5);
		simpleStyle.setMargin(margin);
		return simpleStyle;
	}

	protected Style createForegroundStyle() {
		SimpleStyle simpleStyle = new SimpleStyle();
		simpleStyle.setForegroundColor(Colors.RED);
		return simpleStyle;
	}

	protected Style createBackgroundStyle() {
		SimpleStyle simpleStyle = new SimpleStyle();
		PlainBackground background = new PlainBackground();
		background.setColor(Colors.BLUE);
		simpleStyle.setBackground(background);
		return simpleStyle;
	}

}