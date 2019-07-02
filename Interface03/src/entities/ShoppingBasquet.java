/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author durand
 */
public class ShoppingBasquet {

    protected List<ShoppingItem> cestaDeCompras = new ArrayList<>();

    //Chamar metodo compra do Product na classe acima.
    public void AddShopItens(Product p, int quant) {
        boolean jaComp = false;
        for (ShoppingItem si : cestaDeCompras) {
            if (si.equals((Object) p)) {
                int q = si.getQuant();
                si.setQuant(quant + q);
                jaComp = true;
                break;
            }
        }
        if (!jaComp) {
            cestaDeCompras.add(new ShoppingItem(p, quant));
        }

    }

    public String MostrarShopItens() {
        if(cestaDeCompras.size()>0){
            String ShopItens = "";
            for (ShoppingItem si : cestaDeCompras) {
                ShopItens += si.toString();
                ShopItens += "\n";
            }
            return ShopItens;
        }else{
            return "Cesta vazia\n";
        }
            
    }
    
    public String basquetToDelivery() {
        if(cestaDeCompras.size()>0){
            String ShopItens = "";
            String newLine = System.getProperty("line.separator");
            for (ShoppingItem si : cestaDeCompras) {
                ShopItens += si.toDelivery();
                ShopItens += newLine;
            }
            return ShopItens;
        }else{
            return "";
        }
            
    }

    public void apagarShopItens(Product p) {
        for (ShoppingItem si : cestaDeCompras) {
            if (si.equals((Object) p)) {
                int quant = p.getQntEstk();
                p.setQntEstk(quant + si.getQuant());
                cestaDeCompras.remove(si);
            }
        }
    }

    public boolean ModificarQuant(Product p, int quant) {
        if (quant >= 0) {
            for (ShoppingItem si : cestaDeCompras) {
                
                if (si.equals(p)) {
                    if (quant > 0) {
                        int siQuant = si.getQuant();
                        p.setQntEstk(p.getQntEstk() + si.getQuant());
                        boolean flag;
                        flag = p.comprar(quant);
                        if (flag) {
                            si.setQuant(quant);
                        } else {
                            p.setQntEstk(p.getQntEstk() - siQuant);
                            si.setQuant(siQuant);
                        }
                    } else if (quant == 0) {
                        //this.apagarShopItens(p);
                        int quantEstk = p.getQntEstk();
                        p.setQntEstk(quantEstk + si.getQuant());
                        cestaDeCompras.remove(si);
                    }
                    return true;
                }
            }
        }
        return false;
    }

}
