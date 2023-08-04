package pupdesk.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import pupdesk.services.exceptions.ServiceException;

public class TestDeleteUser {
	@Test
	public void TestDeleteUserPass() {
		UserService user = new UserService();
		String delete = "bhirahatees.periyasamy@fssa.freshworks.com";
		try {
			assertTrue(user.deleteUserService(delete));
		} catch (ServiceException e) {
			System.out.println("Failed to Delete");
		}
	}

	@Test
	public void TestDeleteUserFail() {
		UserService user = new UserService();
		String delete = "bhirahatees@fsa.freshworks.com";
		try {
			assertFalse(user.deleteUserService(delete));
		} catch (ServiceException e) {
			System.out.println("Failed to Delete");
		}
	}
}
