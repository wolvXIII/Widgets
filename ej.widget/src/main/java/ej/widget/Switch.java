package ej.widget;


import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.style.Size;
import ej.style.Style;
import ej.widget.util.ColorsHelper;

/**
 * An AbstractToggleButton allows the user to change a setting between two states.
 */
public class Switch extends ToggleButton {

	private static final int CONTENT_WIDTH = 30;
	private static final int CONTENT_HEIGHT = 36;

	/**
	 * Creates an AbstractToggleButton instance with the specified checked state.
	 * 
	 * @param checked
	 *            if true, the toggle button is initially checked; otherwise, the toggle button is initially unchecked.
	 */
	public Switch(boolean checked) {
		super(checked);
	}

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setFade(1);
		antiAliasedShapes.setThickness(CONTENT_HEIGHT);
		int foregroundColor = style.getForegroundColor();
		int checkColor = ColorsHelper.lightenColor(foregroundColor, 10);

		g.setColor(foregroundColor);
		int x1 = (remainingSize.getWidth() - CONTENT_WIDTH) / 2;
		int y = remainingSize.getHeight() / 2;
		int x2 = x1 + CONTENT_WIDTH;
		antiAliasedShapes.drawLine(g, x1, y, x2, y);

		antiAliasedShapes.setThickness(CONTENT_HEIGHT - 4);
		g.setColor(checkColor);
		if (isChecked()) {
			antiAliasedShapes.drawPoint(g, x2, y);
		} else {
			antiAliasedShapes.drawPoint(g, x1, y);
		}
	}
}
