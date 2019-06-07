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
    public int id;
    public int quant;

    public ShoppingItem(Product p, int quant) {
        this.id = p.id;
        this.quant = quant;
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
                + "id = " + id 
                + ", quantidade = " + quant 
                + '}';
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        final Product other = (Product) obj;
        return this.id == other.id;
    }
    
    
}
