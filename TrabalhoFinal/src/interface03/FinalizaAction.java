/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface03;

import entities.Catalogue;
import entities.Delivery;
import entities.ShoppingBasquet;
import entities.Store;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author giova
 */
public class FinalizaAction implements ActionListener {
    protected String nome;
    protected String endereço;
    protected long numero;
    protected ShoppingBasquet cesta;
    protected JFrame j;
    protected Catalogue catalogo;
    protected JTextArea texto;
    protected Store loja;
    
    public FinalizaAction(ShoppingBasquet cesta, JFrame j, Catalogue catalogo, JTextArea texto){
        this.catalogo = catalogo;
        this.cesta = cesta;
        this.j = j;
        this.texto = texto;
        
    }

    public FinalizaAction(Store loja, JFrame j,  JTextArea texto){
        this.catalogo = loja.getCatalogo();
        this.cesta = loja.getCesta();
        this.j = j;
        this.texto = texto;
        this.loja = loja;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        nome = JOptionPane.showInputDialog(j, "Digite seu nome ");
        if(nome != null){
            endereço = JOptionPane.showInputDialog(j, "Digite seu endereço ");
            if(endereço != null){
                String numerostr = JOptionPane.showInputDialog(j, "Digite seu numero");
                try{
                    numero = Long.parseLong(numerostr);
                    new Delivery(nome, endereço, numero, cesta, catalogo);
                    
                    String recibo = "Cliente: ";
                    recibo += nome;
                    recibo += "\nEndereço: ";
                    recibo += endereço;
                    recibo += "\nNº: ";
                    recibo += numero;
                    recibo += "\nProdutos: \n";
                    recibo += cesta.basquetToDelivery();
                    texto.setText(recibo);
                    
                    loja.newShoppingBasquest();
                    
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Operação invalida");
                } catch (IOException ex) {
                    Logger.getLogger(FinalizaAction.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }
    
}
