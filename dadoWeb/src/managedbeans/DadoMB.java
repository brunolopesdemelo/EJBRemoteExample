package managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import sessionbeans.LancadorDeDado;

@ManagedBean
public class DadoMB {
	@EJB
	private LancadorDeDado lancadorDeDadoBean;
	private int resultado;

	public void lancarDado() {
		this.resultado = this.lancadorDeDadoBean.lanca();
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

}
