/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ClientePJ;


/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class ClientePJBean {
    
    private ClientePJ clientePJ = new ClientePJ();
    private List<ClientePJ> clientesPJ = new ArrayList<>();
    private long total;


    public long getTotal() {
        
        EntityManager em = JPAUtil.getEntityManager();
        Query p = em.createQuery("select count(pj) from ClientePJ pj");
        this.total = (long)p.getSingleResult();
        
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public ClientePJBean(){
    }
    
    public ClientePJ getClientePJ(){
        return clientePJ;
    }
    
    public void setClientePJ(ClientePJ clientePJ){
        this.clientePJ = clientePJ;
    }
    
    public List<ClientePJ> getClientesPJ() {
        
            EntityManager em = JPAUtil.getEntityManager();
            Query p = em.createQuery("select pj from ClientePJ pj", ClientePJ.class);
            this.clientesPJ = p.getResultList();
            //em.close();
        
        
        return this.clientesPJ;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            
            ClientePJ cpj = new ClientePJ();
            
            if(clientePJ.getCodigo() != null){
            
            cpj = em.find(ClientePJ.class, clientePJ.getCodigo());
            
            }
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (cpj != null) {
                //Atualiza os dados da pessoa.
                clientePJ = em.merge(clientePJ);
            } else {
                //Salva os dados da pessoa.
                em.persist(clientePJ);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.clientePJ = new ClientePJ();
        return "clientePJ";
    }
    
    public String alterar(ClientePJ cpj) {
        this.clientePJ = cpj;
        return "clientesPJ";
    }
    
    public void excluir(ClientePJ cpj) {

        Long cod = cpj.getCodigo();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(cpj.getCodigo());
            em.getTransaction().begin();
            cpj = em.merge(cpj);
            em.remove(cpj);
            em.getTransaction().commit();
            em.close();
        }

        this.clientePJ = new ClientePJ();

    }
}
