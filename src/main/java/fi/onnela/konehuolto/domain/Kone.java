package fi.onnela.konehuolto.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Kone {

	@Id
	private String valmistenumero;
	private String merkki, malli, tyyppi;
	private int vuosi;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kone")
	private List<Huolto> huollot;

	public Kone() {

	}

	public Kone(String valmistenumero, String merkki, String malli, String tyyppi, int vuosi) {
		super();
		this.valmistenumero = valmistenumero;
		this.merkki = merkki;
		this.malli = malli;
		this.tyyppi = tyyppi;
		this.vuosi = vuosi;
	}

	public String getValmistenumero() {
		return valmistenumero;
	}

	public void setValmistenumero(String valmistenumero) {
		this.valmistenumero = valmistenumero;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public String getTyyppi() {
		return tyyppi;
	}

	public void setTyyppi(String tyyppi) {
		this.tyyppi = tyyppi;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public List<Huolto> getHuollot() {
		return huollot;
	}

	public void setHuollot(List<Huolto> huollot) {
		this.huollot = huollot;
	}

}
