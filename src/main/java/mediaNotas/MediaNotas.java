package mediaNotas;

import java.util.LinkedHashMap;

public class MediaNotas {
	int nota1;
	int nota2;
	public MediaNotas(int nota1, int _nota2) {
		this.nota1 = nota1;
		nota2 = _nota2;
	}
	public String getResultado() {
		int soma = nota1+nota2;
		if (soma < 12) {
			return "Reprovado";
		}
		return "Aprovado";
	}
	
	public void Teste() {
		String tempo = "ensolarado";
		String resultado = "";
		
		switch (tempo) {
		case "ensolarado":
			resultado = "saia de casa com mascara";
			break;
		case "chovendo":
			resultado = "saia de casa com mascara e guarda chuva";
			break;
		case "nevando":
			resultado = "Fique em casa";
			break;
		default:
			break;
		}
	}
	
	public void TesteMap() {
		String tempo = "chovendo";
		String resultado = "";
		
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("ensolarado", "saia de casa com mascara");
		map.put("chovendo", "saia de casa com mascara e guarda chuva");
		map.put("nevando", "Fique em casa");
		
		resultado = map.get(tempo);
	}

}
