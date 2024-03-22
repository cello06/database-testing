package step_definitions.actor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Actor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import service.ActorService;

import java.util.List;

public class ActorServiceStep {

	private static final Logger LOGGER = LogManager.getLogger(ActorService.class);

	private List<Actor> actorList;

	private Actor actor;

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
		actor = ActorService.getAnActor(actorId);
		LOGGER.info("the user sends request to database to get information of an actor");
	}


	@Then("the user should see the correct actor with {string},{string} and {string}")
	public void theUserShouldSeeTheCorrectActorWithAnd(String firstName, String lastName, String lastUpdate) {
		Assertions.assertThat(actor).as("The user can not be taken from Database").isNotNull();

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(actor.getFirstName()).as("Fist name is not matching!").isEqualTo(firstName);
		softAssertions.assertThat(actor.getLastName()).as("Last name is not matching!").isEqualTo(lastName);
		softAssertions.assertThat(actor.getLastUpdate().toString()).as("Last update is not matching!").isEqualTo(lastUpdate);

		softAssertions.assertAll();
		LOGGER.debug("the user sees the correct actor with id -> " + actor.getActorId());
	}
}
