package edu.depaul.ipd.jdp.filehandling.propertyfile;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceMain {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("label");
        System.out.println(rb.getString("greeting"));

        ResourceBundle rb2 = ResourceBundle.getBundle("label", Locale.FRANCE);
        System.out.println(rb2.getString("greeting"));
    }
}
