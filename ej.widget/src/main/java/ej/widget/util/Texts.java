/*
 * Java
 * Copyright 2009-2015 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.widget.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import ej.microui.display.DisplayFont;

/**
 * <p>
 * Provides some drawing facilities.
 * </p>
 */
public class Texts {

	private static final char SPACE = ' ';
	private static final char NEW_LINE = '\n';

	public static String[] splitString(String string, DisplayFont font, int width) {
		Vector<String> lines = new Vector<String>();

		char[] chars = string.toCharArray();
		int length = chars.length;
		int index = 0;
		int lastSpaceIndex = 0;
		int lastSplitIndex = 0;

		do {
			split: {
				boolean isSpace = false;
				if (index < length) {
					// in the string
					char c = chars[index];
					if (c == SPACE) {
						// find word
						isSpace = true;
					} else if (c != NEW_LINE) {
						// do not need to try to split here
						break split;
					} // else find manual break
				} else if (index != length) {
					// stop loop
					break;
				} // else end of the string

				int charsWidth = font.charsWidth(chars, lastSplitIndex, index - lastSplitIndex);
				if (charsWidth > width) {
					// the last word exceed the max width
					if (lastSpaceIndex > lastSplitIndex) {
						// split to previous word
						lines.addElement(string.substring(lastSplitIndex, lastSpaceIndex - 1));
						lastSplitIndex = lastSpaceIndex;
					}
				}
				if (isSpace) {
					// do not split for spaces, just save the last index
					lastSpaceIndex = index + 1;
				} else {
					// split here
					lines.addElement(string.substring(lastSplitIndex, index));
					lastSplitIndex = index + 1;
				}
			}
			index++;
		} while (true);

		return lines.toArray(new String[lines.size()]);
	}

	/**
	 * Splits the given string in its lines. It removes the '\n' character.
	 * 
	 * @param string
	 *            the string to split.
	 * @return the list of lines contained in the given string.
	 */
	public static String[] splitStringInLines(String string) {
		if (string.isEmpty()) {
			return new String[0];
		}
		List<String> lines = new ArrayList<String>();
		int newLineIndex = 0;

		do {
			int endOfLineIndex = string.indexOf(NEW_LINE, newLineIndex);

			if (endOfLineIndex == -1) {
				// End of string reached.
				lines.add(string.substring(newLineIndex));
				break;
			} else {
				lines.add(string.substring(newLineIndex, endOfLineIndex));
				newLineIndex = endOfLineIndex + 1;
			}

		} while (true);

		return lines.toArray(new String[lines.size()]);
	}
}
