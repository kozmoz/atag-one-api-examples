import java.io.IOException;
import java.util.Map;

import org.juurlink.atagone.AtagOneConnectorInterface;
import org.juurlink.atagone.AtagOneRemoteConnector;
import org.juurlink.atagone.domain.PortalCredentials;

/**
 * Example class how to use the ATAG One API library in Java, connect to remote thermostat via the ATAG ONE Portal and get diagnostics.
 */
@SuppressWarnings("Duplicates")
public class ReadAtagOneRemoteSimple {

	/**
	 * Main start method.
	 */
	public static void main(String[] args) throws IOException {

		// ATAG One Portal credentials.
		PortalCredentials portalCredentials = PortalCredentials.builder()
			.emailAddress("email@gmail.com")
			.password("p6ssw0rd")
			.build();

		// Create local or remote connector.
		AtagOneConnectorInterface atagOneConnector = new AtagOneRemoteConnector(portalCredentials);

		// First login.
		atagOneConnector.login();

		// Get diagnostics.
		final Map<String, Object> diagnostics = atagOneConnector.getDiagnostics();

		// Print results.
		for (Map.Entry<String, Object> entry : diagnostics.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
