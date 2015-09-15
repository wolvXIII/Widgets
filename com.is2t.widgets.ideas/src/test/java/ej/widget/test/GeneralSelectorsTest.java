/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import java.util.ArrayList;
import java.util.List;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.display.Colors;
import ej.widget.State;
import ej.widget.Style;
import ej.widget.cascading.CascadingStylesheet;
import ej.widget.test.env.SelectorsWidget;

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
		SelectorsWidget renderable = new SelectorsWidget();
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
		List<State> states = new ArrayList<>();
		List<String> classSelectors = new ArrayList<>();

		Style stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, widgetStyle);
		check("Style", stylesheetStyle, widgetStyle);

		states.add(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		check("Hover", stylesheetStyle, hoverStyle);

		states.remove(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		check("Style", stylesheetStyle, widgetStyle);

		classSelectors.add(WARNING);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		check(WARNING, stylesheetStyle, warningStyle);

		states.add(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		if (hoverBeforeWarning) {
			check("Warning", stylesheetStyle, warningStyle);
		} else {
			check("Hover", stylesheetStyle, hoverStyle);
		}

		classSelectors.remove(WARNING);
		states.remove(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
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
