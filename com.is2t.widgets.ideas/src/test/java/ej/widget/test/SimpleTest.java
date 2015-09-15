/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.widget.Element;
import ej.widget.Style;
import ej.widget.cascading.CascadingStylesheet;
import ej.widget.test.env.SimpleElement;

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
		Element element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style stylesheetStyle = stylesheet.getStyle(element);
		CheckHelper.check(getClass(), "Complete default style", StyleHelper.isComplete(stylesheetStyle));

		return stylesheetStyle;
	}

	private void checkSetCompleteRenderableStyle() {
		Element element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createCompleteStyle();

		stylesheet.setStyle(element, style);
		checkSetCompleteStyle(element, stylesheet, style);
	}

	private void checkSetIncompleteRenderableStyle(Style defaultStyle) {
		Element element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createForegroundStyle();

		stylesheet.setStyle(element, style);
		checkSetIncompleteStyle(defaultStyle, element, stylesheet, style);
	}

	private void checkSetCompleteTypeStyle() {
		Element element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createCompleteStyle();

		stylesheet.setStyle(element.getClass(), style);
		checkSetCompleteStyle(element, stylesheet, style);
	}

	private void checkSetIncompleteTypeStyle(Style defaultStyle) {
		Element element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style style = createForegroundStyle();

		stylesheet.setStyle(element.getClass(), style);
		checkSetIncompleteStyle(defaultStyle, element, stylesheet, style);
	}

	private void checkSetCompleteStyle(Element element, CascadingStylesheet stylesheet, Style style) {
		Style stylesheetStyle = stylesheet.getStyle(element);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, style);
	}

	private void checkSetIncompleteStyle(Style defaultStyle, Element element, CascadingStylesheet stylesheet,
			Style style) {
		Style stylesheetStyle = stylesheet.getStyle(element);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Set style", !style.equals(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getForegroundColor(),
				style.getForegroundColor());
		CheckHelper.check(getClass(), "Default style attribute", stylesheetStyle.getBackground(),
				defaultStyle.getBackground());
	}

}
