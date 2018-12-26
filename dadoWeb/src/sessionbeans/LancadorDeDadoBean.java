package sessionbeans;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {
	private Random gerador = new Random();
	private static int contador;

	@PostConstruct
	void inicializando() {
		synchronized (LancadorDeDado.class) {
			LancadorDeDadoBean.contador++;
			System.out.println("Criando um lançador de dados...");
			System.out.println("Total" + LancadorDeDadoBean.contador);
		}
	}

	@PreDestroy
	public void destruindo() {
		synchronized (LancadorDeDado.class) {
			LancadorDeDadoBean.contador--;
			System.out.println("Destruindo um lançador de dados...");
			System.out.println("Total : " + LancadorDeDadoBean.contador);
		}
	}

	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}
}
