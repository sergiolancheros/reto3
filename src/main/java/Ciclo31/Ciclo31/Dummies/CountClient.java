package Ciclo31.Ciclo31.Dummies;

import Ciclo31.Ciclo31.Model.Client;

public class CountClient {
    private Long total;
    private Client client;
    
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

   
 
}
