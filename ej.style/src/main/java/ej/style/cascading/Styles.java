/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.cascading;

import java.util.ArrayList;
import java.util.List;

import ej.style.Style;

class Styles {
	CascadingStyle style;
	// the list ensures the definition order
	final List<SelectorStyle> selectorsStyles;

	// final List<Selector> selectors;
	// final Map<Selector, CascadingStyle> selectorStyles;

	public Styles() {
		this.selectorsStyles = new ArrayList<>();
		// this.selectors = new ArrayList<>();
		// this.selectorStyles = new HashMap<>();
	}

	public void overrideIn(Style style, Selector selector) {
		int index = this.selectorsStyles.indexOf(selector);
		CascadingStyle registeredStyle;
		if (index == -1) {
			registeredStyle = new CascadingStyle();
			SelectorStyle selectorStyle = new SelectorStyle(selector, registeredStyle);
			// add the selector at the first place to ensure order (last added is resolved first)
			this.selectorsStyles.add(0, selectorStyle);
		} else {
			registeredStyle = this.selectorsStyles.get(index).style;
		}
		// CascadingStyle registeredStyle = this.selectorStyles.get(selector);
		// if (registeredStyle == null) {
		// registeredStyle = new CascadingStyle();
		// add the selector in the first place to ensure order (last added is resolved first)
		// this.selectors.add(0, selector);
		// this.selectorStyles.put(selector, registeredStyle);
		// // reset cache
		// this.entries = null;
		// }
		registeredStyle.override(style);
	}
}
