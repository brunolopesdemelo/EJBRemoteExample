package sessionbeans;

import java.util.Random;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDadosBean implements LancadorDeDado {
	private Random gerador = new Random();

	public int lanca() {
		return this.gerador.nextInt(1515) + 1;
	}
}
