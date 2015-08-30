/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

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
		checkSetStyle(true, true, true);
		checkSetStyle(true, true, false);
		checkSetStyle(true, false, true);
		checkSetStyle(true, false, false);
		checkSetStyle(false, false, false);
		checkSetStyle(false, false, true);
		checkSetStyle(false, true, false);
		checkSetStyle(false, true, true);
	}

	private void checkSetStyle(boolean onRenderable1, boolean onRenderable2, boolean onRenderable3) {
		SelectorsWidget renderable = new SelectorsWidget();
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style widgetStyle = createCompleteStyle();
		Style hoverStyle = createBackgroundStyle();
		Style warningStyle = createForegroundStyle();

		if (onRenderable1) {
			stylesheet.setStyle(renderable, widgetStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), widgetStyle);
		}
		if (onRenderable2) {
			stylesheet.setStyle(renderable, State.Hover, hoverStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), State.Hover, hoverStyle);
		}
		if (onRenderable3) {
			stylesheet.setStyle(renderable, WARNING, warningStyle);
		} else {
			stylesheet.setStyle(renderable.getClass(), WARNING, warningStyle);
		}
		checkSetStyle(renderable, stylesheet, widgetStyle, hoverStyle, warningStyle);
	}

	private void checkSetStyle(SelectorsWidget renderable, CascadingStylesheet stylesheet, Style widgetStyle,
			Style hoverStyle, Style warningStyle) {
		Style stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Set style", stylesheetStyle, widgetStyle);
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getBackground(), widgetStyle.getBackground());
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getForegroundColor(),
				widgetStyle.getForegroundColor());

		renderable.addState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Hover attribute", stylesheetStyle.getBackground(), hoverStyle.getBackground());
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getForegroundColor(),
				widgetStyle.getForegroundColor());

		renderable.removeState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getBackground(), widgetStyle.getBackground());
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getForegroundColor(),
				widgetStyle.getForegroundColor());

		renderable.addClassSelector(WARNING);
		stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getBackground(), widgetStyle.getBackground());
		CheckHelper.check(getClass(), "Warning attribute", stylesheetStyle.getForegroundColor(),
				warningStyle.getForegroundColor());

		renderable.addState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Hover attribute", stylesheetStyle.getBackground(), hoverStyle.getBackground());
		CheckHelper.check(getClass(), "Warning attribute", stylesheetStyle.getForegroundColor(),
				warningStyle.getForegroundColor());

		renderable.removeClassSelector(WARNING);
		renderable.removeState(State.Hover);
		stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getBackground(), widgetStyle.getBackground());
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getForegroundColor(),
				widgetStyle.getForegroundColor());
	}

}
