package com.freeacess.entity;

import com.freeacess.exception.EntityException;

public class Employer {

	private int id;
	private int user_id;
	private String full_name;
	private String date_birth;
	private Long cell_phone;
	private String cpf;
	private String rg;
	private String adress;
	private String email;

	public Employer() {
		this.id = 0;
		this.user_id = 0;
		this.full_name = null;
		this.date_birth = null;
		this.cell_phone = null;
		this.cpf = null;
		this.rg = null;
		this.adress = null;
		this.email = null;
	}

	private Employer(Employer.EmployerBuilder builder) throws EntityException {
		super();
		setId(builder.id);
		setUserId(builder.user_id);
		setFullName(builder.full_name);
		setDateBirth(builder.date_birth);
		setCellPhone(builder.cell_phone);
		setCpf(builder.cpf);
		setRg(builder.rg);
		setAdress(builder.adress);
		setEmail(builder.email);
	}

	public static class EmployerBuilder {
		private int id;
		private int user_id;
		private String full_name;
		private String date_birth;
		private Long cell_phone;
		private String cpf;
		private String rg;
		private String adress;
		private String email;

		public EmployerBuilder() {
		}

		public EmployerBuilder(int id, String full_name, String date_birth, Long cell_phone, String cpf, String rg,
				String adress, String email, int user_id) {

			super();
			this.id = id;
			this.full_name = full_name;
			this.date_birth = date_birth;
			this.cell_phone = cell_phone;
			this.cpf = cpf;
			this.rg = rg;
			this.adress = adress;
			this.email = email;
			this.user_id = user_id;

		}

		public EmployerBuilder setId(int id) {
			this.id = id;
			return this;
		}

		public EmployerBuilder setUserId(int user_id) {
			this.user_id = user_id;
			return this;
		}

		public EmployerBuilder setFullName(String full_name) {
			this.full_name = full_name;
			return this;
		}

		public EmployerBuilder setDateBirth(String date_birth) {
			this.date_birth = date_birth;
			return this;
		}

		public EmployerBuilder setCellPhone(Long cell_phone) {
			this.cell_phone = cell_phone;
			return this;
		}

		public EmployerBuilder setCpf(String cpf) {
			this.cpf = cpf;
			return this;
		}

		public EmployerBuilder setRg(String rg) {
			this.rg = rg;
			return this;
		}

		public EmployerBuilder setAdress(String adress) {
			this.adress = adress;
			return this;
		}

		public EmployerBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Employer build() throws EntityException {
			return new Employer(this);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getFullName() {
		return full_name;
	}

	public void setFullName(String full_name) {
		this.full_name = full_name;
	}

	public String getDateBirth() {
		return date_birth;
	}

	public void setDateBirth(String date_birth) {
		this.date_birth = date_birth;
	}

	public Long getCellPhone() {
		return cell_phone;
	}

	public void setCellPhone(Long cell_phone) {
		this.cell_phone = cell_phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}