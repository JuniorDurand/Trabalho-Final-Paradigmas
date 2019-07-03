package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entities.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author durand
 */
public class Catalogue {
    protected List <Product> produtos = new ArrayList<>();
    
    public Catalogue(){
        this.produtos = Catalogue.CriarArrayList();
    }
    
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
    
    public void Atualizar() throws IOException{
        try ( 
            FileWriter arq = new FileWriter("arquivo.txt")) {
            PrintWriter gravarArq = new PrintWriter(arq);
 
            for(Product p : produtos){
                gravarArq.printf(p.getNome());
                gravarArq.printf(" ; "+p.getAutor());
                gravarArq.printf(" ; "+p.getQntEstk());
                gravarArq.printf(" ; "+p.getValor());
                gravarArq.printf(" ; "+p.getId()+"\n");
            }
        }
    }
    
    public String mostraItens(){
        if(produtos.size()>0){
            String itens = "";
            for(Product p : produtos){
                itens += p.toString();
                itens += "\n";
            }
            return itens;
        }else{
            return "Catalogo vazio\n";
        }
        
    }
    
    public String toFile(){
        String file = "";
        for(Product p : produtos){
                file += p.toString();
                file += "\n";
            }
        return file;
    }
    
    public static ArrayList CriarArrayList(){
        int qnt = Product.QntLivros("arquivo.txt");
        
        
        ArrayList<Product> listaLivros = new ArrayList<>();
        int c = 0;
        Product[] p = new Product[qnt];
        for(int i=0; i<qnt; i++){
            p[i] = new Product();
            p[i].CriarProduto("arquivo.txt",c);
            listaLivros.add(p[i]);
            c++;
        }
        /*
        for(int i=0; i<listaLivros.size(); i++){
            System.out.println("");
            System.out.print("titulo:"+ listaLivros.get(i).getNome());
            System.out.print("  autor(a):"+ listaLivros.get(i).getAutor());
            System.out.print("  quantidade:"+ listaLivros.get(i).getQntEstk());
            System.out.print("  valor:"+ listaLivros.get(i).getValor());
            System.out.print("  id:"+ listaLivros.get(i).getId());
            System.out.println("");
        }
*/
        return listaLivros;
    }
}
