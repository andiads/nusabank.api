package com.andiads.nusabank.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="rekening")
public class Rekening implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1463205244477712491L;

	@Id
	@Column(name="id_rekening")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(
					name = "gen",
					strategy = "foreign",
					parameters = { @Parameter(name = "property", value = "nasabah") }
	)
	private int id;
	
	@Column(name="no_rekening")
	private String noRekening;
	
	private int saldo;
	
	@Column(name="jenis_rekening")
	private String jenisRekening;
	
	@Column(name="no_pin")
	private int noPIN;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Nasabah nasabah;
	
	public Rekening() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoRekening() {
		return noRekening;
	}

	public void setNoRekening(String noRekening) {
		this.noRekening = noRekening;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getJenisRekening() {
		return jenisRekening;
	}

	public void setJenisRekening(String jenisRekening) {
		this.jenisRekening = jenisRekening;
	}

	public int getNoPIN() {
		return noPIN;
	}

	public void setNoPIN(int noPIN) {
		this.noPIN = noPIN;
	}
	
	public Nasabah getNasabah() {
		return nasabah;
	}

	public void setNasabah(Nasabah nasabah) {
		this.nasabah = nasabah;
	}

	@Override
	public String toString() {
		return "id="+id
				+", no_rekening="+noRekening
				+", saldo="+saldo
				+", jenis_rekening="+jenisRekening
				+", no_pin="+noPIN;
	}
}
