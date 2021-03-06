/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package javafx.scene.control;

import java.time.LocalDate;

import javafx.scene.AccessibleAttribute;
import javafx.scene.AccessibleRole;
import javafx.scene.control.skin.DateCellSkin;

/**
 * DateCell is used by {@link DatePicker} to render the individual
 * grid cells in the calendar month. By providing a
 * {@link DatePicker#dayCellFactoryProperty() dayCellFactory}, an
 * application can provide an update method to change each cell's
 * properties such as text, background color, etc.
 *
 * @since JavaFX 8.0
 */
public class DateCell extends Cell<LocalDate> {
    public DateCell() {
        getStyleClass().add(DEFAULT_STYLE_CLASS);
        setAccessibleRole(AccessibleRole.TEXT);
    }

    /** {@inheritDoc} */
    @Override public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);
    }

    /** {@inheritDoc} */
    @Override protected Skin<?> createDefaultSkin() {
        return new DateCellSkin(this);
    }

    /***************************************************************************
     *                                                                         *
     * Stylesheet Handling                                                     *
     *                                                                         *
     **************************************************************************/

    private static final String DEFAULT_STYLE_CLASS = "date-cell";

    /***************************************************************************
     *                                                                         *
     * Accessibility handling                                                  *
     *                                                                         *
     **************************************************************************/

    /** {@inheritDoc} */
    @Override
    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
        switch (attribute) {
            case TEXT: {
                if (isFocused()) {
                    return getText();
                }
                return "";
            }
            default: return super.queryAccessibleAttribute(attribute, parameters);
        }
    }
}
