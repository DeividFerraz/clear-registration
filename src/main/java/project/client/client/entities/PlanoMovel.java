package project.client.client.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_planoMovel")
public class PlanoMovel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String plano;
	private String price;
	@Column(length = 1000)
	private String planoCompleto;
	
	@JsonIgnore
	@OneToMany(mappedBy = "flat")
	private List<ClientLog> orders = new ArrayList<>();
	
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
