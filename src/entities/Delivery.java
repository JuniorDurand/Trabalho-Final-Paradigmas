/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



/**
 *
 * @author giova
 */
public class Delivery {
    protected String endereço;
    protected String nome;
    protected long numero;
    protected File arquivo;
    protected Catalogue catalogo;
    
    protected ShoppingBasquet cesta;
    
    public Delivery(String nome, String endereço, long numero, ShoppingBasquet cesta, Catalogue catalogo) throws IOException{
        this.catalogo = catalogo;
        this.endereço = endereço;
        this.nome = nome;
        this.numero = numero;
        this.cesta = cesta;
        
        String newLine = System.getProperty("line.separator");
        
        FileWriter arq = new FileWriter("recibo.txt",true);
        PrintWriter gravarArq = new PrintWriter(arq);
        
        gravarArq.printf("Cliente: "+ this.nome + newLine); 
        gravarArq.printf("Endereço de entrega: "+ this.endereço+ newLine);
        gravarArq.printf("Numero de telefone: "+ this.numero+ newLine);
        gravarArq.printf(" PRODUTOS:"+newLine);
        gravarArq.printf(cesta.basquetToDelivery());
        
        
        
        arq.close();
        
        catalogo.Atualizar();
        
        
    }
    
    
}
