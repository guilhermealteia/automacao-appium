package automacaogodare.apis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import automacaogodare.MetodosGenericos;
import automacaogodare.apis.model.detalhadare.Alternative;
import automacaogodare.apis.model.detalhadare.DetalhaDareResponse;
import automacaogodare.apis.model.informacoestickets.InformacoesTicketsResponse;
import automacaogodare.apis.model.listadares.Doc;
import automacaogodare.apis.model.listadares.ListaDaresResponse;
import automacaogodare.apis.model.login.LoginResponse;
import automacaogodare.apis.service.DetalhaDareService;
import automacaogodare.apis.service.DiminuiTempoRecargaTicketsService;
import automacaogodare.apis.service.GravaApostaService;
import automacaogodare.apis.service.InformacoesTicketsService;
import automacaogodare.apis.service.ListaDaresService;
import automacaogodare.apis.service.LoginService;
import automacaogodare.apis.service.ResgataMoedasService;
import automacaogodare.apis.service.ResgataTicketsService;

public class ResgateDeMoedasEApostas extends MetodosGenericos {

	static final String ERROR_OUT_OF_GO_TICKETS = "Você não possui GO Tickets para participar deste dare!";

	public static void main(String[] args) {

		while (true) {
				executaGodare("alteia", "Einstein1812", true);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("guialves622", "Einstein1812", true);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("vitorialteia", "lmoi8041", true);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("matheusfelipe", "82783712", false);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("Mvalneiros", "37140259", true);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("fejunior", "godare3194", true);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("matheusfusco", "GoDare123", true);
				waitTime(10000 + ramdomTime(10000));
				executaGodare("topos", "Matheustroxa", false);
				waitTime(300000 + ramdomTime(10000));
		}
	}

	public static void executaGodare(String user, String password, boolean apostasAutomaticas) {
		try {
			println("Iniciando execução para: " + user);
			LoginResponse loginResponse = LoginService.execute(user, password);

			String token = loginResponse.getToken();

			ResgataMoedasService.execute(token);
			DiminuiTempoRecargaTicketsService.execute(token);
			if (loginResponse.getUser().getCountTickets() == 0)
				ResgataTicketsService.execute(token);

			if (apostasAutomaticas) {
				ListaDaresResponse listaDaresResponse = ListaDaresService.execute(token);

				for (Doc d : listaDaresResponse.getDocs()) {
					String dareId = d.get_id();
					DetalhaDareResponse detalhaDareResponse = DetalhaDareService.execute(token, d.get_id());
					Alternative maisVotada = new Alternative();
					maisVotada.setCountParticipants(0);

					if (loginResponse.getUser().getCountTickets() > 0 && detalhaDareResponse.getCountParticipants() > 40
							&& apostaLiberada(detalhaDareResponse.getInputEndAt())) {
						for (Alternative a : detalhaDareResponse.getAlternatives()) {
							if (a.getCountParticipants() > maisVotada.getCountParticipants()) {
								maisVotada = a;
							}
						}
						// println(d.getTitle() + " : " + dareId);
						// println("Total de Participantes" +
						// detalhaDareResponse.getCountParticipants());
						// println("Alternativa escolhida: " + maisVotada.getBody());
						// println("Quantidade de votos na mais votada: " +
						// maisVotada.getCountParticipants());

						GravaApostaService.execute(token, dareId,
								maisVotada.get_id());

						loginResponse.getUser().setCountTickets(loginResponse.getUser().getCountTickets() - 1);

						if (loginResponse.getUser().getCountTickets() == 0) {
							DiminuiTempoRecargaTicketsService.execute(token);
							ResgataTicketsService.execute(token);
							InformacoesTicketsResponse informacoesTicketsResponse = InformacoesTicketsService
									.execute(token);
							loginResponse.getUser().setCountTickets(informacoesTicketsResponse.getCountTickets());
							System.out.println(
									"Tickets acabados durante aposta.\nResgate realizado.\nQuantidade de moedas: "
											+ loginResponse.getUser().getCountTickets());
						}
					}

				}
			}
			System.gc();
			println("Finalizando execução para: " + user + "\n\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean apostaLiberada(String inputEndAt) {
		LocalDate dataFinalAposta = LocalDate.parse(inputEndAt,
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
		if (LocalDate.now().plusDays(2).isEqual(dataFinalAposta)
				|| LocalDate.now().plusDays(2).isAfter(dataFinalAposta)) {
			System.out.println("Aposta realizada. Data final da aposta:  " + inputEndAt);
			return true;
		} else {
			return false;
		}
	}
}