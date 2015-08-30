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

import ej.microui.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Composite;
import ej.mwt.Panel;
import ej.mwt.Renderable;
import ej.mwt.Widget;
import ej.widget.Dimension;
import ej.widget.State;
import ej.widget.Style;
import ej.widget.Styled;
import ej.widget.Stylesheet;
import ej.widget.background.PlainBackground;
import ej.widget.boxmodel.Border;
import ej.widget.boxmodel.NoBoxing;
import ej.widget.font.FontProfile;

public class CascadingStylesheet implements Stylesheet {

	private final Map<Class<? extends Renderable>, Styles> renderableTypeStyles;
	private final Map<Renderable, Styles> renderableStyles;
	private Style defaultStyle;

	public CascadingStylesheet() {
		this.renderableTypeStyles = new HashMap<>();
		this.renderableStyles = new HashMap<>();
		this.defaultStyle = createDefaultStyle();
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
		defaultStyle.setPadding(NoBoxing.NO_BOXING);
		defaultStyle.setBorder(Border.NO_BORDER);
		defaultStyle.setMargin(NoBoxing.NO_BOXING);
		return defaultStyle;
	}

	@Override
	public Style getStyle(Renderable renderable) {
		// long s = System.currentTimeMillis();
		CascadingStyle resultingStyle = new CascadingStyle();
		// instance
		Styles styles = getStyles(renderable);
		if (merge(resultingStyle, styles.style)) {
			return resultingStyle;
		}
		// type
		styles = getStyles(renderable.getClass());
		if (merge(resultingStyle, styles.style)) {
			return resultingStyle;
		}
		// page parent
		if (getParentAndMerge(resultingStyle, renderable)) {
			return resultingStyle;
		}
		// default
		merge(resultingStyle, this.defaultStyle);
		// TODO manage renderable inheritance
		// System.out.println("Get simple style: " + (System.currentTimeMillis() - s) + "ms");
		return resultingStyle;
	}

	@Override
	public Style getStyle(Renderable renderable, List<String> classSelectors, List<State> states) {
		// long s = System.currentTimeMillis();
		CascadingStyle resultingStyle = new CascadingStyle();
		// Selector selector = new FullSelector(classSelectors, states);
		// instance: state then global
		Styles styles = getStyles(renderable);
		if (getAndMerge(classSelectors, states, resultingStyle, styles)) {
			return resultingStyle;
		}
		if (merge(resultingStyle, styles.style)) {
			return resultingStyle;
		}
		// type: state then global
		styles = getStyles(renderable.getClass());
		if (getAndMerge(classSelectors, states, resultingStyle, styles)) {
			return resultingStyle;
		}
		if (merge(resultingStyle, styles.style)) {
			return resultingStyle;
		}
		// page parent
		if (getParentAndMerge(resultingStyle, renderable)) {
			return resultingStyle;
		}
		// default
		merge(resultingStyle, this.defaultStyle);
		// TODO manage renderable inheritance
		// System.out.println("Get complex style: " + (System.currentTimeMillis() - s) + "ms");
		return resultingStyle;
	}

