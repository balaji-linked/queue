package my.sc.queue.server.admin;

public interface AdminServiceDAO {

	/**
	 * Saves the party in the table and returns it filled in with the id attribute.
	 * 
	 * @param party
	 * @return
	 */
	public Party saveParty(Party party);
	
	/**
	 * Deletes a party with the given id from the Party table.
	 * @param partyId
	 */
	public void deleteParty(Integer partyId);
	
	
	/**
	 * Saves a queue in the table and returns it filled in with the id attribute.
	 * @param queue
	 * @return
	 */
	public Queue saveQueue(Queue queue);
	
	/**
	 * Deletes a queue with the given id from the database.
	 * @param queueName
	 */
	public void deleteQueue(String queueName);
	
}
