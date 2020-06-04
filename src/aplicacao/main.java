package aplicacao;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entidades.Cliente;
import entidades.Hospedagem;
import entidades.TipoAcomodacao;
public class main {
        
	public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Cliente> listCliente = new ArrayList<>();
        List<Hospedagem> listHospedagem = new ArrayList<>();
        
        int opcao = 0;
        do {
            System.out
                    .println("\n\n### HOTEL - ALABAMA ###");
            System.out.println("\n                  ===============================");
            System.out.println("                  |     1 - Cadastro reserva    |");
            System.out.println("                  |     2 - Fechamento de conta |");
            System.out.println("                  |     3 - Relatório diário    |");
            System.out.println("                  |     0 - Sair                |");
            System.out.println("                  ===============================\n");
            
            System.out.print("Opção -> ");
            opcao = sc.nextInt();
            System.out.print("\n");
    
        switch (opcao) {
        case 1:
          System.out.println("# Informe o NOME e RG para consulta #");
          System.out.println("Nome: ");
          String nome = sc.next();
          System.out.println("RG: ");
          double rg = sc.nextDouble();
          
          Cliente cliente = listCliente.stream().filter(x -> x.getRg() == rg).findFirst().orElse(null);
          if(cliente != null){
              System.out.println("Usuário já cadastrado.");
              System.out.println("# Cadastro de Hospedagem");
              System.out.print("Insira o código do cliente: ");
              int codigoCliente = sc.nextInt(); 
              System.out.print("Tipo acomocadacao (1-simples/2-dupla/3-tripla): ");
              int codigoTipoAcomodacao = sc.nextInt(); 
              TipoAcomodacao tipoAcomodacao = new TipoAcomodacao();
              tipoAcomodacao.verificaAcomodacao(codigoTipoAcomodacao);
              System.out.print("Data inicio: ");
              String dataEntrada = sc.next();
              System.out.print("Data saída: ");
              String dataSaida = sc.next();
              listHospedagem.add(new Hospedagem(dataEntrada, dataSaida, codigoTipoAcomodacao, codigoCliente));
          } else {
              System.out.println("Usuário não cadastrado.");
              System.out.println("\n");  
              System.out.println("# Novo cliente");
              System.out.println("\n");  
              System.out.println("Nome - " + nome);
              System.out.println("RG - " + rg);
              System.out.print("Código cliente: ");
              int codigoCliente = sc.nextInt();
              System.out.println("Endereço: ");
              String endereco = sc.next();
              System.out.println("Telefone: ");
              double telefone = sc.nextDouble();
              System.out.println("Bairro: ");
              String bairro = sc.next();
              System.out.println("Estado: ");
              String estado = sc.next();
              System.out.println("Cidade: ");
              String cidade = sc.next();
              System.out.println("Data de Nascimento: ");
              Date dataNascimento = sdf.parse(sc.next());
              System.out.println("Cadastro realizado com sucesso!");
              System.out.println("\n");   
              System.out.println("# Cadastro de Hospedagem");
              System.out.print("Tipo acomocadacao (1-simples/2-dupla/3-tripla): ");
              int numeroTipo = sc.nextInt(); 
              TipoAcomodacao tipoAcomodacao = new TipoAcomodacao();
              tipoAcomodacao.verificaAcomodacao(numeroTipo);
              System.out.print("Data inicio: ");
              String dataEntrada = sc.next();
              System.out.print("Data saída: ");
              String dataSaida = sc.next();
              System.out.println("Valor pago na reserva: ");
              int valorEntrada = sc.nextInt();
              listHospedagem.add(new Hospedagem(valorEntrada, dataEntrada, dataSaida, numeroTipo, codigoCliente, nome, endereco, telefone, bairro, cidade, estado, rg, dataNascimento));
          }
          break;
        case 2:
            System.out.println("# Fechamento da Hospedagem ");
            System.out.println("Informe o código do cliente: ");
            int codCliente = sc.nextInt();
            Hospedagem hospedagem  = listHospedagem.stream().filter(x -> x.getCodigo() == codCliente).findFirst().orElse(null);
            if (hospedagem != null){
	            System.out.println("Nome: " + hospedagem.getNome());
	            System.out.println("Data de entrada: " + hospedagem.getDataEntrada());
	            System.out.println("Data de saída: " + hospedagem.getDataSaida());
	            System.out.println("Diarias: " + hospedagem.totalDiarias());
	            System.out.println("Total das diarias: " + hospedagem.totalDiariaValor());
	            System.out.println("Total do consumo: "+ hospedagem.totalConsumo());
	            System.out.println("Valo pago na reserva: "+ hospedagem.getValorEntrada());
	            System.out.println("Total a pagar: " + ((hospedagem.totalConsumo() + hospedagem.totalDiariaValor()) - hospedagem.getValorEntrada()));
            }
            else {
            	System.out.println("CLIENTE NAO LOCALIZADO");
            }                    
            break;
        case 3:
            System.out.println("# Relatório diário ");
                listHospedagem.stream().forEach(Hospedagem->Hospedagem.consumoDiario());
            break;
        default:
          System.out.println("Erro.");
          break;
      }        
    } while (opcao != 0);
        sc.close();
		}
    
}