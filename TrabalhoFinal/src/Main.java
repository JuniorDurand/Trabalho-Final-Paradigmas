
import entities.Product;
import entities.ShoppingItem;
import entities.Store;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author durand
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Store loja = new Store("Minha Loja");
        Scanner input;
        String nome;
        int id = -1;
        Product p;
        //ShoppingItem si;
        int quant;
        boolean flag;
        input = new Scanner(System.in);
        int opcao = 0;
        do {
            menuPrincipal();
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    loja.adicionarNoCatalogo();
                    break;

                case 2:
                    System.out.println(loja.mostrarCatalogo());
                    break;

                case 3:
                    System.out.println("Digite o nome do produto");
                    nome = input.next();
                    p = loja.procurarCatalogo(nome);
                    if (p != null) {
                        System.out.println(p.toString());
                    } else {
                        System.out.println("Produto nao encontrado");
                    }

                    break;

                case 4:
                    System.out.println("Digite o nome do produto");
                    
                    input.nextLine();
                    nome = input.nextLine();
                    //inpu
                    p = loja.procurarCatalogo(nome);
                    if (p != null) {
                        System.out.println(p.toString());
                        System.out.print("Digite a quantidade:");
                        quant = input.nextInt();
                        loja.adicionarNaCesta(p, quant);
                    } else {
                        System.out.println("Produto nao encontrado");
                    }
                    break;

                case 5:
                    System.out.println(loja.mostrarCesta());
                    break;

                case 6:
                    System.out.println("Digite o nome do produto");
                    nome = input.next();
                    System.out.println("Digite a quantidade");
                    quant = input.nextInt();
                    p = loja.procurarCatalogo(nome);
                    loja.ModificarCesta(p, quant);
                    loja.mostrarCesta();

            }

        } while (opcao != 0);

    }

    public static void menuPrincipal() {
        System.out.println("1 - Colocar Item do catalogo");
        System.out.println("2 - Mostrar catalogo");
        System.out.println("3 - Procurar Item");
        System.out.println("4 - Fazer compras");
        System.out.println("5 - Mostrar cesta");
        System.out.println("6 - Editar cesta");
        System.out.println("0 - Sair");
    }
}
