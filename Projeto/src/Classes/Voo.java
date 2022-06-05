package Classes;

public class Voo 
{
	public Aviao aviao;
	public int nro;
	public String data;
	public String horario;
	
	public Voo(Aviao aviao, int nro, String data, String horario) 
	{
		this.aviao = aviao;
		this.nro = nro;
		this.data = data;
		this.horario = horario;
	}

	public int getNro() {
		return nro;
	}

	public String getData() {
		return data;
	}

	public String getHorario() {
		return horario;
	}
}
