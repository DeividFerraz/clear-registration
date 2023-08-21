package project.client.client.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import project.client.client.entities.KayC.DetalhesPlanoKayC;

@Entity
@Table(name="tb_detalhes_plano")
public class DetalhesPlano implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalhesPlanoKayC id = new DetalhesPlanoKayC();
	
	private String planoAtual;
	private String dataVencimento;
	private String status;
	private Instant contratadoEm = Instant.now(); // Definindo a data e hora atuais aqui
	
	public DetalhesPlano() {
		
	}

	public DetalhesPlano( ClientLog log, PlanoMovel movel, String planoAtual, String dataVencimento, String status, Instant contratadoEm) {
		super();
		//plano1.setPlano(plano1.getPlano());
		id.setMovel(movel);
		id.setLog(log);
		this.planoAtual = planoAtual;
		this.dataVencimento = dataVencimento;
		this.status = status;
		this.contratadoEm = contratadoEm;
	}

	@JsonIgnore
	public ClientLog getLog(){
		return id.getLog();
	}

	public void seLog(ClientLog log) {
		id.setLog(log);//estou jogando o plano dentro de DetalhesPlanoKayC
	}
	
	public PlanoMovel getMovel() {
		return id.getMovel();
	}
	
	public void setMovel(PlanoMovel movel) {
		id.setMovel(movel);
	}
	
	public String getPlanoAtual() {
		return planoAtual;
	}

	public void setPlanoAtual(String planoAtual) {
		this.planoAtual = planoAtual;
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
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .withZone(ZoneId.of("America/Sao_Paulo"));
        return formatter.format(contratadoEm);
	}

	public void setContratadoEm(Instant contratadoEm) {
		this.contratadoEm = contratadoEm;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	//Só o campo Id identifica esse item complementar das classes  log e movel

}
