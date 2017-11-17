package ui.components.topBar;

import javax.swing.*;
import java.awt.*;

public class TopBar extends JPanel {
    private ParentUI parent;
    private JButton btnBack;
    private LoginArea loginArea;
    private StatusArea statusArea;

    public TopBar(ParentUI parent) {
        this.parent = parent;
        initComponents();
    }

    private void initComponents() {
        setLayout(new java.awt.BorderLayout());

        loginArea = new LoginArea(parent, this);
        statusArea = new StatusArea(parent, this);
        
        this.btnBack = new JButton("< Back");
        this.btnBack.addActionListener(e -> parent.popComponent());

        this.add(loginArea, BorderLayout.LINE_END);
        add(btnBack, BorderLayout.LINE_START);
        
    }
    
    public void loggedIn(/* Account account */) {
        remove(loginArea);
//        statusArea.setGreeting("Hello, " + account.getPerson().getFullName());
        statusArea.setGreeting("Hello, foba");
        parent.pushComponent(new DemoJPanel(parent));
        add(btnBack, BorderLayout.LINE_START);
        add(statusArea, BorderLayout.LINE_END);
        validate();
        repaint();
    }
    
    public void loggedOut() {
        remove(statusArea);
        remove(btnBack);
        add(loginArea, BorderLayout.LINE_END);
        validate();
        repaint();
    }
}