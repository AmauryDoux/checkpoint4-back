package com.sabso.advertisement.Services;

import com.sabso.advertisement.Repositories.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {
    @Autowired
    ScreenRepository repository;
}
