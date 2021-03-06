/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.test;

import com.is2t.testsuite.support.CheckHelper;

import ej.style.Element;
import ej.style.Style;
import ej.style.cascading.CascadingStylesheet;
import ej.style.test.framework.Test;
import ej.style.test.framework.element.SimpleElement;
import ej.style.util.StyleHelper;

public class InheritanceTest extends Test {

	public static void main(String[] args) {
		new InheritanceTest().start();
	}

	@Override
	protected void run() {
		checkSetRenderableRenderableStyle();
		checkSetRenderableTypeStyle();
		checkSetTypeRenderableStyle();
		checkSetTypeTypeStyle();
	}

	private void checkSetRenderableRenderableStyle() {
		Element parent = new SimpleElement();
		Element element = new SimpleElement(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(element, renderableStyle);
		stylesheet.setStyle(parent, parentStyle);
		checkSetStyle(element, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetRenderableTypeStyle() {
		Element parent = new SimpleElement();
		Element element = new SimpleElement(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(element, renderableStyle);
		stylesheet.setStyle(parent.getClass(), parentStyle);
		checkSetStyle(element, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetTypeRenderableStyle() {
		Element parent = new SimpleElement();
		Element element = new SimpleElement(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(element.getClass(), renderableStyle);
		stylesheet.setStyle(parent, parentStyle);
		checkSetStyle(element, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetTypeTypeStyle() {
		Element parent = new SimpleElement();
		Element element = new SimpleElement(parent);
		CascadingStylesheet stylesheet = new CascadingStylesheet();

		Style parentStyle = createForegroundStyle();
		Style renderableStyle = createBackgroundStyle();

		stylesheet.setStyle(element.getClass(), renderableStyle);
		stylesheet.setStyle(parent.getClass(), parentStyle);
		checkSetStyle(element, stylesheet, parentStyle, renderableStyle);
	}

	private void checkSetStyle(Element renderable, CascadingStylesheet stylesheet, Style parentStyle,
			Style renderableStyle) {
		Style stylesheetStyle = stylesheet.getStyle(renderable);
		CheckHelper.check(getClass(), "Complete style", StyleHelper.isComplete(stylesheetStyle));
		CheckHelper.check(getClass(), "Style attribute", stylesheetStyle.getBackground(),
				renderableStyle.getBackground());
		CheckHelper.check(getClass(), "Parent attribute", stylesheetStyle.getForegroundColor(),
				parentStyle.getForegroundColor());
	}

}
