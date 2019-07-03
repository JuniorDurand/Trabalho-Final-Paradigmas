/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interface03;

import entities.Store;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

/**
 *
 * @author durand
 */
public class MostraStkAction implements ActionListener{

    private JTextArea t; 
    private Store loja;
    public MostraStkAction(JTextArea t, Store loja){
        this.loja = loja;
        this.t = t;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        t.setText(loja.mostrarCatalogo());
    }
    
}
