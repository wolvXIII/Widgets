package ej.widget;

import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.style.Size;
import ej.style.Style;

public class Radio extends StyledWidget {

	private static final int CONTENT_SIZE = 34;
	private static final int THICKNESS = 2;

	@Override
	protected void renderContent(GraphicsContext g, Style style, Size remainingSize) {
		int remainingWidth = remainingSize.getWidth();
		int remainingHeight = remainingSize.getHeight();
		AntiAliasedShapes antiAliasedShapes = AntiAliasedShapes.Singleton;
		antiAliasedShapes.setFade(1);
		antiAliasedShapes.setThickness(THICKNESS);
		int foregroundColor = style.getForegroundColor();
		g.setColor(foregroundColor);

		int x = (remainingWidth - CONTENT_SIZE) / 2;
		int y = (remainingHeight - CONTENT_SIZE) / 2;
		int diameter = CONTENT_SIZE;

		antiAliasedShapes.drawCircle(g, x, y, diameter);
		// g.drawCircle(x, y, diameter);
		antiAliasedShapes.setThickness(18);
		antiAliasedShapes.drawPoint(g, remainingWidth / 2, remainingHeight / 2);

	}

	@Override
	protected Size getContentSize(Style style) {
		Size contentSize = new Size();
		contentSize.setSize(CONTENT_SIZE, CONTENT_SIZE);
		return contentSize;
	}
}
