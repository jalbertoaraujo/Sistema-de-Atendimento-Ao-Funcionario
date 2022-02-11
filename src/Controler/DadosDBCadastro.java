package Controler;

public class DadosDBCadastro {
	
	private Integer id_atendimento;
	private String hora;
	private String data;
	private String atendente;
	private String nomecol;
	private String matricula;
	private String cpf;
	private String contrato;
	private String fone;
	private String fone2;
	private String setor;
	private String pendencia;
	private String setoratendente;
	private String enviado;
	
	
	public Integer getId_atendimento() {
		return id_atendimento;
	}
	public void setId_atendimento(Integer id_atendimento) {
		this.id_atendimento = id_atendimento;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAtendente() {
		return atendente;
	}
	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}
	public String getNomecol() {
		return nomecol;
	}
	public void setNomecol(String nomecol) {
		this.nomecol = nomecol;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	public String getFone2() {
		return fone2;
	}
	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getPendencia() {
		return pendencia;
	}
	public void setPendencia(String pendencia) {
		this.pendencia = pendencia;
	}
	public String getSetoratendente() {
		return setoratendente;
	}
	public void setSetoratendente(String setoratendente) {
		this.setoratendente = setoratendente;
	}
	public String getEnviado() {
		return enviado;
	}
	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}
	
	
	public DadosDBCadastro(Integer id_atendimento, String hora, String data,
			String atendente, String nomecol, String matricula, String cpf,
			String contrato, String fone, String fone2, String setor, String pendencia, String setoratendente, String enviado) {
		super();
		this.id_atendimento = id_atendimento;
		this.hora = hora;
		this.data = data;
		this.atendente = atendente;
		this.nomecol = nomecol;
		this.matricula = matricula;
		this.cpf = cpf;
		this.contrato = contrato;
		this.fone = fone;
		this.fone2 = fone2;
		this.setor = setor;
		this.pendencia = pendencia;
		this.setoratendente = setoratendente;
		this.enviado = enviado;
	}
	
	
	@Override
	public String toString() {
		return "DadosDBCadastro [id_atendimento=" + id_atendimento + ", hora="
				+ hora + ", data=" + data + ", atendente=" + atendente
				+ ", nomecol=" + nomecol + ", matricula=" + matricula
				+ ", cpf=" + cpf + ", contrato=" + contrato + ", fone=" + fone
				+ ", fone2=" + fone2 + ", setor=" + setor + ", pendencia=" + pendencia + ", setoratendente=" + setoratendente +", enviado=" + enviado +"]";
	}
	
}
