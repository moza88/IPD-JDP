package edu.depaul.ipd.jdp.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAAccountManager implements IAccountManager{
    

    @Override
    public Account findAccount(int acctNbr) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accountPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Account a = entityManager.find(Account.class, acctNbr);

        entityManager.close();
        return a;
    }

    @Override
    public List<Account> getAllAccounts() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accountPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        List<Account> retval = entityManager.createNamedQuery("Account.findAll").getResultList();
        
        entityManager.close();
        return retval;
    }
    
    public void saveAccount(Account account) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("accountPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(account);
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }
    
}
