package automacaogodare.apis.model.detalhadare;

import java.util.List;

public class DetalhaDareResponse {

	private List<Alternative> alternatives;
	private Integer countParticipants;
	private List<String> usersParticipants;
	private String inputEndAt;

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}

	public Integer getCountParticipants() {
		return countParticipants;
	}

	public void setCountParticipants(Integer countParticipants) {
		this.countParticipants = countParticipants;
	}

	public List<String> getUsersParticipants() {
		return usersParticipants;
	}

	public void setUsersParticipants(List<String> usersParticipants) {
		this.usersParticipants = usersParticipants;
	}

	public String getInputEndAt() {
		return inputEndAt;
	}

	public void setInputEndAt(String inputEndAt) {
		this.inputEndAt = inputEndAt;
	}

}
