package com.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.db.entity.Division;

public class DivisionTest
{
	Division tmpDiv;

	@Before
	public void setUp()
	{
		tmpDiv = new Division("name", 0, 1);
	}


	@Test
	public void test_setId_getId()
	{
		tmpDiv.setId(10);
		assertEquals(10, tmpDiv.getId().intValue());
		tmpDiv.setId(8);
		assertEquals(8, tmpDiv.getId().intValue());
	}

	@Test
	public void test_setName_getName()
	{
		tmpDiv.setName("SomeName1");
		assertEquals("SomeName1", tmpDiv.getName());
		tmpDiv.setName("SomeName2");
		assertEquals("SomeName2", tmpDiv.getName());
	}

	@Test
	public void test_setHeadDivId_getHeadDivId()
	{
		tmpDiv.setHeadDivId(10);
		assertEquals(10, tmpDiv.getHeadDivId().intValue());
		tmpDiv.setHeadDivId(9);
		assertEquals(9, tmpDiv.getHeadDivId().intValue());
	}

	@Test
	public void test_setChiefId_getChiefId()
	{
		tmpDiv.setChiefId(10);
		assertEquals(10, tmpDiv.getChiefId().intValue());
		tmpDiv.setChiefId(9);
		assertEquals(9, tmpDiv.getChiefId().intValue());
	}

	@Test
	public void test_toString()
	{
		tmpDiv.setId(10);
		assertEquals("Division [id=10, name=name, headDivId=0, chiefId=1]", tmpDiv.toString());
		tmpDiv.setId(9);
		assertEquals("Division [id=9, name=name, headDivId=0, chiefId=1]", tmpDiv.toString());
	}
}
