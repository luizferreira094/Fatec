package br.scp.controle;

import br.scp.modelo.Empresa;

public class Controle {
	Empresa empresa;
	public Controle() {
		empresa = new Empresa();
	}
	public String setAtributos(String cnpj, String rs, int he, int hs, int cj1, int cj2, int cj3, int temp, int hi, int ht) {
		String msg = "";
		try {
			empresa.setCnpj(cnpj);
			empresa.setRazaoSocial(rs);
			empresa.setHorarioEntrada(he);
			empresa.setHorarioSaida(hs);
			empresa.setConjuntos(cj1);
			empresa.setConjuntos(cj2);
			empresa.setConjuntos(cj3);
			empresa.setTemperaturaMaxima(temp);
			empresa.setTemperaturaHI(hi);
			empresa.setTemperaturaHT(ht);
			msg = "cadastro realizado com sucesso";
		} catch (Exception e) {
			msg = "dados invalidos";
		}
		return msg;
	}
}
