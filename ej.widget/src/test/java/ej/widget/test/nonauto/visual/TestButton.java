/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.widget.test.nonauto.visual;

import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;
import ej.widget.Button;
import ej.widget.Label;
import ej.widget.OnClickListener;

/**
 * 
 */
public class TestButton {

	public static void main(String[] args) {
		MicroUI.start();
		Desktop desktop = new Desktop();
		Panel panel = new Panel();

		Button button = new Button();
		button.addOnClickListener(new OnClickListener() {

			@Override
			public void onClick(Object source) {
				System.out.println("clicked");
			}
		});
		button.setWidget(new Label("Hello World !!!\nil fait beau et je cours dans les champs"));
		panel.setWidget(button);
		panel.show(desktop, true);
		desktop.show();
	}
}
