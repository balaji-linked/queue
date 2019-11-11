package my.sc.queue.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminServiceDAO adminServiceDAO;
	
	@Override
	public Queue createQueue(Queue queue) {
		//Validate the input before proceeding forward.
		return adminServiceDAO.saveQueue(queue);
	}

	@Override
	public void deleteQueue(String name) {
		//Validate the input before proceeding forward.
		adminServiceDAO.deleteQueue(name);
	}

	@Override
	public Party addParty(Party party) {
		//Validate the input before proceeding forward.
		return adminServiceDAO.saveParty(party);
	}

	@Override
	public void deleteParty(Integer partyId) {
		//Validate the input before proceeding forward.
		adminServiceDAO.deleteParty(partyId);
	}

	
	
}
