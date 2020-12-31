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

import com.root101.clean.core.app.services.NavigationService;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.login.LoginSimple;
import java.awt.HeadlessException;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

/**
 * 
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class RootView extends JFrame implements NavigationService {

    public static final String DASH_NAME = "DASHBOARD";
    public static final String LOGIN_NAME = "LOGIN";
    public static final String ON_WINDOWS_CLOSING = "windows.closing";
    public static final String FIRE_NAVIGATE_TO = "navigate_to";

    public RootView(PropertyChangeListener listener) throws HeadlessException {
        this.addPropertyChangeListener(listener);
    }

    public abstract DashBoardSimple dashboard();

    public abstract LoginSimple login();
}
