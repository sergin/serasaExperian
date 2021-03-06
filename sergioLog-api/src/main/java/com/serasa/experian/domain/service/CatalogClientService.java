package com.serasa.experian.domain.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serasa.experian.domain.exception.BusinessException;
import com.serasa.experian.domain.model.Client;
import com.serasa.experian.domain.repository.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalogClientService {

	private ClientRepository clientRepository;
	
	@Transactional
	public Client saveClient(Client client) {
		
		/*boolean emailAtUse = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExistente -> !clientExistente.equals(client));
		
		if(emailAtUse) {
			throw new BusinessException("Já existe um client cadastrado com esse email.");
		}*/
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void deleteClient(Long idClient) {
		clientRepository.deleteById(idClient);
	}
	
}
