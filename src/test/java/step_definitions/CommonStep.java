package step_definitions;

import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DBUtils;

import java.sql.SQLException;

public class CommonStep {

	private static final Logger LOGGER = LogManager.getLogger(CommonStep.class);

	@Given("the user has authority to access database")
	public void theUserHasAuthorityToAccessDatabase() {
		try {
			DBUtils.getConnection();
			LOGGER.info("the user has authority to access database");
		}
		catch (SQLException e) {
			LOGGER.error("The user can not access to database!");
		}
	}

}
