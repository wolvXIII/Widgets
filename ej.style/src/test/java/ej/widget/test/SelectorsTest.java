/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.microui.display.Colors;
import ej.style.State;
import ej.style.Style;
import ej.style.cascading.CascadingStylesheet;
import ej.widget.test.env.SimpleElement;

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
		SimpleElement element = new SimpleElement();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style widgetStyle = createCompleteStyle();
		Style hoverStyle = createForegroundBackgroundStyle(Colors.YELLOW, Colors.NAVY);
		Style warningStyle = createForegroundBackgroundStyle(Colors.MAGENTA, Colors.GREEN);

		addWidgetStyle(onRenderable1, element, stylesheet, widgetStyle);
		if (hoverBeforeWarning) {
			addHoverStyle(onRenderable2, element, stylesheet, hoverStyle);
			addWarningStyle(onRenderable3, element, stylesheet, warningStyle);
		} else {
			addWarningStyle(onRenderable3, element, stylesheet, warningStyle);
			addHoverStyle(onRenderable2, element, stylesheet, hoverStyle);
		}

		Style stylesheetStyle = stylesheet.getStyle(element);
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, widgetStyle);
		check("Style 0", stylesheetStyle, widgetStyle);

		element.addState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		if (onRenderable2 || (!onRenderable1)) {
			check("Hover 1", stylesheetStyle, hoverStyle);
		} else {
			check("Style 1", stylesheetStyle, widgetStyle);
		}

		element.removeState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		check("Style 2", stylesheetStyle, widgetStyle);

		element.addClassSelector(WARNING);
		stylesheetStyle = stylesheet.getStyle(element);
		if (onRenderable3 || (!onRenderable1)) {
			check("Warning 3", stylesheetStyle, warningStyle);
		} else {
			check("Style 3", stylesheetStyle, widgetStyle);
		}

		element.addState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		if (onRenderable1 && !onRenderable2 && !onRenderable3) {
			check("Style 4", stylesheetStyle, widgetStyle);
		} else if (hoverBeforeWarning && onRenderable2 == onRenderable3) {
			// warning is added after hover selector
			check("Warning 4", stylesheetStyle, warningStyle);
		} else if (onRenderable2 && !onRenderable3) {
			// on renderable is preferred over on type
			check("Hover 4", stylesheetStyle, hoverStyle);
		} else if (!hoverBeforeWarning && onRenderable2 == onRenderable3) {
			// hover is added after hover selector
			check("Hover 5", stylesheetStyle, hoverStyle);
		} else if (!onRenderable2 && onRenderable3) {
			// on renderable is preferred over on type
			check("Warning 5", stylesheetStyle, warningStyle);
		} else if (onRenderable3 && !onRenderable2) {
			check("Warning 5", stylesheetStyle, warningStyle);
		}

		element.removeClassSelector(WARNING);
		element.removeState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(element);
		check("Style 6", stylesheetStyle, widgetStyle);
	}

	private void addWarningStyle(boolean onRenderable3, SimpleElement renderable, CascadingStylesheet stylesheet,
			Style warningStyle) {
		if (onRenderable3) {
			stylesheet.setStyle(renderable, WARNING, warningStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), WARNING, warningStyle);
		}
	}

	private void addHoverStyle(boolean onRenderable2, SimpleElement renderable, CascadingStylesheet stylesheet,
			Style hoverStyle) {
		if (onRenderable2) {
			stylesheet.setStyle(renderable, State.Hover, hoverStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), State.Hover, hoverStyle);
		}
	}

	private void addWidgetStyle(boolean onRenderable1, SimpleElement renderable, CascadingStylesheet stylesheet,
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
