package za.ac.nwu.acsys.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchAccountTypeFlowImplTest {

    private FetchAccountTypeFlowImpl classToTest;

    // Use @Ignore above a test to skip the test


    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountTypeFlowImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

    @Test
    public void methodToTest() {
        assertTrue(classToTest.methodToTest());
    }
}