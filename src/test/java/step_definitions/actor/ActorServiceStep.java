package step_definitions.actor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import service.ActorService;

import java.util.List;

public class ActorServiceStep {

	private static final Logger LOGGER = LogManager.getLogger(ActorService.class);

	private List<Actor> actorList;

	@When("the user sends request to database for actor list")
	public void theUserSendsRequestToDatabaseForActorList() {
		actorList = ActorService.getListOfAllActors();
		LOGGER.info("the user sends request to database for actor list");
	}

	@Then("the user should see the list of all actors")
	public void theUserShouldSeeTheListOfAllActors() {
		Assertions.assertThat(actorList).isNotNull().isNotEmpty();
		LOGGER.debug("the user sees the list of all actors");
	}

	@When("the user sends request to database to get information of {string}")
	public void theUserSendsRequestToDatabaseToGetInformationOf(String actorId) {

	}

	@Then("the user should see the correct actor")
	public void theUserShouldSeeTheCorrectActor() {
	}
}
