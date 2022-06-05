package Classes;

public class Aviao extends Aeronave 
{
	public Passageiro[][] lugares;
	
	public Aviao(String Modelo, int a, int b) 
	{
		super(Modelo);
		lugares = new Passageiro[a][b];
	}
	
	public boolean VerificaLugarOcupado(int a, int b)
	{
		return lugares[a][b] == null ? false : true;
	}
	
	public Passageiro GetPassageiro(int a, int b)
	{
		return lugares[a][b];
	}
	
	public void SetPassageiro(int a, int b, Passageiro pass)
	{
		this.lugares[a][b] = pass;
	}

} 
