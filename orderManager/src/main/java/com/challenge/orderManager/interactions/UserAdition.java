package com.challenge.orderManager.interactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.orderManager.dtos.UserDTO;
import com.challenge.orderManager.entities.User;
import com.challenge.orderManager.repositories.UserRepository;

@Service
public class UserAdition {
	
	@Autowired
	private UserRepository repository;			

	public User save(UserDTO user) throws Exception {
		if (!isUserTypeValid(user)) {
			throw new Exception("Não foi possivel salvar o usuário pois o tipo dele é invalido");
		}		
		return repository.save(user.toEntity());
	}
	
	private boolean isUserTypeValid(UserDTO user) {
		if (UserType.ADMIN.name().equals(user.getType())) {
			return true;
		}else if (UserType.ATTENDANT_BOX.name().equals(user.getType())) {
			return true;
		}else if (UserType.COOK.name().equals(user.getType())) {
			return true;
		}else if (UserType.WAITER.name().equals(user.getType())) {
			return true;
		}else {
			return false;
		}
	}

}