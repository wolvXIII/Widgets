/*
 * Java
 *
 * Copyright 2015 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.style;

import java.util.List;

public interface Element {

	List<String> getClassSelectors();

	List<State> getStates();

	Object getParentElement();

}
