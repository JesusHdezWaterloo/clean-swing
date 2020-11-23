package com.clean.swing.app;

import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.login.LoginSimple;
import com.clean.swing.utils.CardComponent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
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

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension(d.width / 2, d.height / 2));

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
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
        compoment.setName(name);
        panelContent.add(name, compoment);
    }

  @Override
    public Component getView(String string) {
        for (Component c : panelContent.getComponents()) {
            if (c.getName().equals(string)) {
                return c;
            }
        }
        return panelContent;
    }

    @Override
    public String getSelectedViewName() {
        for (Component c : panelContent.getComponents()) {
            if (c.isVisible()) {
                return c.getName();
            }
        }
        return "NO VIEW SELECTED";
    }
    @Override
    public void removeView(Component component) {
        panelContent.remove(component);
    }

    @Override
    public Map<String, Component> getAll() {
        Map<String, Component> m = new HashMap();
        for (Component component : panelContent.getComponents()) {
            m.put(component.getName(), component);
        }
        return m;
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
