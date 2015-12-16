import java.io.IOException;

import org.juurlink.atagone.AtagOneConnectorInterface;
import org.juurlink.atagone.AtagOneLocalConnector;
import org.juurlink.atagone.domain.AtagOneInfo;
import org.juurlink.atagone.exceptions.AccessDeniedException;
import org.juurlink.atagone.exceptions.NotAuthorizedException;

/**
 * Example class how to use the ATAG One API library in Java and connect to thermostat on the local network.
 * <p/>
 * We only use the automatic discovery of the thermostat to get the IP address and device id.
 */
@SuppressWarnings("Duplicates")
public class ReadAtagOneLocalAdvanced2 {

	/**
	 * Main start method.
	 */
	public static void main(String[] args) throws IOException {

		// Create local connector.
		AtagOneConnectorInterface atagOneConnector = new AtagOneLocalConnector();

		try {
			// Login to get authorization.
			// Login can be skipped if access from this device is already authorized.
			atagOneConnector.login();

			final AtagOneInfo selectedDevice = ((AtagOneLocalConnector) atagOneConnector).getSelectedDevice();
			if (selectedDevice != null) {
				// Found it.
				System.out.println("Found thermostat with address and device id: " + selectedDevice);
			} else {
				// Not found.
				System.out.println("No thermostat found in local network.");
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
