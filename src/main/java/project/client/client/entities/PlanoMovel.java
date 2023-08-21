package project.client.client.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_planoMovel")
public class PlanoMovel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String plano;
	private String price;
	@Lob
	private String planoCompleto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "flat")
	private List<ClientLog> orders = new ArrayList<>();

	@OneToMany(mappedBy = "id.movel")
	private Set<DetalhesPlano> details = new HashSet<>();
	
	public PlanoMovel() {
	}

	public PlanoMovel(Long id, String plano, String price, String planoCompleto) {
		super();
		this.id = id;
		this.plano = plano;
		this.price = price;
		this.planoCompleto = planoCompleto;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPlanoCompleto() {
		return planoCompleto;
	}

	public void setPlanoCompleto(String planoCompleto) {
		this.planoCompleto = planoCompleto;
	}

	@JsonIgnore//Ao chamar o order/1 vai vir o producst pendurado no pedido
	public Set<ClientLog> getItems() {
		Set<ClientLog> set = new HashSet<>();
		for (DetalhesPlano x : details) {
			set.add(x.getLog());
		}
		return set;
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
		PlanoMovel other = (PlanoMovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
