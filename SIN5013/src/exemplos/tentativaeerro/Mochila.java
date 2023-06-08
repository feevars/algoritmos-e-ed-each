package exemplos.tentativaeerro;

import java.util.List;

/**
 * @author Fernanda Reis
 *
 */
public class Mochila {

	private Double capacidade;
	private List<Objeto> objetos;

	public Mochila(Double capacidade) {
		super();
		this.capacidade = capacidade;
	}

	public Double getCapacidade() {
		return capacidade;
	}

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}
	
}
