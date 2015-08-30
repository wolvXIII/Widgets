/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.mwt.Composite;
import ej.mwt.Widget;
import ej.widget.Style;
import ej.widget.cascading.CascadingStylesheet;
import ej.widget.test.env.ParentedWidget;
import ej.widget.test.env.SimpleComposite;

public class InheritanceTest extends StyledWidgetTest {

	public static void main(String[] args) {
		new InheritanceTest().run();
	}

	@Override
	protected void check() {
		checkSetRenderableRenderableStyle();
		checkSetRenderableTypeStyle();
		checkSetTypeRenderableStyle();
		checkSetTypeTypeStyle();
	}

	private void checkSetRenderableRenderableStyle() {
		Composite parent = new SimpleComposite();
		Widget renderable = new ParentedWidget(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(renderable, renderableStyle);
		stylesheet.setStyle(parent, parentStyle);
		checkSetStyle(renderable, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetRenderableTypeStyle() {
		Composite parent = new SimpleComposite();
		Widget renderable = new ParentedWidget(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(renderable, renderableStyle);
		stylesheet.setStyle(parent.getClass(), parentStyle);
		checkSetStyle(renderable, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetTypeRenderableStyle() {
		Composite parent = new SimpleComposite();
		Widget renderable = new ParentedWidget(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(renderable.getClass(), renderableStyle);
		stylesheet.setStyle(parent, parentStyle);
		checkSetStyle(renderable, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetTypeTypeStyle() {
		Composite parent = new SimpleComposite();
		Widget renderable = new ParentedWidget(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(renderable.getClass(), renderableStyle);
		stylesheet.setStyle(parent.getClass(), parentStyle);
		checkSetStyle(renderable, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetStyle(Widget renderable, CascadingStylesheet stylesheet, Style parentStyle,
			Style renderableStyle) {
		Style stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getBackground(),
				renderableStyle.getBackground());
		CheckHelper.check(getClass(), "Parent attribute", stylesheetStyle.getForegroundColor(),
				parentStyle.getForegroundColor());
	}

}
