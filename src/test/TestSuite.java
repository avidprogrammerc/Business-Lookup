package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.data_structures.LinkedListTest;
import test.model.BusinessTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	LinkedListTest.class, 
	BusinessTest.class })
public class TestSuite {
}
