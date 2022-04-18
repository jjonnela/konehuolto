package fi.onnela.konehuolto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Huolto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long huoltoid;
	private String pvm;
	private String kuvaus;

	@ManyToOne
	@JoinColumn(name = "valmistenumero")
	private Kone kone;

	public Huolto() {

	}

	public Huolto(String pvm, String kuvaus, Kone kone) {
		super();
		this.pvm = pvm;
		this.kuvaus = kuvaus;
		this.kone = kone;
	}

	public Long getHuoltoid() {
		return huoltoid;
	}

	public void setHuoltoid(Long huoltoid) {
		this.huoltoid = huoltoid;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public Kone getKone() {
		return kone;
	}

	public void setKone(Kone kone) {
		this.kone = kone;
	}

}
