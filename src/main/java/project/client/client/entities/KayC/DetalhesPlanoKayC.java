package project.client.client.entities.KayC;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import project.client.client.entities.ClientLog;
import project.client.client.entities.PlanoMovel;

@Embeddable
public class DetalhesPlanoKayC implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "log_id")
	private ClientLog log;
	
	@ManyToOne
	@JoinColumn(name = "movel_id")
	private PlanoMovel movel;
	
	public ClientLog getLog() {
		return log;
	}
	public void setLog(ClientLog log) {
		this.log = log;
	}
	public PlanoMovel getMovel() {
		return movel;
	}
	public void setMovel(PlanoMovel movel) {
		this.movel = movel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(log, movel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalhesPlanoKayC other = (DetalhesPlanoKayC) obj;
		return Objects.equals(log, other.log) && Objects.equals(movel, other.movel);
	}
}
