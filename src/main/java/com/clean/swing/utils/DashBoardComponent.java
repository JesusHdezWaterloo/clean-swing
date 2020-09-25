/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clean.swing.utils;

import java.awt.Component;
import javax.swing.Icon;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class DashBoardComponent {

    public static DashBoardComponent from(String name, Icon icon, String nav, Component view) {
        return new DashBoardComponent(name, icon, nav, view);
    }

    public String name;
    public Icon icon;
    public String nav;
    public Component view;

    public DashBoardComponent(String name, Icon icon, String nav, Component view) {
        this.name = name;
        this.icon = icon;
        this.nav = nav;
        this.view = view;
    }

}
