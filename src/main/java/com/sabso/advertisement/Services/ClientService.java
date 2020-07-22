package com.sabso.advertisement.Services;

import com.sabso.advertisement.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;
}
