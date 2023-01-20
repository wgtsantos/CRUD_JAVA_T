/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import dao.VeiculoDao;
import java.util.Scanner;
import model.Veiculo;

/**
 *
 * @author Instrutor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner en = new Scanner(System.in);
        Scanner ent = new Scanner(System.in);
        Scanner entr = new Scanner(System.in);
        
        VeiculoDao veiculodao = new VeiculoDao();
        Veiculo veiculo = new Veiculo();
        
        System.out.println("Escolha um opção abaixo: ");
        System.out.println("1- Cadastrar Novo Veiculo.");
        System.out.println("2- Listar todos os Veiculos.");
        System.out.println("3- Pesquisar Veiculo por Código.");
        System.out.println("4- Alterar Veiculo Cadastrado.");
        System.out.println("5- Deletar Veiculo Cadastrado.");
        int opt = en.nextInt();
        
        switch (opt) {
            case 1:
                System.out.println("");
                System.out.println("----------- Cadastrar Novo Veiculo ----------------");
                System.out.println("");
                System.out.println("Informe o nome do Veiculo: ");
                String nome = ent.nextLine();
                veiculo.setNome(nome);
                System.out.println("Informe o valor do Veiculo: ");
                Double valor = en.nextDouble();
                veiculo.setValor(valor);
                System.out.println("Informe o nome do fabricante do Veiculo: ");
                String fabricante = ent.nextLine();
                veiculo.setFabricante(fabricante);
                
                veiculodao.criar(veiculo);
                break;
            
            case 2:
                System.out.println("");
                System.out.println("Veiculos cadastrados no banco de dados ---->: ");
                
                int cont = 1;
                
                for (Veiculo v : veiculodao.ListarVeiculos()) {
                    System.out.println("Veiculo 00" + cont + " ----------------------");
                    System.out.println("ID: " + v.getId());
                    System.out.println("Nome: " + v.getNome());
                    System.out.println("Valor: " + v.getValor());
                    System.out.println("Fabricante: " + v.getFabricante());
                    System.out.println("-------------------------------------------");
                    
                    cont++;
                }
                
                break;
            case 3:
                System.out.println("");
                System.out.println("Pesquisar Veiculo cadastrado por Código ---->: ");
                System.out.println("Informe o código do Veiculo: ");
                int cod = ent.nextInt();
                veiculo.setId(cod);
                
                for (Veiculo v : veiculodao.ListarVeiculoPorCod(cod)) {
                    System.out.println("-------------------------------------------");
                    System.out.println("ID: " + v.getId());
                    System.out.println("Nome: " + v.getNome());
                    System.out.println("Valor: " + v.getValor());
                    System.out.println("Fabricante: " + v.getFabricante());
                    System.out.println("-------------------------------------------");
                    
                }
                break;
            case 4:
                System.out.println("");
                System.out.println("Alterar Veiculo cadastrado por Código ---->: ");
                System.out.println("Informe o código do Veiculo: ");
                cod = ent.nextInt();
                veiculo.setId(cod);
                System.out.println("-----------------");
                System.out.println("Você está alterando os dados do veiculo ID: " + cod);
                System.out.println("");
                System.out.println("Informe o nome do Veiculo: ");
                nome = entr.nextLine();
                veiculo.setNome(nome);
                System.out.println("Informe o valor do Veiculo: ");
                valor = en.nextDouble();
                veiculo.setValor(valor);
                System.out.println("Informe o nome do fabricante do Veiculo: ");
                fabricante = entr.nextLine();
                veiculo.setFabricante(fabricante);
                
                veiculodao.alterar(veiculo);
                break;
            case 5:
                System.out.println("");
                System.out.println("Excluir Veiculo cadastrado por Código ---->: ");
                System.out.println("");
                System.out.println("Informe o Código do Veiculo:");
                cod = en.nextInt();
                veiculo.setId(cod);
                System.out.println("");
                System.out.println("Tem certeza que deseja excluir este Veiculo do ID :" + cod);
                System.out.println("1-SIM");
                System.out.println("2-NÃO");
                int opcao = en.nextInt();
                
                switch (opcao) {
                    case 1:
                        veiculodao.excluir(cod);
                        break;
                    case 2:
                        System.out.println("Operação Cancelada!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        throw new AssertionError();
                }
                
                break;
                
            default:
                System.out.println("Opção inválida!");
                throw new AssertionError();
        }
                
    }
    
}
