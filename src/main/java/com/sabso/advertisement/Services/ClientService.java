package com.sabso.advertisement.Services;

import com.sabso.advertisement.Entities.Advert;
import com.sabso.advertisement.Entities.Client;
import com.sabso.advertisement.Repositories.AdvertRepository;
import com.sabso.advertisement.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    public List<Client> getClients(){
        return repository.findAll();
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client updateClient(Client newclient, Long id) {
        return repository.findById(id)
                .map(client -> {
                    client.setName(newclient.getName());
                    client.setAddress(newclient.getAddress());
                    return repository.save(client);
                })
                .orElseGet(() -> {
                    newclient.setId(id);
                    return repository.save(newclient);
                });
    }

    public void deleteById(Long id) {
        Optional<Client> addToDelete = repository.findById(id);
        if (addToDelete.get().getId() != null){
            repository.deleteById(id);
        }
    }
}
