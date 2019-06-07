/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author durand
 */
public class Product {
    public int id;
    public String nome;
    public double valor;
    public int quantEmEstok;

    public Product(int id, String nome, double valor, int quantEmEstok) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantEmEstok = quantEmEstok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantEmEstok() {
        return quantEmEstok;
    }

    public void setQuantEmEstok(int quantEmEstok) {
        this.quantEmEstok = quantEmEstok;
    }
    
    public boolean comprar(int quant){
        if(quant>0){
            if(quant <= this.quantEmEstok){
                this.quantEmEstok = quant - this.quantEmEstok;
                return true;
            }else{
                System.out.println("Quantidade indisponivel");
                return false;
            }
        }
        System.out.println("Quantidade invalida");
        return false;
    }

    @Override
    public String toString() {
        return "Producto{" 
                + "id = " + id 
                + ", nome = " + nome 
                + ", valor = " + valor 
                + ", quantidade em estoque = " + quantEmEstok 
                + '}';
    }
    
    
    
}
