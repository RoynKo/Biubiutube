/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.extraCurricularOrganizationEnterprise.adminOrganization;

import ui.network.advertisementEnterprise.adminOrganization.*;
import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author royn
 */
public class ECOAdminWorkArea extends GeneralWorkArea{
    public ECOAdminWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btnManageOrganization = new JButton("Manage Organization");
        btnManageOrganization.addActionListener(e -> parent.pushComponent(new ECOManageOrganizations(parent, account)));
        
        JButton btnManageAccount = new JButton("Manage Account");
        btnManageAccount.addActionListener(e -> parent.pushComponent(new ECOManageAccounts(parent, account)));
        buttons.add(btnManageOrganization);
        buttons.add(btnManageAccount);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return "Welcome, AdvertisementAdmin";
    }
    
}