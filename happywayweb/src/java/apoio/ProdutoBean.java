/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Produto;

/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class ProdutoBean {
    
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    
    public ProdutoBean(){
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public List<Produto> getProdutos() {
        if (this.produtos == null) {
            EntityManager em = JPAUtil.getEntityManager();
            Query p = em.createQuery("select p from Produto p",
                    Produto.class);
            this.produtos = p.getResultList();
            em.close();
        }
        
        return produtos;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            Produto p = em.find(Produto.class, produto.getCodigo());
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (p != null) {
                //Atualiza os dados da pessoa.
                produto = em.merge(produto);
            } else {
                //Salva os dados da pessoa.
                em.persist(produto);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.produto = null;
        return "produtos";
    }
}
