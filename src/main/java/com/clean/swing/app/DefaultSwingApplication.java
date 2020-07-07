package com.clean.swing.app;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DefaultSwingApplication implements AbstractSwingApplication, PropertyChangeListener {

    @Override
    public void navigateTo(String string, Object... o) {
        rootView().navigateTo(string, o);
        for (AbstractSwingModule abstractSwingModule : installedModules()) {
            abstractSwingModule.navigateTo(string, o);
        }
    }

    @Override
    public void registerModule(AbstractSwingModule... modulesToInstall) {
        for (AbstractSwingModule modulo : modulesToInstall) {
            modulo.register(this);
            this.installedModules().add(modulo);
        }
        rootView().dashboard().update(rootView().dashboard().getMap());//este es que al final actualiza todo
        rootView().dashboard().format();
        rootView().dashboard().revalidate();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case RootView.ON_WINDOWS_CLOSING:
                closeApplication();
                break;
            default:
                return;
        }
    }
}
