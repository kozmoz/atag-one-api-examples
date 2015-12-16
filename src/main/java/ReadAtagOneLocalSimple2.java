import java.io.IOException;
import java.math.BigDecimal;

import org.juurlink.atagone.AtagOneConnectorInterface;
import org.juurlink.atagone.AtagOneLocalConnector;

/**
 * Example class how to use the ATAG One API library in Java, connect to thermostat on the local network and get diagnostics.
 */
@SuppressWarnings("Duplicates")
public class ReadAtagOneLocalSimple2 {

	/**
	 * Main start method.
	 */
	public static void main(String[] args) throws IOException {

		// Create local connector.
		AtagOneConnectorInterface atagOneConnector = new AtagOneLocalConnector();

		// First login, this will start the discovery of the thermostat.
		atagOneConnector.login();

		// Set target temperature.
		final BigDecimal roomTemperature = atagOneConnector.setTemperature(new BigDecimal("17"));

		// Print result.
		System.out.println("roomTemperature = " + roomTemperature);
	}
}
