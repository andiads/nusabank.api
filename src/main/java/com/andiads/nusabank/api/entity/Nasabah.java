package com.andiads.nusabank.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
@Table(name="nasabah")
@JsonIgnoreProperties(value = {"passwordNasabah", "namaIbu", "rekening", "contactNumber", "email"})
public class Nasabah implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6215150138510329158L;

	@Id
	@Column(name="id_nasabah")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="nik")
	private String nik;
	
	@Column(name="tgl_lahir")
	private String tglLahir;
	
	private String alamat;
	
	private String photo;
	
	@Column(name="jenis_kelamin")
	private String gender;
	
	private String pekerjaan;
	
	@Column(name="alamat_kantor")
	private String alamatKantor;
	
	private int pendapatan;
	
	private String email;
	
	@Column(name="no_hp")
	private String contactNumber;
	
	private String status;
	
	@Column(name="nama_ibu")
	private String namaIbu;
	
	@Column(name="username_nasabah")
	private String usernameNasabah;
	
	@Column(name="password_nasabah")
	private String passwordNasabah;
	
	@Column(name="tgl_pembuatan")
	private String joinDate;
	
	@OneToOne(mappedBy = "nasabah")
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	private Rekening rekening;

	public Nasabah() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getTglLahir() {
		return tglLahir;
	}

	public void setTglLahir(String tglLahir) {
		this.tglLahir = tglLahir;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPekerjaan() {
		return pekerjaan;
	}

	public void setPekerjaan(String pekerjaan) {
		this.pekerjaan = pekerjaan;
	}

	public String getAlamatKantor() {
		return alamatKantor;
	}

	public void setAlamatKantor(String alamatKantor) {
		this.alamatKantor = alamatKantor;
	}

	public int getPendapatan() {
		return pendapatan;
	}

	public void setPendapatan(int pendapatan) {
		this.pendapatan = pendapatan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNamaIbu() {
		return namaIbu;
	}

	public void setNamaIbu(String namaIbu) {
		this.namaIbu = namaIbu;
	}

	public String getUsernameNasabah() {
		return usernameNasabah;
	}

	public void setUsernameNasabah(String usernameNasabah) {
		this.usernameNasabah = usernameNasabah;
	}

	public String getPasswordNasabah() {
		return passwordNasabah;
	}

	public void setPasswordNasabah(String passwordNasabah) {
		this.passwordNasabah = passwordNasabah;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public Rekening getRekening() {
		return rekening;
	}

	public void setRekening(Rekening rekening) {
		this.rekening = rekening;
	}
	
	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
	      
	      String jsonString = "";
	    try {
	      mapper.enable(SerializationFeature.INDENT_OUTPUT);
	      jsonString = mapper.writeValueAsString(this);
	    } catch (JsonProcessingException e) {
	      e.printStackTrace();
	    }
	    
	      return jsonString;
	}


}

