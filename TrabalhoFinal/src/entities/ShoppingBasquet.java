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

    List<ShoppingItem> cestaDeCompras = new ArrayList<>();

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
        String ShopItens = "";
        for (ShoppingItem si : cestaDeCompras) {
            ShopItens += si.toString();
            ShopItens += "\n";
        }
        return ShopItens;
    }

    public void apagarShopItens(Product p) {
        for (ShoppingItem si : cestaDeCompras) {
            if (si.equals((Object) p)) {
                int quant = p.getQuantEmEstok();
                p.setQuantEmEstok(quant + si.getQuant());
                cestaDeCompras.remove(si);
            }
        }
    }

    public void ModificarQuant(Product p, int quant) {
        if (quant >= 0) {
            for (ShoppingItem si : cestaDeCompras) {
                if (si.equals((Object) p)) {
                    if (quant > 0) {
                        int siQuant = si.getQuant();
                        p.setQuantEmEstok(p.getQuantEmEstok() + si.getQuant());
                        boolean flag;
                        flag = p.comprar(quant);
                        if (flag) {
                            si.setQuant(quant);
                        } else {
                            p.setQuantEmEstok(p.getQuantEmEstok() - siQuant);
                            si.setQuant(siQuant);
                        }
                    } else if (quant == 0) {
                        this.apagarShopItens(p);
                    }
                }
            }
        }
    }

}
