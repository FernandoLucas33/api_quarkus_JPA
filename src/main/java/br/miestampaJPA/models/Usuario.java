package br.miestampaJPA.models;


import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;

@NamedNativeQueries(
        {
                @NamedNativeQuery(name="LISTA_USUARIOS", query = "SELECT id, nome, cpf, email, password  from bblite.USUARIO", resultClass = Usuario.class),
                @NamedNativeQuery(name="INSERI_USUARIO", query ="INSERT INTO bblite.USUARIO ( nome, cpf, email, password ) VALUES ( :nome, :cpf, :email, :password);"),
                @NamedNativeQuery(name="ATUALIZA_USUARIO", query ="UPDATE bblite.USUARIO SET nome = :nome, cpf = :cpf, email = :email, password = :password WHERE id = :idUsuario"),
                @NamedNativeQuery(name="EXCLUI_USUARIO", query="DELETE bblite.USUARIO WHERE id = :idUsuario"),
                @NamedNativeQuery(name="LISTA_USUARIO_ID", query = "SELECT id, nome, cpf, email, password FROM bblite.USUARIO WHERE id = :idUsuario", resultClass = Usuario.class)
        }
)

@Entity
@Table(name ="USUARIO", schema = "bblite")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID", nullable = false)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
