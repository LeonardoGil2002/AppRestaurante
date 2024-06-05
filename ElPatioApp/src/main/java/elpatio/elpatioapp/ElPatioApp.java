/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elpatio.elpatioapp;

import elpatio.elpatioapp.igu.Main;

/**
 *
 * @author Leo
 */
public class ElPatioApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Hacemos visible la pantalla Main
        Main main = new Main();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
    }
    
}
