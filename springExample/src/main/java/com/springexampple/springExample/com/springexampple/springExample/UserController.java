package com.springexampple.springExample.com.springexampple.springExample;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@ApiModel("UserDetails Controller Class")
@RestController
public class UserController {
	
	@Autowired
	private UserRepoDao userRepoDao;
	
	@GetMapping("/users")
	public List<UserDetails> getAllUsers() {
		return userRepoDao.findAll();
	}
	
	
	@GetMapping("/users/{id}")
	public EntityModel<UserDetails> getUser(@PathVariable String id) {
		Optional<UserDetails> us= userRepoDao.findById(Integer.parseInt(id));
		if(!us.isPresent()) {
			throw new UserDataNotPresentException("User not Present");
		}
		Link link = linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users");

		EntityModel<UserDetails> result = new EntityModel(us, link);
		return result;
	}
	
	@PostMapping("/users")
	public EntityModel<UserDetails> getUser(@Valid @RequestBody UserDetails user) {
		URI location  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getuId()).toUri();
		userRepoDao.save(user);
		Link link = linkTo(methodOn(this.getClass()).getAllUsers()).withRel("all-users");
		
		EntityModel<UserDetails> result = new EntityModel(user, link);
		return result;
	}
	
	@DeleteMapping("/users/{id}")
	public void getUser(@PathVariable Integer id) {
		Optional<UserDetails> us= userRepoDao.findById(id);
		if(!us.isPresent()) {
			throw new UserDataNotPresentException("User not Present");
		}
		userRepoDao.deleteById(id);;
	}
}
