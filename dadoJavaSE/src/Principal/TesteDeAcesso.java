package Principal;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sessionbeans.LancadorDeDado;

public class TesteDeAcesso {

	private static LancadorDeDado lookupCalculatorEJB() throws NamingException {
		final Hashtable jndiProperties = new Hashtable();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		return (LancadorDeDado) context.lookup("ejb:/dadoWeb/LancadorDeDadoBean!sessionbeans.LancadorDeDado");

	}

	public static void main(String[] args) {
		TesteDeAcesso ta = new TesteDeAcesso();
		try {
			LancadorDeDado lancadorDados = ta.lookupCalculatorEJB();

			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 100; i++) {
						System.out.println(lancadorDados.lanca());
					}
				}
			});
			thread.start();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}