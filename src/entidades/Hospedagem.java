package entidades;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Hospedagem extends Cliente {   
    private int codigoTipoAcomodacao, valorEntrada;
    private String dataEntrada;
    private String dataSaida;
    private int usoAlimentacao = 15;
    private int usoTelefone = 6;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public Hospedagem() {}
    public Hospedagem(int valorEntrada, String dataEntrada, String dataSaida, int codigoTipoAcomodacao, int codigo, String nome, String endereco, double telefone, String bairro, 
            String cidade, String estado, double rg, Date dataNascimento) {
        super(codigo, nome, endereco, telefone, bairro, cidade, estado, rg, dataNascimento);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.setCodigoTipoAcomodacao(codigoTipoAcomodacao);
        this.valorEntrada = valorEntrada;
    }
    public Hospedagem(String dataEntrada, String dataSaida, int codigoTipoAcomodacao, int codigo) {
        super(codigo);
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.setCodigoTipoAcomodacao(codigoTipoAcomodacao);
    }   
    public String getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public String getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }    
    public long totalDiarias() {        
          long diff = -1;
          try {
            Date dataEntrada = sdf.parse(this.dataEntrada);
            Date dataSaida = sdf.parse(this.dataSaida); 
            //time is always 00:00:00, so rounding should help to ignore the missing hour when going from winter to summer time, as well as the extra hour in the other direction
            diff = Math.round((dataSaida.getTime() - dataEntrada.getTime()) / (double) 86400000);
          } catch (Exception e) {
            System.out.println("ERRO: DATA DE ENTRADA APÓS DATA DE SAIDA");
          }
          return diff;
    }   

   
    public double totalConsumo () {
		double total;
		total = ((usoAlimentacao * usoTelefone) * totalDiarias());;     	
    	return total;    	
    }
    
    public double totalDiariaValor() {
    	double valor;
    	valor = totalDiarias() * TipoAcomodacao.valorAcomodacao(codigoTipoAcomodacao);
		return valor;    	
    }
    
    public void consumoDiario() {     	
        long dias = -1;
        long consumo;
        try {
          Date dataEntrada = sdf.parse(this.dataEntrada);
          Date dataSaida = Calendar.getInstance().getTime(); 
          //time is always 00:00:00, so rounding should help to ignore the missing hour when going from winter to summer time, as well as the extra hour in the other direction
          dias = Math.round((dataSaida.getTime() - dataEntrada.getTime()) / (double) 86400000);
        } catch (Exception e) {
          System.out.println("ERRO: DATAS INCOMPATIVEIS");
        }
        consumo = dias * (int)totalConsumo();
        System.out.println("O consumo do cliente " + getNome()+ " até a data de hoje é de : R$ " + consumo + ",em um total de " + dias + " dias" );        
  }   
    
    @Override
    public String toString() {
        return "Reserva - cliente=" + getNome()
                + ", dataEntrada=" + dataEntrada 
                + ", dataSaida=" + dataSaida + "]";
    }
	public int getCodigoTipoAcomodacao() {
		return codigoTipoAcomodacao;
	}
	public void setCodigoTipoAcomodacao(int codigoTipoAcomodacao) {
		this.codigoTipoAcomodacao = codigoTipoAcomodacao;
	}
	public int getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(int valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
    
}