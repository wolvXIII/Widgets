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

public class SelectorsTest extends StyledWidgetTest {

	private static final String WARNING = "warning";

	public static void main(String[] args) {
		new SelectorsTest().run();
	}

	@Override
	protected void check() {
		long s = System.currentTimeMillis();
		checkAll(true);
		checkAll(false);
		System.out.println("SelectorsTest.check() " + (System.currentTimeMillis() - s) + "ms");
	}

	private void checkAll(boolean hoverBeforeWarning) {
		checkSetStyle(true, true, true, hoverBeforeWarning);
		checkSetStyle(true, true, false, hoverBeforeWarning);
		checkSetStyle(true, false, true, hoverBeforeWarning);
		checkSetStyle(true, false, false, hoverBeforeWarning);
		checkSetStyle(false, false, false, hoverBeforeWarning);
		checkSetStyle(false, false, true, hoverBeforeWarning);
		checkSetStyle(false, true, false, hoverBeforeWarning);
		checkSetStyle(false, true, true, hoverBeforeWarning);
	}

	private void checkSetStyle(boolean onRenderable1, boolean onRenderable2, boolean onRenderable3,
			boolean hoverBeforeWarning) {
		SelectorsWidget renderable = new SelectorsWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style widgetStyle = createCompleteStyle();
		Style hoverStyle = createForegroundBackgroundStyle(Colors.YELLOW, Colors.NAVY);
		Style warningStyle = createForegroundBackgroundStyle(Colors.MAGENTA, Colors.GREEN);

		addWidgetStyle(onRenderable1, renderable, stylesheet, widgetStyle);
		if (hoverBeforeWarning) {
			addHoverStyle(onRenderable2, renderable, stylesheet, hoverStyle);
			addWarningStyle(onRenderable3, renderable, stylesheet, warningStyle);
		} else {
			addWarningStyle(onRenderable3, renderable, stylesheet, warningStyle);
			addHoverStyle(onRenderable2, renderable, stylesheet, hoverStyle);
		}
		List<State> states = new ArrayList<>();
		List<String> classSelectors = new ArrayList<>();

		Style stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, widgetStyle);
		check("Style", stylesheetStyle, widgetStyle);

		states.add(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		if (onRenderable2 || (!onRenderable1)) {
			check("Hover", stylesheetStyle, hoverStyle);
		} else {
			check("Style", stylesheetStyle, widgetStyle);
		}

		states.remove(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		check("Style", stylesheetStyle, widgetStyle);

		classSelectors.add(WARNING);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		if (onRenderable3 || (!onRenderable1)) {
			check(WARNING, stylesheetStyle, warningStyle);
		} else {
			check("Style", stylesheetStyle, widgetStyle);
		}

		states.add(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		if (onRenderable1 && !onRenderable2 && !onRenderable3) {
			check("Style", stylesheetStyle, widgetStyle);
		} else if (hoverBeforeWarning && onRenderable2 == onRenderable3) {
			// warning is added after hover selector
			check("Warning", stylesheetStyle, warningStyle);
		} else if (onRenderable2 && !onRenderable3) {
			// on renderable is preferred over on type
			check("Hover", stylesheetStyle, hoverStyle);
		} else if (!hoverBeforeWarning && onRenderable2 == onRenderable3) {
			// hover is added after hover selector
			check("Hover", stylesheetStyle, hoverStyle);
		} else if (!onRenderable2 && onRenderable3) {
			// on renderable is preferred over on type
			check("Warning", stylesheetStyle, warningStyle);
		} else if (onRenderable3 && !onRenderable2) {
			check(WARNING, stylesheetStyle, warningStyle);
		}

		classSelectors.remove(WARNING);
		states.remove(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable, classSelectors, states);
		check("Style", stylesheetStyle, widgetStyle);
	}

	private void addWarningStyle(boolean onRenderable3, SelectorsWidget renderable, CascadingStylesheet stylesheet,
			Style warningStyle) {
		if (onRenderable3) {
			stylesheet.setStyle(renderable, WARNING, warningStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), WARNING, warningStyle);
		}
	}

	private void addHoverStyle(boolean onRenderable2, SelectorsWidget renderable, CascadingStylesheet stylesheet,
			Style hoverStyle) {
		if (onRenderable2) {
			stylesheet.setStyle(renderable, State.Hover, hoverStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), State.Hover, hoverStyle);
		}
	}

	private void addWidgetStyle(boolean onRenderable1, SelectorsWidget renderable, CascadingStylesheet stylesheet,
			Style widgetStyle) {
		if (onRenderable1) {
			stylesheet.setStyle(renderable, widgetStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), widgetStyle);
		}
	}

	private void check(String message, Style stylesheetStyle, Style compareStyle) {
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), message + " foreground", stylesheetStyle.getForegroundColor(),
				compareStyle.getForegroundColor());
		CheckHelper.check(getClass(), message + " background", stylesheetStyle.getBackground(),
				compareStyle.getBackground());
	}

}
