package org.prflr.sdk.test;

import android.test.ApplicationTestCase;

import org.prflr.sdk.app.Application;

public abstract class PRFLRTestCase extends ApplicationTestCase<Application> {
	public PRFLRTestCase() {
		super(Application.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		createApplication();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public static <T> void assertArrayEquals(T[] actual, T... expected) {
		assertEquals(expected.length, actual.length);
		
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
}
