package Classes;

import java.util.ArrayList;

import javax.swing.*;

public class ProjectMain {
	static ArrayList<Voo> voos = new ArrayList<Voo>();
	static ArrayList<Aviao> aeronaves = new ArrayList<Aviao>();

	public static void main(String[] args) {
		int menu;

		do {
			String temp = "";
			try {
				temp = JOptionPane.showInputDialog("Bem vindo ao Gerenciador de Voos!" + "\n 1 - Parâmetros do Sistema"
						+ "\n 2 - Reserva de Passagens" + "\n 3 - Sair");

				menu = Integer.parseInt(temp);

			} catch (Exception e) {
				menu = temp == null ? 3 : 4;
			}

			switch (menu) {
			case 1:
				Sistema();
				break;
			case 2:
				Reserva();
				break;
			case 3:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Houve um erro! Tente novamente");
				break;
			}
		} while (menu != 3);
	}

	public static void Sistema() {
		int menu = 0;

		do {
			String temp = "";
			try {
				temp = JOptionPane.showInputDialog("Bem vindo ao Gerenciador de Voos!" + "\n 1 - Cadastrar Voo"
						+ "\n 2 - Cadastrar Aeronave" + "\n 3 - Voltar");
				menu = Integer.parseInt(temp);

			} catch (Exception e) {
				menu = temp == null ? 3 : 4;
			}

			switch (menu) {
			case 1:
				CadastrarVoo();
				break;
			case 2:
				CadastrarAeronave();
				break;
			case 3:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Houve um erro! Tente novamente");
				break;
			}
		} while (menu != 3);
	}

	public static void Reserva() {
		int menu = 0;

		do {
			String temp = "";

			try {
				temp = JOptionPane.showInputDialog("Bem vindo ao Gerenciador de Voos!" + "\n 1 - Fazer Reserva"
						+ "\n 2 - Consultar Lugares Vazios" + "\n 3 - Consultar Reservas Realizadas" + "\n 4 - Voltar");
				menu = Integer.parseInt(temp);

			} catch (Exception e) {
				menu = temp == null ? 4 : 5;
			}

			switch (menu) {
			case 1:
				FazerReserva();
				break;
			case 2:
				ConsultarLugaresVazios();
				break;
			case 3:
				ConsultaLugaresReservados();
				break;
			case 4:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Houve um erro! Tente novamente");
				break;
			}
		} while (menu != 4);
	}

	public static void CadastrarAeronave() {
		String modelo;
		int fila = 0, cadeira = 0;
		modelo = JOptionPane.showInputDialog("Cadastrar um Avião:" + "\n Insira o Modelo");
		int laco1 = 0, laco2 = 0;
		do {
			try {
				String aux1 = JOptionPane.showInputDialog("Cadastrar um Avião:" + "\n Insira a Quantidade de Fileiras");
				fila = Integer.parseInt(aux1);
				laco1 = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um número!");
			}
		} while (laco1 != 1);

		do {
			try {
				String aux2 = JOptionPane
						.showInputDialog("Cadastrar um Avião:" + "\n Insira a Quantidade de Cadeiras por Fileira");
				cadeira = Integer.parseInt(aux2);
				laco2 = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um número!");
			}
		} while (laco2 != 1);

		Aviao temp = new Aviao(modelo, fila, cadeira);
		aeronaves.add(temp);

		JOptionPane.showMessageDialog(null,
				"Aeronave '" + aeronaves.get(aeronaves.size() - 1).Modelo + "' cadastrada com Sucesso!");

	}

	public static void CadastrarVoo() {
		String aux, data, hora;
		int aviao = 0, aux2 = 0;
		String listAviao = "";
		for (int i = 0; i < aeronaves.size(); i++) {
			listAviao += "\n " + (i + 1) + " - " + aeronaves.get(i).Modelo;
		}
		do {
			try {
				aux = JOptionPane.showInputDialog("Cadastrar um Voo:" + "\n Selecione o Avião" + listAviao);
				aviao = Integer.parseInt(aux) - 1;
				aux2 = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um número!");
			}
		} while (aux2 != 1);
		data = JOptionPane.showInputDialog("Cadastrar um Voo:" + "\n Selecione a Data de Voo");
		hora = JOptionPane.showInputDialog("Cadastrar um Voo:" + "\n Selecione o Horário do Voo");

		Voo temp = new Voo(aeronaves.get(aviao), (voos.size() + 1), data, hora);

		voos.add(temp);
	}

