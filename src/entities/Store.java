/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.BufferedWriter;
import java.util.Scanner;

/**
 *
 * @author junior.durand
 */
public class Store {

    private Scanner input = new Scanner(System.in);

    protected String nome;
    protected ShoppingBasquet cesta;
    protected Catalogue catalogo;
    private BufferedWriter gravar;

    public Store(String nome) {
        this.nome = nome;
        cesta = new ShoppingBasquet();
        catalogo = new Catalogue();
    }
    
    public void newShoppingBasquest(){
        this.cesta = null;
        this.cesta = new ShoppingBasquet();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ShoppingBasquet getCesta() {
        return cesta;
    }

    public Catalogue getCatalogo() {
        return catalogo;
    }
    
    

    public String mostrarCatalogo() {
        return this.catalogo.mostraItens();
    }

    public Product procurarCatalogo(String nome) {
        return this.catalogo.procurarItem(nome);
    }

    public Product procurarCatalogo(int id) {
        return this.catalogo.procurarItem(id);
    }
    

    public String mostrarCesta() {
        return this.cesta.MostrarShopItens();
    }

    public boolean adicionarNaCesta(Product p, int x) {
        if (p.comprar(x)) {
            this.cesta.AddShopItens(p, x);
            return true;
        }else{
            return false;
        }
    }


    public boolean ModificarCesta(Product p, int x) {
        return this.cesta.ModificarQuant(p, x);
    }
    /*
    public void adicionarNoCatalogo() {

        int id;
        String nomeProdc;
        double valor;
        int quantiEstk;
        System.out.println("Digite o ID do Produto");
        id = input.nextInt();
        input.nextLine();
        System.out.println("Digite o nome do Produto");
        nomeProdc = input.nextLine();
        //input.nextLine();
        System.out.println("Digite o valor do Produto");
        valor = input.nextDouble();
        System.out.println("Digite a quantidade em estoque do Produto");
        quantiEstk = input.nextInt();
        Product p;
        p = new Product(id, nomeProdc, valor, quantiEstk);
        this.catalogo.inserirItem(p);
    }
    */

    public void fecharCompra() {
        ShoppingBasquet cestaFechada = this.cesta;
        this.cesta = null;
        
        //chamar função para colocar a cesta no arquivo
        //e colocar o delivery;
    }
    
    


}
