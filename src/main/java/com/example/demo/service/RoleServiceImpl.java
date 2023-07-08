//package com.example.demo.service;
//
//import com.example.demo.model.Role;
//import com.example.demo.model.User;
//import com.example.demo.repositories.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//@Service
//public class RoleServiceImpl implements RoleService{
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    public boolean addRole(Role role) {
//        roleRepository.add(role);
//        return true;
//
//    }
//
//    public Optional<Role> findByNameRole(String name) { return roleRepository.findByName(name); }
//
//    public List<Role> listRoles() { return roleRepository.findAll(); }
//
//    public Role findByIdRole(int id) {
//        Optional<Role> role = roleRepository.findById(id);
//        return role.orElse(null);
//    }
//
//    }
