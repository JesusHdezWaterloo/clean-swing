package com.clean.swing.app;

import com.jhw.swing.material.components.dashboard.taskpane.expanded.DashBoardExtends;
import com.jhw.swing.ui.MaterialLookAndFeel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class MainView extends JFrame {

    public MainView() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);

        dashboard = new DashBoardExtends();
        this.add(dashboard, BorderLayout.CENTER);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        pack();
    }

    private DashBoardExtends dashboard;

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {
        System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

}
