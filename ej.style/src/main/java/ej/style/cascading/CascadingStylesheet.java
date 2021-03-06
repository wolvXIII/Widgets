/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style.cascading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import ej.microui.display.Colors;
import ej.style.Element;
import ej.style.State;
import ej.style.Style;
import ej.style.Stylesheet;
import ej.style.background.PlainBackground;
import ej.style.dimension.NoDimension;
import ej.style.font.FontProfile;
import ej.style.outline.Border;
import ej.style.outline.EmptyOutline;
import ej.style.text.TextManagerFull;
import ej.style.util.StyleHelper;

/**
 * Style sheet that manage a cascading resolution of the style.
 */
public class CascadingStylesheet implements Stylesheet {

	private final Map<Class<?>, Styles> typeStyles;
	private final Map<Object, Styles> styles;
	private final Styles globalStyles;

	/**
	 * Creates a new cascading style sheet.
	 */
	public CascadingStylesheet() {
		this.typeStyles = new HashMap<>();
		this.styles = new WeakHashMap<>();
		this.globalStyles = new Styles();
		this.globalStyles.style = createDefaultStyle();
	}

	private CascadingStyle createDefaultStyle() {
		CascadingStyle defaultStyle = new CascadingStyle();
		defaultStyle.setForegroundColor(Colors.BLACK);
		PlainBackground background = new PlainBackground();
		background.setColor(Colors.WHITE);
		defaultStyle.setBackground(background);
		defaultStyle.setFontProfile(new FontProfile());
		defaultStyle.setTextManager(new TextManagerFull());
		defaultStyle.setDimension(NoDimension.NO_DIMENSION);
		defaultStyle.setPadding(EmptyOutline.EMPTY_OUTLINE);
		defaultStyle.setBorder(Border.NO_BORDER);
		defaultStyle.setMargin(EmptyOutline.EMPTY_OUTLINE);
		return defaultStyle;
	}

	@Override
	public Style getStyle(Object object) {
		CascadingStyle resultingStyle = new CascadingStyle();

		// instance
		Styles styles = getStyles(object);
		if (styles != null && merge(resultingStyle, styles.style)) {
			return resultingStyle;
		}

		// type
		styles = getStyles(object.getClass());
		if (styles != null && merge(resultingStyle, styles.style)) {
			return resultingStyle;
		}

		// no page parent resolution

		// global
		merge(resultingStyle, this.globalStyles.style);

		return resultingStyle;
	}

	@Override
	public Style getStyle(Element element) {
		List<String> classSelectors = element.getClassSelectors();
		List<State> states = element.getStates();
		CascadingStyle resultingStyle = new CascadingStyle();

		// instance
		Styles styles = getStyles(element);
		if (styles != null) {
			if (getAndMerge(classSelectors, states, resultingStyle, styles)) {
				return resultingStyle;
			}
		}

		// type
		styles = getStyles(element.getClass());
		if (styles != null) {
			if (getAndMerge(classSelectors, states, resultingStyle, styles)) {
				return resultingStyle;
			}
		}

		// page parent
		if (getParentAndMerge(resultingStyle, element)) {
			return resultingStyle;
		}

		// global
		if (getAndMerge(classSelectors, states, resultingStyle, this.globalStyles)) {
			return resultingStyle;
		}

		return resultingStyle;
	}

	private boolean getParentAndMerge(CascadingStyle resultingStyle, Element element) {
		Object parent = element.getParentElement();
		if (parent != null) {
			Style parentStyle;
			if (parent instanceof Element) {
				parentStyle = getStyle((Element) parent);
			} else {
				parentStyle = getStyle(parent);
			}
			if (parentStyle != null) {
				return resultingStyle.inheritMerge(parentStyle);
			}
		}
		return false;
	}

	private boolean getAndMerge(List<String> classSelectors, List<State> states, CascadingStyle resultingStyle,
			Styles styles) {
		// apply selectors…
		for (SelectorStyle selectorStyle : styles.selectorsStyles) {
			if (selectorStyle.selector.fit(classSelectors, states)) {
				CascadingStyle stateStyle = selectorStyle.style;
				if (merge(resultingStyle, stateStyle)) {
					return true;
				}
			}
		}
		// …then global
		if (merge(resultingStyle, styles.style)) {
			return true;
		}
		return false;
	}

