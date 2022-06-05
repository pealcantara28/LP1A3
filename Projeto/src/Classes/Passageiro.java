package Classes;

public class Passageiro 
{
	public String nome,cpf;
	
	public Passageiro(String cpf, String nome)
	{
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getNome() 
	{
		return nome;
	}

	public String getCpf() 
	{
		return cpf;
	}
}
