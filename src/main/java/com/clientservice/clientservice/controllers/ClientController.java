/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientservice.clientservice.controllers;

import com.clientservice.clientservice.models.Client;
import com.clientservice.clientservice.services.ClientService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Intel
 */

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        System.out.println("Clientes recuperados: " + clients);
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{uniquecode}")
    public ResponseEntity<Client> getClient(@PathVariable String uniquecode) {

        System.out.println("Recibiendo código único: " + uniquecode);

        // Llamada al servicio
        Optional<Client> client = clientService.getClientByCode(uniquecode);

        // Verifica si se encontró el cliente
        if (client.isPresent()) {
            System.out.println("Cliente encontrado: " + client.get());
            return ResponseEntity.ok(client.get()); // Retorna el cliente encontrado
        } else {
            System.out.println("Cliente no encontrado");
            return ResponseEntity.notFound().build(); // Retorna 404 si no se encuentra el cliente
        }
    }
}
