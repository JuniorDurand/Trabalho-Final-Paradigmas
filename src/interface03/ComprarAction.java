/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interface03;

import entities.Product;
import entities.Store;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author durand
 */
public class ComprarAction implements ActionListener{
    
    private JFrame f; 
    private Store loja;
    private JDialog dialogComprar;
    private Product p;
    boolean compraFinalizada;
    
    
    public ComprarAction(JFrame f, Store loja){
        this.loja = loja;
        this.f = f;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        /*
        dialogComprar = new JDialog(f, true);
        JLabel l = new JLabel("Digite o nome do produto:");
        JTextField t = new JTextField(10); //10 tamanho do texto
        dialogComprar.add(l);
        dialogComprar.add(t);
        */
        String name = JOptionPane.showInputDialog(f, "Digite o nome do produto");
        if(name != null){
        
            p = loja.procurarCatalogo(name);
            if(p != null){
                String quantString = JOptionPane.showInputDialog(f, "Digite a quantidade desejada");
                int quant = 0;
                try{
                    quant = Integer.parseInt(quantString);
                    compraFinalizada = loja.adicionarNaCesta( p, quant);
                    if(compraFinalizada){
                        JOptionPane.showMessageDialog(null, "Compra realizada com sucesso");

                    }else{
                        JOptionPane.showMessageDialog(null, "Compra não realizada");
                    }
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Operação invalida");
                }

            }else{
                JOptionPane.showMessageDialog(null, "Produto não encontrado");
            }

        }
        
    }
}
