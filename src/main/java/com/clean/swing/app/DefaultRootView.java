package com.clean.swing.app;

import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.login.LoginSimple;
import com.clean.swing.utils.CardComponent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DefaultRootView extends RootView implements CardComponent<Component> {

    private DashBoardSimple DASHBOARD;

    private LoginSimple LOGIN;

    private final CardLayout cards = new CardLayout();

    public DefaultRootView(PropertyChangeListener listener) {
        super(listener);
        initComponents();
    }

    protected void setDashBoard(DashBoardSimple dashboard) {
        this.DASHBOARD = dashboard;
        this.addView(DASH_NAME, DASHBOARD);
    }

    protected void setLogin(LoginSimple login) {
        this.LOGIN = login;
        this.addView(LOGIN_NAME, LOGIN);
    }

    private void initComponents() {
        this.panelContent = new JPanel();
        this.panelContent.setLayout(cards);

        this.setLayout(new BorderLayout());
        this.add(panelContent, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        pack();
    }

    private JPanel panelContent;

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        firePropertyChange(ON_WINDOWS_CLOSING, null, evt);
        System.exit(0);
    }

    @Override
    public void showView(String name) {
        cards.show(panelContent, name);
    }

    @Override
    public void addView(String name, Component compoment) {
        panelContent.add(name, compoment);
    }

    @Override
    public Component getView(String string) {
        return null;
    }

    @Override
    public DashBoardSimple dashboard() {
        return DASHBOARD;
    }

    @Override
    public LoginSimple login() {
        return LOGIN;
    }

    @Override
    public void navigateTo(String name, Object... o) {
        showView(name);
        DASHBOARD.showView(name);
    }

}
