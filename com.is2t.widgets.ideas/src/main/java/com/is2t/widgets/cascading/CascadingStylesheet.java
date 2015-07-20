/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.is2t.widgets.cascading;

import java.util.HashMap;
import java.util.Map;

import com.is2t.widgets.Dimension;
import com.is2t.widgets.State;
import com.is2t.widgets.Style;
import com.is2t.widgets.Stylesheet;
import com.is2t.widgets.background.PlainBackground;
import com.is2t.widgets.boxmodel.Border;
import com.is2t.widgets.boxmodel.NoBoxing;
import com.is2t.widgets.font.FontProfile;

import ej.microui.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Renderable;

public class CascadingStylesheet implements Stylesheet {

	private final Map<Class<? extends Renderable>, Styles> renderableTypeStyles;
	private final Map<Renderable, Styles> renderableStyles;
	private Style defaultStyle;

	public CascadingStylesheet() {
		this.renderableTypeStyles = new HashMap<Class<? extends Renderable>, Styles>();
		this.renderableStyles = new HashMap<Renderable, Styles>();
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
		CascadingStyle resultingStyle = new CascadingStyle();
		// instance
		Styles styles = getStyles(renderable);
		merge(resultingStyle, styles.style);
		// type
		styles = getStyles(renderable.getClass());
		merge(resultingStyle, styles.style);
		// default
		merge(resultingStyle, this.defaultStyle);
		// TODO manage page parent inheritance
		// TODO manage renderable inheritance
		// TODO stop merging up when style is complete?
		return resultingStyle;
	}

	@Override
	public Style getStyle(Renderable renderable, State state) {
		CascadingStyle resultingStyle = new CascadingStyle();
		// instance: state then global
		Styles styles = getStyles(renderable);
		CascadingStyle stateStyle = styles.stateStyles.get(state);
		merge(resultingStyle, stateStyle);
		merge(resultingStyle, styles.style);
		// type: state then global
		styles = getStyles(renderable.getClass());
		stateStyle = styles.stateStyles.get(state);
		merge(resultingStyle, stateStyle);
		merge(resultingStyle, styles.style);
		// default
		merge(resultingStyle, this.defaultStyle);
		// TODO manage page parent inheritance
		// TODO manage renderable inheritance
		// TODO manage several states
		// TODO stop merging up when style is complete?
		return resultingStyle;
	}

	private void merge(CascadingStyle resultingStyle, Style style) {
		if (style != null) {
			resultingStyle.merge(style);
		}
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
		CascadingStyle registeredStyle = styles.stateStyles.get(state);
		if (registeredStyle == null) {
			registeredStyle = new CascadingStyle();
			styles.stateStyles.put(state, registeredStyle);
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
		private final Map<State, CascadingStyle> stateStyles;

		public Styles() {
			this.stateStyles = new HashMap<State, CascadingStyle>();
		}
	}

}
