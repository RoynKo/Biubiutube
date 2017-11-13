/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author hezj
 */
public interface ParentUI {
    JPanel getContainerJPanel();

    default void setHeaderTitle(String title) {};

    default void popComponent() {
        JPanel containerJPanel = getContainerJPanel();
        if (containerJPanel.getComponentCount() <= 0) {
            return;
        }
        
        containerJPanel.remove(containerJPanel.getComponentCount() - 1);
        ((CardLayout) containerJPanel.getLayout()).previous(containerJPanel);

        if (containerJPanel.getComponentCount() > 0) {
            int componentCount = containerJPanel.getComponentCount();
            Component component = containerJPanel.getComponent(componentCount - 1);  // get the last Component

            if (component instanceof TablePopulatable) {
                ((TablePopulatable) component).populateTable();
            }
//            
//            if (component instanceof HasTitle) {
//                setHeaderTitle(((HasTitle) component).getTitle());
//            }
        }
        componentPoped();
    }

    default void componentPoped() {}

    default void pushComponent(Component component) {
        JPanel containerJPanel = getContainerJPanel();
        containerJPanel.add(component.getClass().getName(), component);
        ((CardLayout) containerJPanel.getLayout()).next(containerJPanel);

//        if (component instanceof HasTitle) {
//            setHeaderTitle(((HasTitle) component).getTitle());
//        }

        componentPushed(component);
    }

    default void componentPushed(Component component) {}

    default void popAllComponents() {
        JPanel containerJPanel = getContainerJPanel();
        containerJPanel.removeAll();
        ((CardLayout) containerJPanel.getLayout()).first(containerJPanel);

        allComponentsPoped();
    }

    default void allComponentsPoped() {}
}
