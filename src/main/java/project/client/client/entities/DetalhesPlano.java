package project.client.client.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import project.client.client.entities.KayC.DetalhesPlanoKayC;

@Entity
@Table(name="tb_detalhes_plano")
public class DetalhesPlano implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalhesPlanoKayC id;
	
	private PlanoMovel plano;
	private String dataVencimento;
	private String status;
	private String contratadoEm;
	
	public DetalhesPlano() {
		
	}

	public DetalhesPlano(PlanoMovel plano, String dataVencimento, String status, String contratadoEm) {
		super();
		id.setMovel(plano);
		this.dataVencimento = dataVencimento;
		this.status = status;
		this.contratadoEm = contratadoEm;
	}

	public PlanoMovel getPlano() {
		return id.getMovel();
	}

	public void setPlano(PlanoMovel plano) {
		id.setMovel(plano);//estou jogando o plano dentro de DetalhesPlanoKayC
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContratadoEm() {
		return contratadoEm;
	}

	public void setContratadoEm(String contratadoEm) {
		this.contratadoEm = contratadoEm;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalhesPlano other = (DetalhesPlano) obj;
		return Objects.equals(id, other.id);
	}
	//Só o campo Id identifica esse item complementar das classes  log e movel
}
