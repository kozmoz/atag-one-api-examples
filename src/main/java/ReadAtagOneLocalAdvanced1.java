import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

import org.juurlink.atagone.AtagOneConnectorInterface;
import org.juurlink.atagone.AtagOneLocalConnector;
import org.juurlink.atagone.domain.AtagOneInfo;
import org.juurlink.atagone.exceptions.AccessDeniedException;
import org.juurlink.atagone.exceptions.NotAuthorizedException;

/**
 * Example class how to use the ATAG One API library in Java and connect to thermostat on the local network.
 * <p/>
 * Automatic discovery of the thermostat is skipped, the address and device id have to be known in advanced.
 */
@SuppressWarnings("Duplicates")
public class ReadAtagOneLocalAdvanced1 {

	/**
	 * Main start method.
	 */
	public static void main(String[] args) throws IOException {

		// To connect to configured thermostat, supply the IP address and device id of the ATAG One thermostat..
		AtagOneInfo atagOneInfo = AtagOneInfo.builder()
			.deviceAddress(InetAddress.getByName("10.0.100.50"))
			.deviceId("6808-1401-3109_15-30-001-123")
			.build();

		// Create local connector.
		AtagOneConnectorInterface atagOneConnector = new AtagOneLocalConnector(atagOneInfo);

		try {
			// Login to get authorization.
			// Login can be skipped if access from this device is already authorized.
			atagOneConnector.login();

			// Get diagnostics.
			final Map<String, Object> diagnostics = atagOneConnector.getDiagnostics();

			// Print results.
			for (Map.Entry<String, Object> entry : diagnostics.entrySet()) {
				System.out.println(entry.getKey() + " = " + entry.getValue());
			}

		} catch (NotAuthorizedException e) {
			// User has not yet authorized this device.
			System.out.println("Error getting diagnostics: " + e);
		} catch (AccessDeniedException e) {
			// User has denied access from this device.
			System.out.println("Error getting diagnostics: " + e);
		} catch (IOException e) {
			// An general network error occurred.
			System.out.println("Error getting diagnostics: " + e);
		}
	}
}