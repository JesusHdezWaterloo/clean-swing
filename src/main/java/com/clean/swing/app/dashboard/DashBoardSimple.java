package com.clean.swing.app.dashboard;

import com.clean.swing.utils.CardComponent;
import java.awt.Component;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DashBoardSimple extends MapeableContainer implements CardComponent<Component> {

    public abstract void deselectAll();

    public abstract void format();
}
