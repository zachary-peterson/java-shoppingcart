package com.lambdaschool.shoppingcart.repositories;

import com.lambdaschool.shoppingcart.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleServices extends CrudRepository<Role, Long>
{

}
