/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Scanner;

/**
 *
 * @author junior.durand
 */
public class Story {
    Scanner input = new Scanner(System.in);
    
    public String nome;
    public ShoppingBasquet cesta;
    public Catalogue catalogo;
    
    public Story(String nome) {
        this.nome = nome;
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String mostrarCatalogo(){
        return this.catalogo.mostraItens();
    }
    
    public String mostrarCesta(){
        return this.cesta.MostrarShopItens();
    }
    
    public void adicionarNaCesta(Product p, int x){
        if(p.comprar(x)){
            this.cesta.AddShopItens(p, x);
        }
    }
    
    public void adicionarNoCatalogo(){
        
        int id;
        String nomeProdc;
        double valor;
        int quantiEstk;
        System.out.println("Digite o ID do Produto");
        id = input.nextInt();
        System.out.println("Digite o nome do Produto");
        nomeProdc = input.nextLine();
        System.out.println("Digite o valor do Produto");
        valor = input.nextDouble();
        System.out.println("Digite a quantidade em estoque do Produto");
        quantiEstk = input.nextInt();
        Product p;
        p = new Product(id, nomeProdc, valor, quantiEstk);
        this.catalogo.inserirItem(p);
    }
    
    public void fecharCompra(){
        ShoppingBasquet cestaFechada  = this.cesta;
        this.cesta = null;
        //chamar função para colocar a cesta no arquivo
        //e colocar o delivery;
    }
    

}
