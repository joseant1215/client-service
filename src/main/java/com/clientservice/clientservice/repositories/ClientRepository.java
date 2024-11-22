/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.clientservice.clientservice.repositories;

import com.clientservice.clientservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Intel
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUniquecode(String uniquecode);
}