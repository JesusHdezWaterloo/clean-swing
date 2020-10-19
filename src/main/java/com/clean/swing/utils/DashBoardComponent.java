/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clean.swing.utils;

import com.clean.core.app.services.NavigationService;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashBoardComponent {

    public static DashBoardComponent from(String name, Icon icon, String nav, Component view) {
        return new DashBoardComponent(name, icon, nav, view);
    }

    public static DashBoardComponent from(String name, String toolTip, Icon icon, String nav, Component view) {
        return new DashBoardComponent(name, toolTip, icon, nav, view);
    }

    public String name;
    public String toolTip;
    public Icon icon;
    public String nav;
    public Component view;

    public DashBoardComponent(String name, Icon icon, String nav, Component view) {
        this(name, name, icon, nav, view);
    }

    public DashBoardComponent(String name, String toolTip, Icon icon, String nav, Component view) {
        this.name = name;
        this.toolTip = toolTip;
        this.icon = icon;
        this.nav = nav;
        this.view = view;
    }

    public AbstractAction buildAction(NavigationService navigator) {
        AbstractAction act = new AbstractAction(name, icon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigator.navigateTo(nav);
            }
        };
        act.putValue(Action.SHORT_DESCRIPTION, toolTip);
        return act;
    }
}
