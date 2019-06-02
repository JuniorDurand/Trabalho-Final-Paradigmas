package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entities.Product;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author durand
 */
public class Catalogue {
    List <Product> produtos = new ArrayList<>();
    
    public void inserirItem(Product p){
        produtos.add(p);
    }
    
    public Product procurarItem(String nome){
        for(Product p : produtos){
            if(p.getNome().equals(nome)){
                return p;
            }
        }
        return null;
    }
    public Product procurarItem(int id){
        for(Product p : produtos){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    public String mostraItens(){
        String itens = "";
        for(Product p : produtos){
            itens += p.toString();
            itens += "\n";
        }
        return itens;
    }
    
    
}
