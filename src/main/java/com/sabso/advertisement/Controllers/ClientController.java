package com.sabso.advertisement.Controllers;

import com.sabso.advertisement.Entities.Client;
import com.sabso.advertisement.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping("/")
    public List<Client> getClients() {
        return service.getClients();
    }

    @PostMapping("/")
    public void postClients(@RequestBody Client client) {
        service.save(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        return service.updateClient(newClient, id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id)
    {
        service.deleteById(id);
    }
}
