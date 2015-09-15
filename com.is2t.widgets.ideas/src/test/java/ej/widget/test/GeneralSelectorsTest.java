/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.display.Colors;
import ej.widget.State;
import ej.widget.Style;
import ej.widget.cascading.CascadingStylesheet;
import ej.widget.test.env.SimpleElement;

public class GeneralSelectorsTest extends StyledWidgetTest {

	private static final String WARNING = "warning";

	public static void main(String[] args) {
		new GeneralSelectorsTest().run();
	}

	@Override
	protected void check() {
		long s = System.currentTimeMillis();
		checkAll(true);
		checkAll(false);
		System.out.println("GeneralSelectorsTest.check() " + (System.currentTimeMillis() - s) + "ms");
	}

	private void checkAll(boolean hoverBeforeWarning) {
		SimpleElement element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style widgetStyle = createCompleteStyle();
		Style hoverStyle = createForegroundBackgroundStyle(Colors.YELLOW, Colors.NAVY);
		Style warningStyle = createForegroundBackgroundStyle(Colors.MAGENTA, Colors.GREEN);

		addWidgetStyle(stylesheet, widgetStyle);
		if (hoverBeforeWarning) {
			addHoverStyle(stylesheet, hoverStyle);
			addWarningStyle(stylesheet, warningStyle);
		} else {
			addWarningStyle(stylesheet, warningStyle);
			addHoverStyle(stylesheet, hoverStyle);
		}

		Style stylesheetStyle = stylesheet.getStyle(element);
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, widgetStyle);
		check("Style", stylesheetStyle, widgetStyle);

		element.addState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		check("Hover", stylesheetStyle, hoverStyle);

		element.removeState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		check("Style", stylesheetStyle, widgetStyle);

		element.addClassSelector(WARNING);
		stylesheetStyle = stylesheet.getStyle(element);
		check(WARNING, stylesheetStyle, warningStyle);

		element.addState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		if (hoverBeforeWarning) {
			check("Warning", stylesheetStyle, warningStyle);
		} else {
			check("Hover", stylesheetStyle, hoverStyle);
		}

		element.removeClassSelector(WARNING);
		element.removeState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		check("Style", stylesheetStyle, widgetStyle);
	}

	private void addWarningStyle(CascadingStylesheet stylesheet, Style warningStyle) {
		stylesheet.setStyle(WARNING, warningStyle);
	}

	private void addHoverStyle(CascadingStylesheet stylesheet, Style hoverStyle) {
		stylesheet.setStyle(State.Hover, hoverStyle);
	}

	private void addWidgetStyle(CascadingStylesheet stylesheet, Style widgetStyle) {
		stylesheet.setStyle(widgetStyle);
	}

	private void check(String message, Style stylesheetStyle, Style compareStyle) {
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), message + " foreground", stylesheetStyle.getForegroundColor(),
				compareStyle.getForegroundColor());
		CheckHelper.check(getClass(), message + " background", stylesheetStyle.getBackground(),
				compareStyle.getBackground());
	}

}
