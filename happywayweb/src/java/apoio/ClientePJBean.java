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
public class ClientePJBean implements Serializable {
    
    private ClientePJ clientePJ = new ClientePJ();
    private List<ClientePJ> clientesPJ = new ArrayList<>();
    
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
            Query p = em.createQuery("select cpj from ClientePJ pj");
            this.clientesPJ = p.getResultList();
            //em.close();
        
        
        return this.clientesPJ;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            ClientePJ cpj = em.find(ClientePJ.class, clientePJ.getCNPJ());
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

        String cod = cpj.getCNPJ();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(cpj.getCNPJ());
            em.getTransaction().begin();
            cpj = em.merge(cpj);
            em.remove(cpj);
            em.getTransaction().commit();
            em.close();
        }

        this.clientePJ = new ClientePJ();

    }
}
