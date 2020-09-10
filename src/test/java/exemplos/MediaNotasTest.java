package exemplos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mediaNotas.MediaNotas;

public class MediaNotasTest {
	//duas notas, receber o resultado
	//media menor que 6, reprovado
	//media maior ou igual a 6, aprovado
	@Test
	public void testReprovado() {
		int nota1 = 5;
		int nota2 = 5;
		String resultado = "";
		MediaNotas mediaNotas = new MediaNotas(nota1, nota2);
		resultado = mediaNotas.getResultado();
		assertEquals("Reprovado", resultado);
	}
	@Test
	public void testAprovado() {
		String resultado = "";
		MediaNotas mediaNotas = new MediaNotas(6, 6);
		resultado = mediaNotas.getResultado();
		assertEquals("Aprovado", resultado);
	}
	
}
