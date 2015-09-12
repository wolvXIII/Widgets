/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.cascading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.widget.Dimension;
import ej.widget.State;
import ej.widget.Style;
import ej.widget.Styled;
import ej.widget.Stylesheet;
import ej.widget.background.PlainBackground;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.NoBox;
import ej.widget.font.FontProfile;

public class CascadingStylesheet implements Stylesheet {

	private final Map<Class<?>, Styles> typeStyles;
	private final Map<Object, Styles> styles;
	private final Styles globalStyles;

	public CascadingStylesheet() {
		this.typeStyles = new HashMap<>();
		this.styles = new HashMap<>();
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
		defaultStyle.setTextAlign(GraphicsContext.HCENTER | GraphicsContext.VCENTER);
		defaultStyle.setDimension(Dimension.NO_DIMENSION);
		defaultStyle.setPadding(NoBox.NO_BOXING);
		defaultStyle.setBorder(Border.NO_BORDER);
		defaultStyle.setMargin(NoBox.NO_BOXING);
		return defaultStyle;
	}

	@Override
	public Style getStyle(Object object) {
		// long s = System.currentTimeMillis();
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
		// page parent
		if (getParentAndMerge(resultingStyle, object)) {
			return resultingStyle;
		}
		// global
		merge(resultingStyle, this.globalStyles.style);
		// TODO manage renderable inheritance?
		// System.out.println("Get simple style: " + (System.currentTimeMillis() - s) + "ms");
		return resultingStyle;
	}

	@Override
	public Style getStyle(Object object, List<String> classSelectors, List<State> states) {
		// long s = System.currentTimeMillis();
		CascadingStyle resultingStyle = new CascadingStyle();
		// instance: state then global
		Styles styles = getStyles(object);
		if (styles != null) {
			if (getAndMerge(classSelectors, states, resultingStyle, styles)) {
				return resultingStyle;
			}
			if (merge(resultingStyle, styles.style)) {
				return resultingStyle;
			}
		}
		// type: state then global
		styles = getStyles(object.getClass());
		if (styles != null) {
			if (getAndMerge(classSelectors, states, resultingStyle, styles)) {
				return resultingStyle;
			}
			if (merge(resultingStyle, styles.style)) {
				return resultingStyle;
			}
		}
		// page parent
		if (getParentAndMerge(resultingStyle, object)) {
			return resultingStyle;
		}
		// global
		if (getAndMerge(classSelectors, states, resultingStyle, this.globalStyles)) {
			return resultingStyle;
		}
		if (merge(resultingStyle, this.globalStyles.style)) {
			return resultingStyle;
		}
		// TODO manage renderable inheritance?
		// System.out.println("Get complex style: " + (System.currentTimeMillis() - s) + "ms");
		return resultingStyle;
	}

	private boolean getParentAndMerge(CascadingStyle resultingStyle, Object object) {
		Object parent = getParent(object);
		if (parent != null) {
			Style parentStyle;
			if (parent instanceof Styled) {
				Styled styledParent = (Styled) parent;
				parentStyle = getStyle(parent, styledParent.getClassSelectors(), styledParent.getStates());
			} else {
				parentStyle = getStyle(parent);
			}
			if (parentStyle != null) {
				return resultingStyle.inheritMerge(parentStyle);
			}
		}
		return false;
	}

	private Object getParent(Object object) {
		// FIXME expose getStyle(Widget), getStyle(Panel) & getStyle(Desktop) instead of getStyle(Renderable)
		// if (object instanceof Widget) {
		// Widget widget = (Widget) object;
		// Composite parent = widget.getParent();
		// if (parent != null) {
		// return parent;
		// } else {
		// return widget.getPanel();
		// }
		// } else if (object instanceof Panel) {
		// Panel panel = (Panel) object;
		// return panel.getDesktop();
		// }
		// return null;

		// FIXME expose getStyle(Styled) instead of getStyle(Object)
		if (object instanceof Styled) {
			Styled styled = (Styled) object;
			return styled.getParentElement();
		}
		return null;
	}

	private boolean getAndMerge(List<String> classSelectors, List<State> states, CascadingStyle resultingStyle,
			Styles styles) {
		for (SelectorStyle selectorStyle : styles.selectorsStyles) {
			if (selectorStyle.selector.fit(classSelectors, states)) {
				CascadingStyle stateStyle = selectorStyle.style;
				if (merge(resultingStyle, stateStyle)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean merge(CascadingStyle resultingStyle, Style style) {
		if (style != null) {
			return resultingStyle.merge(style);
		}
		return false;
	}

	// @Override
	// public void setDefaultStyle(Style style) {
	// // validate that default style is complete
	// if (!CascadingHelper.isComplete(style)) {
	// throw new IllegalArgumentException();
	// }
	// this.defaultStyle = style;
	// }

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
		Styles styles = this.globalStyles;
		overrideIn(style, styles);
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
