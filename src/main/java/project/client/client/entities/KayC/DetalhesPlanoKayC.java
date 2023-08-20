package project.client.client.entities.KayC;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import project.client.client.entities.ClientLog;

@Embeddable
public class DetalhesPlanoKayC implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "movel_id")
	private ClientLog movel;


	public ClientLog getMovel() {
		return movel;
	}
	public void setMovel(ClientLog movel) {
		this.movel = movel;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movel);
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
		return Objects.equals(movel, other.movel);
	}
}
