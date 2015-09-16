package ej.widget;

/**
 * Defines an object which listens for change event.
 */
public interface OnStateChangeListener {

	/**
	 * Invoked when the target of the listener has changed its state.
	 * 
	 * @param source
	 *            the target of the listener.
	 */
	void onStateChange(Object source, boolean before, boolean after);
}
