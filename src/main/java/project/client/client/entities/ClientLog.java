package project.client.client.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_clients")
public class ClientLog implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String name;
	private String phone;
	private String cep;
	private String numResidencia;
	private String complemento;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private PlanoMovel flat;
	
	//Coleção Relacionada a classe DetalhesPlanoKayC
	@OneToMany(mappedBy = "id.log", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<DetalhesPlano> details = new HashSet<>();

	
	public ClientLog() {
	}

	public ClientLog(Long id, String cpf, String name, String phone, String cep, String numResidencia, String complemento, String email, PlanoMovel flat) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.phone = phone;
		this.cep = cep;
		this.numResidencia = numResidencia;
		this.complemento = complemento;
		this.email = email;
		this.flat = flat;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumResidencia() {
		return numResidencia;
	}

	public void setNumResidencia(String numResidencia) {
		this.numResidencia = numResidencia;
	}
	
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PlanoMovel getFlat() {
	return flat;
	}

	public void setFlat(PlanoMovel flat) {
		this.flat = flat;
	}


	public Set<DetalhesPlano> getDetails(){
		return details;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientLog other = (ClientLog) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

}
