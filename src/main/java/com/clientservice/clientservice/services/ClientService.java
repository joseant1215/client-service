/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientservice.clientservice.services;

import com.clientservice.clientservice.models.Client;
import com.clientservice.clientservice.repositories.ClientRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Intel
 */

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> getClientByCode(String uniquecode) {
        System.out.println("Buscando cliente con código único en el servicio: " + uniquecode);

        // Llamar al repositorio para buscar por uniquecode
        Optional<Client> client = clientRepository.findByUniquecode(uniquecode);

        if (client.isPresent()) {
            System.out.println("Cliente encontrado en el servicio: " + client.get());
        } else {
            System.out.println("Cliente no encontrado en el servicio");
        }

        return client;
    }
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}