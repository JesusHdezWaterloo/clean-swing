package com.clean.swing.app;

import java.util.List;
import javax.swing.Action;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface AbstractSwingSubModule extends AbstractSwingModule {

    public List<Action> register(AbstractSwingApplication dashBoard);
}
