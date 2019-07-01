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
public class ShoppingItem {

    protected int id;
    protected int quant;
    protected String nome;

    public ShoppingItem(Product p, int quant) {
        this.id = p.getId();
        this.quant = quant;
        this.nome = p.getNome();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "ShoppingItem{"
                + "id = " + this.id
                + ", quantidade = " + this.quant
                + ", titulo = " + this.nome
                + "}";
    }


    public boolean equals(Product obj) {
        if (obj == null) {
            return false;
        }


        return this.id == obj.getId();
    }

}
