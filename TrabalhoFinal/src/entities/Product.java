/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author durand
 */
public class Product {
    public int id;
    public String nome;
    public String autor;
    public double valor;
    public int qntEstk;
/*
    public Product(int id, String nome, double valor, int quantEmEstok) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantEmEstok = quantEmEstok;
    }
*/
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

    public int getQntEstk(){
        return qntEstk;
    }
    
    public void setQntEstk(int qntEstk){
        this.qntEstk = qntEstk;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    
    
    public boolean comprar(int quant){
        if(quant>0){
            if(quant <= this.qntEstk){
                this.qntEstk -= quant;
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
                + ", quantidade em estoque = " + qntEstk 
                + '}';
    }
    
     public void CriarProduto(String caminho, int c) {
	try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha;
            try {		
		linha = lerArq.readLine();
                for(int i=0; i<c; i++){
                    linha = lerArq.readLine();
                }	
		if(linha!=null) {
                    String[] palavra = linha.split(" ; ");
                    this.setNome(palavra[0]);
                    this.setAutor(palavra[1]);
                    this.qntEstk=Integer.parseInt(palavra[2]);
                    this.valor=Integer.parseInt(palavra[3]);
                    this.id=Integer.parseInt(palavra[4]);
                                                
				}
				
				arq.close();
				//return conteudo;
			}catch (IOException ex) {
				System.out.println("ERRO: AO LER O ARQUIVO");
				//return "";
			}
		}catch (FileNotFoundException ex) {
			System.out.println("ERRO: ARQUIVO NAO ENCONTRADO");
			//return "";
		}
		
        }
     
     public static int QntLivros(String caminho) {
		//String conteudo = "";
		int count=0;
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			
			try {
				
				while(linha != null) {
                                    count++;
                                    linha = lerArq.readLine();
					
					//System.out.println(count);
				}
				
				arq.close();
				//return conteudo;
				
				return count-1;
				
			}catch (IOException ex) {
				System.out.println("ERRO: AO LER O ARQUIVO");
				
			}
		}catch (FileNotFoundException ex) {
			System.out.println("ERRO: ARQUIVO NAO ENCONTRADO");
			
		}
		
		return count;
	}

    
    
}
