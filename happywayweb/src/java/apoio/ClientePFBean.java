/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.ClientePF;

/**
 *
 * @author Lucas de Andrade
 */

@ManagedBean
@SessionScoped
public class ClientePFBean {
    
    private ClientePF clientePF = new ClientePF();
    private List<ClientePF> clientesPF = new ArrayList<>();
    
    public ClientePFBean(){
        clientePF.setCodigo(null);
    }
    
    public ClientePF getClientePF(){
        return clientePF;
    }
    
    public void setClientePF(ClientePF clientePF){
        this.clientePF = clientePF;
    }
    
    public List<ClientePF> getClientesPF() {
        
            EntityManager em = JPAUtil.getEntityManager();
            Query q = em.createQuery("select c from ClientePF c", ClientePF.class);
            this.clientesPF = q.getResultList();
            em.close();
        
        
        return clientesPF;
    }
    
    public String salva() {

        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            em.getTransaction().begin();
            ClientePF cpf = em.find(ClientePF.class, clientePF.getCodigo());
            // Verifica se a pessoa ainda não está salva no banco de dados.
            if (cpf != null) {
                //Atualiza os dados da pessoa.
                clientePF = em.merge(clientePF);
            } else {
                //Salva os dados da pessoa.
                em.persist(clientePF);
            }
            // Finaliza a transação.
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        this.clientePF = new ClientePF();
        return "clientes";
    }
    
    public String alterar(ClientePF cpf) {
        this.clientePF = cpf;
        return "clientes";
    }
    
    public void excluir(ClientePF cpf) {

        Long cod = cpf.getCodigo();
        
        if (cod != null) {
            EntityManager em = JPAUtil.getEntityManager();

            System.out.println(cpf.getCodigo());
            em.getTransaction().begin();
            cpf = em.merge(cpf);
            em.remove(cpf);
            em.getTransaction().commit();
            em.close();
        }

        this.clientePF = new ClientePF();

    }
}
