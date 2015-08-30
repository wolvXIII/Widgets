/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.mwt.Widget;
import ej.widget.Style;
import ej.widget.cascading.CascadingStylesheet;
import ej.widget.test.env.SimpleWidget;

public class SimpleTest extends StyledWidgetTest {

	public static void main(String[] args) {
		new SimpleTest().run();
	}

	@Override
	protected void check() {
		Style defaultStyle = checkDefaultStyle();
		checkSetCompleteRenderableStyle();
		checkSetIncompleteRenderableStyle(defaultStyle);
		checkSetCompleteTypeStyle();
		checkSetIncompleteTypeStyle(defaultStyle);
	}

	private Style checkDefaultStyle() {
		Widget renderable = new SimpleWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete default style", StyleHelper.isComplete(stylesheetStyle));

		return stylesheetStyle;
	}

	private void checkSetCompleteRenderableStyle() {
		Widget renderable = new SimpleWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createCompleteStyle();

		stylesheet.setStyle(renderable, style);
		checkSetCompleteStyle(renderable, stylesheet, style);
	}

	private void checkSetIncompleteRenderableStyle(Style defaultStyle) {
		Widget renderable = new SimpleWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createForegroundStyle();

		stylesheet.setStyle(renderable, style);
		checkSetIncompleteStyle(defaultStyle, renderable, stylesheet, style);
	}

	private void checkSetCompleteTypeStyle() {
		Widget renderable = new SimpleWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createCompleteStyle();

		stylesheet.setStyle(renderable.getClass(), style);
		checkSetCompleteStyle(renderable, stylesheet, style);
	}

	private void checkSetIncompleteTypeStyle(Style defaultStyle) {
		Widget renderable = new SimpleWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createForegroundStyle();

		stylesheet.setStyle(renderable.getClass(), style);
		checkSetIncompleteStyle(defaultStyle, renderable, stylesheet, style);
	}

	private void checkSetCompleteStyle(Widget renderable, CascadingStylesheet stylesheet, Style style) {
		Style stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, style);
	}

	private void checkSetIncompleteStyle(Style defaultStyle, Widget renderable, CascadingStylesheet stylesheet,
			Style style) {
		Style stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Set style", !style.equals(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getForegroundColor(),
				style.getForegroundColor());
		CheckHelper.check(getClass(), "Default style attribute", stylesheetStyle.getBackground(),
				defaultStyle.getBackground());
	}

}