	private boolean merge(CascadingStyle resultingStyle, Style style) {
		if (style != null) {
			return resultingStyle.merge(style);
		}
		return false;
	}

	@Override
	public void setStyle(Class<?> type, Style style) {
		Styles styles = getOrCreateStyles(type);
		overrideIn(style, styles);
	}

	@Override
	public void setStyle(Object object, Style style) {
		Styles styles = getOrCreateStyles(object);
		overrideIn(style, styles);
	}

	private void overrideIn(Style style, Styles styles) {
		CascadingStyle registeredStyle = styles.style;
		if (registeredStyle == null) {
			registeredStyle = new CascadingStyle();
			styles.style = registeredStyle;
		}
		registeredStyle.override(style);
	}

	@Override
	public void setStyle(Class<?> type, State state, Style style) {
		Styles styles = getOrCreateStyles(type);
		overrideIn(style, state, styles);
	}

	@Override
	public void setStyle(Object object, State state, Style style) {
		Styles styles = getOrCreateStyles(object);
		overrideIn(style, state, styles);
	}

	private void overrideIn(Style style, State state, Styles styles) {
		Selector selector = new StateSelector(state);
		overrideIn(style, styles, selector);
	}

	@Override
	public void setStyle(Class<?> type, String classSelector, Style style) {
		Styles styles = getOrCreateStyles(type);
		overrideIn(style, classSelector, styles);
	}

	@Override
	public void setStyle(Object object, String classSelector, Style style) {
		Styles styles = getOrCreateStyles(object);
		overrideIn(style, classSelector, styles);
	}

	private void overrideIn(Style style, String classSelector, Styles styles) {
		Selector selector = new ClassSelector(classSelector);
		overrideIn(style, styles, selector);
	}

	@Override
	public void setStyle(Class<?> type, List<String> classSelectors, List<State> states, Style style) {
		Styles styles = getOrCreateStyles(type);
		overrideIn(style, classSelectors, states, styles);
	}

	@Override
	public void setStyle(Object object, List<String> classSelectors, List<State> states, Style style) {
		Styles styles = getOrCreateStyles(object);
		overrideIn(style, classSelectors, states, styles);
	}

	@Override
	public void setStyle(Style style) {
		if (!StyleHelper.isComplete(style)) {
			throw new IllegalArgumentException();
		}
		Styles styles = this.globalStyles;
		overrideIn(style, styles);
	}

	@Override
	public void setStyle(State state, Style style) {
		Styles styles = this.globalStyles;
		overrideIn(style, state, styles);
	}

	@Override
	public void setStyle(String classSelector, Style style) {
		Styles styles = this.globalStyles;
		overrideIn(style, classSelector, styles);
	}

	@Override
	public void setStyle(List<String> classSelectors, List<State> states, Style style) {
		Styles styles = this.globalStyles;
		overrideIn(style, classSelectors, states, styles);
	}

	private void overrideIn(Style style, List<String> classSelectors, List<State> states, Styles styles) {
		Selector selector = new FullSelector(classSelectors, states);
		overrideIn(style, styles, selector);
	}

	private void overrideIn(Style style, Styles styles, Selector selector) {
		styles.overrideIn(style, selector);
	}

	private Styles getOrCreateStyles(Class<?> type) {
		Styles styles = getStyles(type);
		if (styles == null) {
			styles = new Styles();
			this.typeStyles.put(type, styles);
		}
		return styles;
	}

	private Styles getStyles(Class<?> type) {
		return this.typeStyles.get(type);
	}

	private Styles getOrCreateStyles(Object object) {
		Styles styles = getStyles(object);
		if (styles == null) {
			styles = new Styles();
			this.styles.put(object, styles);
		}
		// System.out.println("CascadingStylesheet.getOrCreateStyles() " + styles);
		return styles;
	}

	private Styles getStyles(Object object) {
		return this.styles.get(object);
	}

}
