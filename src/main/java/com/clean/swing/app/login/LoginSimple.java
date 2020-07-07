package com.clean.swing.app.login;

import com.clean.swing.app.dashboard.*;
import com.clean.swing.utils.CardComponent;
import java.awt.Component;
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
