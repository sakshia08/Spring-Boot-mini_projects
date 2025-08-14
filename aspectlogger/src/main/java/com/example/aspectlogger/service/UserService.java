package com.example.aspectlogger.service;

import com.example.aspectlogger.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    // fake in-memory store
    private final Map<Integer, User> store = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    public User findById(Integer id) {
        User u = store.get(id);
        if (u == null) {
            throw new NoSuchElementException("User not found: " + id);
        }
        return u;
    }

    public User create(User u) {
        store.put(u.getId(), u);
        return u;
    }

    public User update(Integer id, User u) {
        if (!store.containsKey(id)) {
            throw new NoSuchElementException("Cannot update, user not found: " + id);
        }
        store.put(id, u);
        return u;
    }

    public void delete(Integer id) {
        if (store.remove(id) == null) {
            throw new NoSuchElementException("Cannot delete, user not found: " + id);
        }
    }
}
