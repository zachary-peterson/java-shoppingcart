package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.exceptions.ResourceNotFoundException;
import com.lambdaschool.shoppingcart.models.Role;
import com.lambdaschool.shoppingcart.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleSeviceImpl implements RoleService
{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll()
    {
        List<Role> roles = new ArrayList<>();
        roleRepository.findAll().iterator().forEachRemaining(roles::add);
        return roles;
    }

    @Override
    public Role findRoleById(long id)
    {
        return roleRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Role for ID " + id + " could not be found"));
    }

    @Transactional
    @Override
    public Role save(Role role)
    {
        Role newRole = new Role();
        newRole.setName(role.getName());
        newRole.setUsers(role.getUsers());
        return roleRepository.save(newRole);
    }

    @Override
    public Role findByName(String name)
    {
        Role newRole = roleRepository.findByNameIgnoreCase(name);
        if (newRole == null)
        {
            throw new EntityNotFoundException("Role with name " + name + " could not be found!");
        }else {
            return newRole;
        }
    }

    @Override
    public void deleteAll()
    {
        roleRepository.deleteAll();
    }

    @Override
    public Role update( long id, Role role)
    {
        Role newRole = findRoleById(id);
        if(role.getName() != null) {
            newRole.setName(role.getName());
        }
        if(role.getUsers().size() > 0) {
            throw new ResourceNotFoundException("Not found");
        }
        return roleRepository.save(newRole);
    }

}
