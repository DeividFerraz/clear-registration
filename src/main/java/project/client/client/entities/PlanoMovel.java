package project.client.client.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
	
	@OneToMany(mappedBy = "id.log")
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
	
	
	public Set<DetalhesPlano> getDetails() {
		return details;
	}

	public void setDetails(Set<DetalhesPlano> details) {
		this.details = details;
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
		PlanoMovel other = (PlanoMovel) obj;
		return Objects.equals(id, other.id);
	}
}
