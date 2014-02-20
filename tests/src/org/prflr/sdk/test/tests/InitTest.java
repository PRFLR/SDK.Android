package org.prflr.sdk.test.tests;

import org.prflr.sdk.PRFLR;

public class InitTest extends TestCase {
	public void testInit() {
		assertSqlEquals(true, PRFLR.init());
	}
}
