# Trabalho-Paradigmas-Final

Trabalho final da cadeira de Paradigmas de Programação ministrado no curso de ciência da computação na UFMA.

## Objetivo

Desenvolver uma aplicação Java que simule a operação de uma loja virtual. O programa
não irá de fato funcionar on-line, mas deverá se comportar como um site de compras
virtual.

## Visão Geral

O programa deve permitir que os clientes possam percorrer o catálogo de produtos,
consultar produtos específicos, comprar itens, bem como especificar detalhes da entrega.
Em uma típica sessão de interação com este site, um usuário irá procurar os itens que deseja
comprar, colocá-los em sua cesta de compras e especificar os detalhes de entrega do
produto. O tipo de produto com que sua loja irá trabalhar é de livre escolha.

Considere o seguinte diagrama de classes:

![Classes](/assets/classes.jpg)

### Sugere-se desenvolver o trabalho por partes, assim distribuídas:

* Parte I: Completar o diagrama de classes fornecido, especificando os atributos e métodos das classes
* Parte II: Implementar as classes CestaCompras (ShoppingBasket) e ItemCestaCompras (ShoppingItem) e as classes Catalogo (Catalogue) e Produto (Product). Desenvolver um programa principal para testar as funcionalidades de cada conjunto de classes.
* Parte III: Implementar a classe LojaVirtual (Store), a qual deve prover uma interface gráfica com o usuário, assumindo a responsabilidade de chamar as funcionalidades das demais classes.
* Parte IV: Implementar a classe Entrega (Delivery), que receberá os detalhes de entrega do pedido.

## Requisitos

1. Percorrer o catálogo de produtos;
2. Procurar por um produto específico;
3. Atualizar (inserir/apagar/modificar quantidade) produtos na cesta de compras;
4. Mostrar os itens da cesta de compras;
5. Atualizar informações de entrega (nome, endereço do cliente, etc.);
6. Possuir uma interface gráfica que integre suas funcionalidades

## Entrega do Trabalho

* Programa baseado nos conceitos de orientação a objetos, bem organizado e modular (enviar por email).
* O Relatório com o seguinte conteúdo: decisões de implementação tomadas, características do programa, estruturas de dados utilizadas, funcionalidades, limitações, telas de execução.
* O Demonstração do programa no laboratório.