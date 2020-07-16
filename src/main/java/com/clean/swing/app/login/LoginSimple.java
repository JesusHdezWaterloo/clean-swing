package com.clean.swing.app.login;

import java.awt.Container;
import java.awt.event.ActionListener;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class LoginSimple extends Container {

    public abstract void addLoginAction(ActionListener action);

    public abstract String getUser();

    public abstract String getPass();
}
