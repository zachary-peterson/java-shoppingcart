package com.lambdaschool.shoppingcart.repositories;

import com.lambdaschool.shoppingcart.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long>
{
    @Override
    Optional<Role> findById(Long aLong);

    Role findByNameIgnoreCase(String name);
}
