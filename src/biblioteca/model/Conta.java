package biblioteca.model;

public abstract class Conta {
	
	private int usuario;
	private String nome;
	private String email;
	private String telefone;
	private int tipo;
	
	public Conta(int usuario, String nome, String email, String telefone, int tipo) {
		this.usuario = usuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	public void visualizar() {
		String tipo = "";
		
		switch (this.tipo) {
		case 1:
			tipo = "Conta Premium";
			break;
		case 2:
			tipo = "Conta Normal";
			break;
		}
	System.out.println("\n\n***********************************************************");
	System.out.println("Dados da Conta: ");
	System.out.println("***********************************************************");
	System.out.println("Usuário da Conta: "+this.usuario);
	System.out.println("Nome da Conta: " + this.nome);
	System.out.println("Email: " +this.email);
	System.out.println("Telefone: " + this.telefone);
	System.out.println("Tipo: " + tipo);
	
	}
	
}
