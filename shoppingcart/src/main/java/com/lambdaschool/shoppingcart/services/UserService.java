package com.lambdaschool.shoppingcart.services;

import com.lambdaschool.shoppingcart.models.User;

import java.util.List;

/**
 * The Service that works with User Model.
 */
public interface UserService
{
    /**
     * Returns a list of all the Users
     *
     * @return List of Users. If no users, empty list.
     */
    List<User> findAll();

    /**
     * Returns the user with the given primary key.
     *
     * @param id The primary key (long) of the user you seek.
     * @return The given User or throws an exception if not found.
     */
    User findUserById(long id);

    User findByUsername(String name);

    /**
     * Deletes the user record from the database based off of the provided primary key
     *
     * @param id id The primary key (long) of the user you seek.
     */
    void delete(long id);

    /**
     * Given a complete user object, saves that user object in the database.
     * If a primary key is provided, the record is completely replaced
     * If no primary key is provided, one is automatically generated and the record is added to the database.
     *
     * @param user the user object to be saved
     * @return the saved user object including any automatically generated fields
     */
    User save(User user);
}