	public static void FazerReserva() {
		// variáveis
		String listVoos = "", aux = "", nome = "", cpf = "";
		int voo = 0, aux2 = 0, fila = 0, cadeira = 0;

		// Pedir informações do passageiro
		nome = JOptionPane.showInputDialog("Fazer uma Reserva:" + "\n Insira o nome do passageiro");
		cpf = JOptionPane.showInputDialog("Fazer uma Reserva:" + "\n Insira o CPF do passageiro");

		Passageiro pass = new Passageiro(cpf, nome);

		// Pedir informações do Voo
		for (int i = 0; i < voos.size(); i++) {
			listVoos += "\n" + (i + 1) + " - [" + voos.get(i).aviao.Modelo + " | " + voos.get(i).horario + " - "
					+ voos.get(i).data + "]";
		}

		do {
			try {
				aux = JOptionPane.showInputDialog("Fazer uma Reserva:" + "\n Selecione o Voo" + listVoos);
				voo = Integer.parseInt(aux) - 1;
				aux2 = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um número!");
			}
		} while (aux2 != 1);

		int qtdLivre = QuantidadeDisponivel(voos.get(voo));

		if (qtdLivre > 0) {

			boolean ocupado = true;

			do {
				aux2 = 0;

				do {
					try {
						aux = JOptionPane.showInputDialog("Fazer uma Reserva:" + "\n Selecione a Fila");
						fila = Integer.parseInt(aux);
						aux2 = 1;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Insira um número!");
					}
				} while (aux2 != 1);

				aux2 = 0;
				do {
					try {
						aux = JOptionPane.showInputDialog("Fazer uma Reserva:" + "\n Selecione a Cadeira");
						cadeira = Integer.parseInt(aux);
						aux2 = 1;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Insira um número!");
					}
				} while (aux2 != 1);

				ocupado = VerificaLugar(voos.get(voo), fila, cadeira);

				if (ocupado) {
					JOptionPane.showMessageDialog(null, "Lugar Ocupado!");
				} else {
					try {
						voos.get(voo).aviao.lugares[fila - 1][cadeira - 1] = pass;
						JOptionPane.showMessageDialog(null,
								"Passageiro " + pass.nome + " adicionado com sucesso ao Voo");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Escolha de Fila/Cadeira Inválida" + "\n Fila " + fila
								+ " & Cadeira " + cadeira + "\nnão correspondem a um assento existente no Avião");
						ocupado = true;
					}
				}

			} while (ocupado);
		} else {
			JOptionPane.showMessageDialog(null, "Não há lugares disponíveis nesse voo");
		}

	}

	public static boolean VerificaLugar(Voo voo, int fila, int cadeira) {
		boolean retorno;
		try {
			Passageiro verif = voo.aviao.lugares[fila - 1][cadeira - 1];
		} catch (Exception e) {
			return false;
		}
		Passageiro pass = voo.aviao.lugares[fila - 1][cadeira - 1];
		retorno = pass != null ? true : false;

		return retorno;
	}

	public static void ConsultarLugaresVazios() {
		// variáveis
		String listVoos = "", aux = "", nome = "", cpf = "";
		int voo = 0, aux2 = 0, fila = 0, cadeira = 0;

		for (int i = 0; i < voos.size(); i++) {
			listVoos += "\n" + (i + 1) + " - [" + voos.get(i).aviao.Modelo + " | " + voos.get(i).horario + " - "
					+ voos.get(i).data + "]";
		}

		do {
			try {
				aux = JOptionPane.showInputDialog("Consultar Lugares:" + "\n Selecione o Voo" + listVoos);
				voo = Integer.parseInt(aux) - 1;
				aux2 = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um número!");
			}
		} while (aux2 != 1);

		int qtdLivre = QuantidadeDisponivel(voos.get(voo));

		if (qtdLivre > 0) {
			boolean ocupado = true;

			aux2 = 0;

			do {
				try {
					aux = JOptionPane.showInputDialog("Consultar Lugares:" + "\n Selecione a Fila");
					fila = Integer.parseInt(aux);
					aux2 = 1;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insira um número!");
				}
			} while (aux2 != 1);

			aux2 = 0;
			do {
				try {
					aux = JOptionPane.showInputDialog("Consultar Lugaras:" + "\n Selecione a Cadeira");
					cadeira = Integer.parseInt(aux);
					aux2 = 1;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Insira um número!");
				}
			} while (aux2 != 1);

			ocupado = VerificaLugar(voos.get(voo), fila, cadeira);

			try {
				Passageiro temp = voos.get(voo).aviao.lugares[fila - 1][cadeira - 1];

				if (ocupado) {
					JOptionPane.showMessageDialog(null, "Lugar Ocupado!");
				} else {
					JOptionPane.showMessageDialog(null, "Lugar Disponível!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Escolha de Fila/Cadeira Inválida" + "\n Fila " + fila
						+ " & Cadeira " + cadeira + "\nnão correspondem a um assento existente no Avião");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há lugares disponíveis nesse voo");
		}
	}

	public static void ConsultaLugaresReservados() {
		String listVoos = "", aux = "", nome = "", cpf = "";
		int voo = 0, aux2 = 0, fila = 0, cadeira = 0;

		for (int i = 0; i < voos.size(); i++) {
			listVoos += "\n" + (i + 1) + " - [" + voos.get(i).aviao.Modelo + " | " + voos.get(i).horario + " - "
					+ voos.get(i).data + "]";
		}

		do {
			try {
				aux = JOptionPane.showInputDialog("Consultar Reservas:" + "\n Selecione o Voo" + listVoos);
				voo = Integer.parseInt(aux) - 1;
				aux2 = 1;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Insira um número!");
			}
		} while (aux2 != 1);

		String display = MontaMatriz(voo);

		JOptionPane.showMessageDialog(null, "Consultar Reservas:" + "\n Disposição do Voo " + (voo + 1) + " - "
				+ voos.get(voo).aviao.Modelo + "\n" + display + "\nLegenda:" + "\n[X] Ocupado | [_] Livre");
	}

	public static String MontaMatriz(int voo) {
		Passageiro[][] vooConferir = voos.get(voo).aviao.lugares;
		String display = "";
		for (Passageiro[] p1 : vooConferir) {
			for (Passageiro p2 : p1) {
				if (p2 == null) {
					display += "[_]";
				} else {
					display += "[" + p2.nome.substring(0, 1) + "]";
				}
			}
			display += "\n";
		}
		return display;
	}

	public static int QuantidadeDisponivel(Voo voo) {
		Passageiro[][] pass = voo.aviao.lugares;
		int retorno = 0;
		for (Passageiro[] p1 : pass) {
			for (Passageiro p2 : p1) {
				if (p2 == null)
					retorno++;
			}
		}

		return retorno;
	}
}
