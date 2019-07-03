/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interface03;

import entities.Store;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author durand
 */
public class Main extends JFrame{

    public Main(Store loja){
        setTitle("Minha Aplicação");
        setSize(900, 500);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPainel = new JPanel();
        JPanel painelEsq = new JPanel();
        //painelEsq.setLocation(0, 0);
        
        
        
        JTextArea texto = new JTextArea(40, 40);
        texto.setLocation(10, 10);
        
        texto.setText("Clique em uma opção");
        
        
        painelEsq.add(texto);
        mainPainel.add(painelEsq);
        
        JPanel painelDir = new JPanel();
        painelDir.setLayout(new BoxLayout( painelDir,BoxLayout.Y_AXIS));
        
        JButton MosEtk = new JButton("Mostrar estoque");
        MostraStkAction actMStk = new MostraStkAction(texto, loja);
        MosEtk.addActionListener(actMStk);
        painelDir.add(MosEtk);
        
        JButton MosCesta = new JButton("Mostrar carrinho");
        MostraCestAction actCesta = new MostraCestAction(texto, loja);
        MosCesta.addActionListener(actCesta);
        painelDir.add(MosCesta);
        
        JButton Comprar = new JButton("    Comprar    ");
        ComprarAction actComprar = new ComprarAction(this, loja);
        Comprar.addActionListener(actComprar);
        painelDir.add(Comprar);
        
        JButton editCesta = new JButton("Editar Carrinho");
        EditCarAction actEditCest = new EditCarAction(this, loja);
        editCesta.addActionListener(actEditCest);
        painelDir.add(editCesta);
        
        JButton finalizaCompra = new JButton("Finalizar Compra");
        FinalizaAction actFinalizaCompra = new FinalizaAction(loja.getCesta(), this, loja.getCatalogo(), texto);
        finalizaCompra.addActionListener(actFinalizaCompra);
        painelDir.add(finalizaCompra);
        
        mainPainel.add(painelDir);
        this.add(mainPainel);
        setVisible(true);
    }
    
    public static void mainas(String[] args) {
        Store loja = new Store("Minha Loja");
        
        new Main(loja);
    }
    
}
