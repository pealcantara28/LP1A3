package Classes;

public class Aeronave 
{
	protected String Modelo;
	
	public Aeronave(String Modelo)
	{
		this.Modelo = Modelo;
	}

	public String getModelo() 
	{
		return Modelo;
	}

	public void setModelo(String modelo) 
	{
		Modelo = modelo;
	}
}
