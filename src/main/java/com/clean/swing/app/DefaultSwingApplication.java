package com.clean.swing.app;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DefaultSwingApplication implements AbstractSwingApplication, PropertyChangeListener {

    private final static ArrayList<AbstractSwingModule> INSTALLED_MODULES = new ArrayList<>();
    private RootView ROOT_VIEW;

    @Override
    public void navigateTo(String string, Object... o) {
        rootView().navigateTo(string, o);
        for (AbstractSwingModule abstractSwingModule : installedModules()) {
            abstractSwingModule.navigateTo(string, o);
        }
    }

    @Override
    public void registerModule(AbstractSwingMainModule... modulesToInstall) {
        for (AbstractSwingMainModule modulo : modulesToInstall) {
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

    @Override
    public List<AbstractSwingModule> installedModules() {
        return INSTALLED_MODULES;
    }

    @Override
    public void show() {
        rootView().setVisible(true);
    }

    @Override
    public RootView rootView() {
        return ROOT_VIEW;
    }

    @Override
    public void initRootView(RootView root) {
        this.ROOT_VIEW = root;
    }
}