	private boolean getParentAndMerge(CascadingStyle resultingStyle, Renderable renderable) {
		Renderable parent = getParent(renderable);
		if (parent != null) {
			// TODO manage parent selectors
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

	private Renderable getParent(Renderable renderable) {
		// FIXME expose getStyle(Widget), getStyle(Panel) & getStyle(Desktop) instead of getStyle(Renderable)
		if (renderable instanceof Widget) {
			Widget widget = (Widget) renderable;
			Composite parent = widget.getParent();
			if (parent != null) {
				return parent;
			} else {
				return widget.getPanel();
			}
		} else if (renderable instanceof Panel) {
			Panel panel = (Panel) renderable;
			return panel.getDesktop();
		}
		return null;
	}

	private boolean getAndMerge(List<String> classSelectors, List<State> states, CascadingStyle resultingStyle,
			Styles styles) {
		for (Selector selector : styles.selectorStyles.keySet()) {
			if (selector.fit(classSelectors, states)) {
				CascadingStyle stateStyle = styles.selectorStyles.get(selector);
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

	@Override
	public void setDefaultStyle(Style style) {
		// validate that default style is complete
		if (!CascadingHelper.isComplete(style)) {
			throw new IllegalArgumentException();
		}
		this.defaultStyle = style;
	}

	@Override
	public void setStyle(Class<? extends Renderable> renderableType, Style style) {
		Styles styles = getStyles(renderableType);
		mergeIn(style, styles);
	}

	@Override
	public void setStyle(Renderable renderable, Style style) {
		Styles styles = getStyles(renderable);
		mergeIn(style, styles);
	}

	private void mergeIn(Style style, Styles styles) {
		CascadingStyle registeredStyle = styles.style;
		if (registeredStyle == null) {
			registeredStyle = new CascadingStyle();
			styles.style = registeredStyle;
		}
		registeredStyle.override(style);
	}

	@Override
	public void setStyle(Class<? extends Renderable> renderableType, State state, Style style) {
		Styles styles = getStyles(renderableType);
		mergeIn(style, state, styles);
	}

	@Override
	public void setStyle(Renderable renderable, State state, Style style) {
		Styles styles = getStyles(renderable);
		mergeIn(style, state, styles);
	}

	private void mergeIn(Style style, State state, Styles styles) {
		Selector selector = new StateSelector(state);
		mergeIn(style, styles, selector);
	}

	@Override
	public void setStyle(Class<? extends Renderable> renderableType, String classSelector, Style style) {
		Styles styles = getStyles(renderableType);
		mergeIn(style, classSelector, styles);
	}

	@Override
	public void setStyle(Renderable renderable, String classSelector, Style style) {
		Styles styles = getStyles(renderable);
		mergeIn(style, classSelector, styles);
	}

	private void mergeIn(Style style, String classSelector, Styles styles) {
		Selector selector = new ClassSelector(classSelector);
		mergeIn(style, styles, selector);
	}

	@Override
	public void setStyle(Class<? extends Renderable> renderableType, List<String> classSelectors, List<State> states,
			Style style) {
		Styles styles = getStyles(renderableType);
		mergeIn(style, classSelectors, states, styles);
	}

	@Override
	public void setStyle(Renderable renderable, List<String> classSelectors, List<State> states, Style style) {
		Styles styles = getStyles(renderable);
		mergeIn(style, classSelectors, states, styles);
	}

	private void mergeIn(Style style, List<String> classSelectors, List<State> states, Styles styles) {
		Selector selector = new FullSelector(classSelectors, states);
		mergeIn(style, styles, selector);
	}

	private void mergeIn(Style style, Styles styles, Selector selector) {
		CascadingStyle registeredStyle = styles.selectorStyles.get(selector);
		if (registeredStyle == null) {
			registeredStyle = new CascadingStyle();
			styles.selectorStyles.put(selector, registeredStyle);
		}
		registeredStyle.merge(style);
	}

	private Styles getStyles(Class<? extends Renderable> renderableType) {
		Styles styles = this.renderableTypeStyles.get(renderableType);
		if (styles == null) {
			styles = new Styles();
			this.renderableTypeStyles.put(renderableType, styles);
		}
		return styles;
	}

	private Styles getStyles(Renderable renderable) {
		Styles styles = this.renderableStyles.get(renderable);
		if (styles == null) {
			styles = new Styles();
			this.renderableStyles.put(renderable, styles);
		}
		return styles;
	}

	class Styles {
		private CascadingStyle style;
		private final Map<Selector, CascadingStyle> selectorStyles;

		public Styles() {
			this.selectorStyles = new HashMap<>();
		}
	}

	interface Selector {
		boolean fit(List<String> classSelectors, List<State> states);
	}

	class FullSelector implements Selector {
		private final List<String> classSelectors;
		private final List<State> states;

		public FullSelector(List<String> classSelectors, List<State> states) {
			this.classSelectors = classSelectors;
			this.states = states;
			System.out.println("CascadingStylesheet.FullSelector.FullSelector()");
			for (State state : states) {
				System.out.println(state);
			}
		}

		@Override
		public boolean fit(List<String> classSelectors, List<State> states) {
			// check that all the classes & states of this selector are available in the given classes & states
			for (String classSelector : this.classSelectors) {
				if (!classSelectors.contains(classSelector)) {
					return false;
				}
			}
			for (State state : this.states) {
				if (!states.contains(state)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof FullSelector) {
				FullSelector other = (FullSelector) obj;
				// FIXME list comparison works?
				return this.classSelectors.equals(other.classSelectors) && this.states.equals(other.states);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return this.classSelectors.hashCode() + this.states.hashCode();
		}
	}

	class ClassSelector implements Selector {
		private final String classSelector;

		public ClassSelector(String classSelector) {
			this.classSelector = classSelector;
		}

		@Override
		public boolean fit(List<String> classSelectors, List<State> states) {
			return classSelectors.contains(this.classSelector);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ClassSelector) {
				ClassSelector other = (ClassSelector) obj;
				return this.classSelector.equals(other.classSelector);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return this.classSelector.hashCode();
		}
	}

	class StateSelector implements Selector {
		private final State state;

		public StateSelector(State state) {
			this.state = state;
		}

		@Override
		public boolean fit(List<String> classSelectors, List<State> states) {
			return states.contains(this.state);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof StateSelector) {
				StateSelector other = (StateSelector) obj;
				return this.state.equals(other.state);
			}
			return false;
		}

		@Override
		public int hashCode() {
			return this.state.hashCode();
		}
	}

}
