package Controler;

public class DadosDBCadastro2 {
	
	private Integer id_email;
	private String email;
	
	public Integer getId_email() {
		return id_email;
	}
	public void setId_email(Integer id_email) {
		this.id_email = id_email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public DadosDBCadastro2(Integer id_email, String email) {
		super();
		this.id_email = id_email;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "DadosDBCadastro2 [id_email=" + id_email + ", email=" + email + "]";
	}
	
}
