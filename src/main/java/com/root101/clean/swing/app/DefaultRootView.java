/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.clean.swing.app;

import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.login.LoginSimple;
import com.root101.clean.swing.utils.CardComponent;
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
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
        if (name.equals(LOGIN_NAME) || name.equals(DASH_NAME)) {
            showView(name);
        } else {
            DASHBOARD.showView(name);
        }
        firePropertyChange(FIRE_NAVIGATE_TO, "", name);
    }

}
