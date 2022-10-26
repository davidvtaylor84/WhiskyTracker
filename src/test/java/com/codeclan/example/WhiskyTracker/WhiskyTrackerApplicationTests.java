package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetWhiskyByYear(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByYear(1995);
		assertEquals("The Macallan Anniversary Malt", foundWhiskies.get(0).getName());
	}

	@Test
	public void canGetDistilleryByRegion(){
		List<Distillery> foundDistilleries = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals(9, foundDistilleries.size());
	}

	@Test
	public void canGetWhiskyByAgeAndDistilleryName(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByAgeAndDistilleryName(12, "Old Pulteney");
		assertEquals(4, foundWhiskies.size());
	}

	@Test
	public void canGetWhiskyByDistilleryRegion(){
		List<Whisky> foundWhiskies = whiskyRepository.findWhiskyByDistilleryRegion("Highland");
		assertEquals(7, foundWhiskies.size());
	}

	@Test
	public void canGetDistilleryByWhiskyAge(){
		List<Distillery> foundDistillery = distilleryRepository.findDistilleryByWhiskiesAge(12);
		assertEquals(12, foundDistillery.size());
	}
}
