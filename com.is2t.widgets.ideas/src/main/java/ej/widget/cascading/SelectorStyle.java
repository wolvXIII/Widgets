package ej.widget.cascading;

class SelectorStyle {
	final Selector selector;
	final CascadingStyle style;

	public SelectorStyle(Selector selector, CascadingStyle style) {
		this.selector = selector;
		this.style = style;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SelectorStyle) {
			SelectorStyle other = (SelectorStyle) obj;
			return this.selector.equals(other.selector);
		} else if (obj instanceof Selector) {
			Selector selector = (Selector) obj;
			return this.selector.equals(selector);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.selector.hashCode();
	}
}