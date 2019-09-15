package Model;

public class UserBean {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public UserBean(String email, String senha, String... nome) {
        this.email = email;
        this.senha = senha;
        this.nome = nome.length > 0 ? nome[0] : "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
