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
package com.clean.swing.utils;

import com.root101.clean.core.app.services.NavigationService;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

/**
 * 
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
