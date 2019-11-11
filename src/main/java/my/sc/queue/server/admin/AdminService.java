package my.sc.queue.server.admin;

public interface AdminService {

	Queue createQueue(Queue queue);
	
	void deleteQueue(String name);
	
	Party addParty(Party party);
	
	void deleteParty(Integer partyId);
	
}
