/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.test;

import java.util.ArrayList;
import java.util.List;

import com.is2t.testsuite.support.CheckHelper;

import ej.style.Element;
import ej.style.State;
import ej.style.Style;
import ej.style.Stylesheet;
import ej.style.cascading.CascadingStylesheet;
import ej.style.test.framework.Test;

public class WeakTest extends Test {

	private static final String CLASS_SELECTOR = "AAA";

	public static void main(String[] args) {
		new WeakTest().start();
	}

	@Override
	protected void run() {
		checkElement();
		checkElementSelectors();
		checkObject();
	}

	private void checkElement() {
		Stylesheet stylesheet = new CascadingStylesheet();
		MyElement myElement = new MyElement();
		Style defaultStyle = stylesheet.getStyle(myElement);

		Style style = createCompleteStyle();

		registerElementStyle(stylesheet, style);
		Style stylesheetStyle = stylesheet.getStyle(myElement);
		CheckHelper.check(getClass(), "Element rule set", stylesheetStyle, style);
		CheckHelper.check(getClass(), "Element rule set: not default", !stylesheetStyle.equals(defaultStyle));

		// clean reference to the instance of MyElement created in registerStyle()
		System.gc();

		stylesheetStyle = stylesheet.getStyle(myElement);

		CheckHelper.check(getClass(), "Element rule removed", !stylesheetStyle.equals(style));
		CheckHelper.check(getClass(), "Element rule removed: default", stylesheetStyle, defaultStyle);
	}

	private void registerElementStyle(Stylesheet stylesheet, Style style) {
		MyElement myElement = new MyElement();
		stylesheet.setStyle(myElement, style);
	}

	private void checkElementSelectors() {
		Stylesheet stylesheet = new CascadingStylesheet();
		MyElement myElement = new MyElement();
		Style defaultStyle = stylesheet.getStyle(myElement);

		Style style = createCompleteStyle();

		registerElementSelectorsStyle(stylesheet, style);
		Style stylesheetStyle = stylesheet.getStyle(myElement);
		CheckHelper.check(getClass(), "Element selectors rule set", stylesheetStyle, style);
		CheckHelper.check(getClass(), "Element selectors rule set: not default", !stylesheetStyle.equals(defaultStyle));

		// clean reference to the instance of MyElement created in registerStyle()
		System.gc();

		stylesheetStyle = stylesheet.getStyle(myElement);

		CheckHelper.check(getClass(), "Element selectors rule removed", !stylesheetStyle.equals(style));
		CheckHelper.check(getClass(), "Element selectors rule removed: default", stylesheetStyle, defaultStyle);
	}

	private void registerElementSelectorsStyle(Stylesheet stylesheet, Style style) {
		MyElement myElement = new MyElement();
		List<State> states = new ArrayList<>();
		states.add(State.Active);
		List<String> classSelectors = new ArrayList<>();
		classSelectors.add(CLASS_SELECTOR);
		stylesheet.setStyle(myElement, classSelectors, states, style);
	}

	private void checkObject() {
		Stylesheet stylesheet = new CascadingStylesheet();
		MyObject myObject = new MyObject();
		Style defaultStyle = stylesheet.getStyle(myObject);

		Style style = createCompleteStyle();

		registerObjectStyle(stylesheet, style);
		Style stylesheetStyle = stylesheet.getStyle(myObject);
		CheckHelper.check(getClass(), "Object rule set", stylesheetStyle, style);
		CheckHelper.check(getClass(), "Object rule set: not default", !stylesheetStyle.equals(defaultStyle));

		// clean reference to the instance of MyObject created in registerStyle()
		System.gc();

		stylesheetStyle = stylesheet.getStyle(myObject);

		CheckHelper.check(getClass(), "Object rule removed", !stylesheetStyle.equals(style));
		CheckHelper.check(getClass(), "Object rule removed: default", stylesheetStyle, defaultStyle);
	}

	private void registerObjectStyle(Stylesheet stylesheet, Style style) {
		MyObject myObject = new MyObject();
		stylesheet.setStyle(myObject, style);
	}

	class MyElement implements Element {

		private final List<State> states;
		private final List<String> classSelectors;

		public MyElement() {
			this.states = new ArrayList<>();
			this.states.add(State.Active);
			this.classSelectors = new ArrayList<String>();
			this.classSelectors.add(CLASS_SELECTOR);
		}

		@Override
		public boolean equals(Object obj) {
			return true;
		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public List<String> getClassSelectors() {
			return this.classSelectors;
		}

		@Override
		public List<State> getStates() {
			return this.states;
		}

		@Override
		public Object getParentElement() {
			return null;
		}

	}

	class MyObject {

		@Override
		public boolean equals(Object obj) {
			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

	}

}
