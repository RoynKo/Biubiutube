package biz;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.video.Video;

public class EcoSystemHelper {
    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        Network nw = system.newNetwork("NEU");
        UniverseCollegeOrganization coe = nw.getUniversity().getCollegeCatalog().newOrganization("COE");

        Person person;
        Account account;

        person = system.getSystemPersonCatalog().newPerson("Andy", "Zhao");
        try {
            system.getSystemAccountCatalog().newAccount("admin", "admin", system.getSystemAdminRole(), person);
        } catch (Exception ignored) {}

        person = coe.getPersonCatalog().newPerson("Bruce", "Qian");
        try {
            coe.getAccountCatalog().newAccount("mls", "mls", coe.getCollegeLecturerRole(), person);
            coe.getAccountCatalog().newAccount("mlsa", "mlsa", coe.getUniversityDepartmentSupervisorRole(), person);
        } catch (Exception ignored) {}

        person = coe.getPersonCatalog().newPerson("Cathy", "Sun");
        try {
            account = coe.getAccountCatalog().newAccount("sls", "sls", coe.getCollegeLecturerRole(), person);
            for (int i = 1; i < 9; i++) {
                Video v = nw.getVideoCatalog().newVideo(account);
                v.setTitle(String.format("INFO5100-Lab%d", i));
                v.setAdType(Video.VideoAdType.AnyAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://i.imgur.com/ijtKGes.png");
            }
        } catch (Exception ignored) {}


        return system;
    }
}
