package service;

public interface ContactService {
	// 여기에서는 DB친화적인 이름 안 줘도 됨. 사용자 친화적인 이름을 주면 된다.
	// 인터페이스에는 이런 메소드가 있어하고 적는 거
	public void addContact();
	public void removeContact();
	public void modifyContact();
	public void findContactsByName();
	public void findAllContacts();
}
