package br.edu.ibmec.cloud.ecommerce.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import br.edu.ibmec.cloud.ecommerce.entity.Order;

@Repository
public interface OrderRepository extends CosmosRepository<Order, String> {
    
}
