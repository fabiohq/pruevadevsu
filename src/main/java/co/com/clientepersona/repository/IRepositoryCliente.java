package co.com.clientepersona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.clientepersona.entity.EntityCliente;

@Repository
public interface IRepositoryCliente extends JpaRepository<EntityCliente, Long>{

}
