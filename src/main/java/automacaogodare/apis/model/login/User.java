package automacaogodare.apis.model.login;

public class User {

	private String _id;
	private Integer countTickets;

	public Integer getCountTickets() {
		return countTickets;
	}

	public void setCountTickets(Integer countTickets) {
		this.countTickets = countTickets;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
