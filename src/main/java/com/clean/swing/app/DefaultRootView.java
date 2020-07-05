package com.clean.swing.app;

import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.utils.CardComponent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public abstract class DefaultRootView extends JFrame implements com.clean.swing.app.RootView, CardComponent<Component> {

    private DashBoardSimple DASHBOARD;

    private final CardLayout cards = new CardLayout();

    public DefaultRootView() {
        initComponents();
        this.setVisible(true);
    }

    protected void setDashBoard(DashBoardSimple dashboard) {
        this.DASHBOARD = dashboard;
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
    public void navigateTo(String name, Object... o) {
        showView(name);
        DASHBOARD.showView(name);
    }

}
