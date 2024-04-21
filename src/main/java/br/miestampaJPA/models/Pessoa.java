package br.miestampaJPA.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@NamedNativeQueries(
        {       @NamedNativeQuery(name="LISTA_PESSOA", query = "SELECT idPessoa, nome, sobrenome from loja.PESSOAS", resultClass = Pessoa.class),
                @NamedNativeQuery(name="INSERIR_PESSOA", query ="INSERT INTO loja.PESSOAS (idPessoa, nome, sobrenome) VALUES ( :idPessoa, :nome, :sobrenome);"),
                @NamedNativeQuery(name="EXCLUIR_PESSOA", query="DELETE FROM loja.PESSOAS WHERE idPessoa = :idPessoa"),
                @NamedNativeQuery(name="CONSULTA_USUARIO_ID", query = "SELECT idpessoa, nome, sobrenome FROM loja.PESSOAS WHERE idPessoa = :idPessoa", resultClass = Pessoa.class)
        }
)
@Entity
@Table(name="PESSOAS")
public class Pessoa  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;
    private String nome;
    private String sobrenome;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
