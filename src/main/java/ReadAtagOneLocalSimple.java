import java.io.IOException;
import java.util.Map;

import org.juurlink.atagone.AtagOneConnectorInterface;
import org.juurlink.atagone.AtagOneLocalConnector;

/**
 * Example class how to use the ATAG One API library in Java, connect to thermostat on the local network and get diagnostics.
 */
@SuppressWarnings("Duplicates")
public class ReadAtagOneLocalSimple {

	/**
	 * Main start method.
	 */
	public static void main(String[] args) throws IOException {

		// Create local connector.
		AtagOneConnectorInterface atagOneConnector = new AtagOneLocalConnector();

		// First login, this will start the discovery of the thermostat.
		atagOneConnector.login();

		// Get diagnostics.
		final Map<String, Object> diagnostics = atagOneConnector.getDiagnostics();

		// Print result.
		for (Map.Entry<String, Object> entry : diagnostics.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
