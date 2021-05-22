package com.cg.cars.repository;

import org.junit.runner.RunWith;
import com.cg.cars.entities.Address;
import com.cg.cars.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void testNewAdddress() throws Exception {
		Address address = getAddress();
		Address saveInDb = testEntityManager.persist(address);
		Address getFromInDb = addressRepository.findById(saveInDb.getAddressId()).get();
		assertThat(getFromInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAddressById() throws Exception {
		Address address = new Address();
		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);

		// Insert Data into in memory database
		Address saveInDb = testEntityManager.persist(address);
		// Get Data from DB
		Address getInDb = addressRepository.findById(address.getAddressId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}

	@Test
	public void testGetAllAddress() throws Exception {
		Address address1 = new Address();
		address1.setDoorNo(46L);
		address1.setStreet("Frazer Street");
		address1.setArea("Shivaji");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(560025L);

		Address address2 = new Address();
		address2.setDoorNo(48L);
		address2.setStreet("Colony");
		address2.setArea("Hebbal");
		address2.setCity("Bangalore");
		address2.setState("Karnataka");
		address2.setPincode(560054L);

		// Save into in memory database
		testEntityManager.persist(address1);
		testEntityManager.persist(address2);

		// Retrieve all tickets
		List<Address> adminList = (List<Address>) addressRepository.findAll();

		Assert.assertEquals(2, adminList.size());
	}

	@Test
	public void testDeleteAddressById() throws Exception {
		Address address1 = new Address();
		address1.setDoorNo(41L);
		address1.setStreet("Church Street");
		address1.setArea("MG");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(560074L);

		Address address2 = new Address();

		address2.setDoorNo(42L);
		address2.setStreet("Georgia");
		address2.setArea("MG");
		address2.setCity("Bangalore");
		address2.setState("Karnataka");
		address2.setPincode(560074L);

		Address address = testEntityManager.persist(address1);
		testEntityManager.persist(address2);

		testEntityManager.remove(address);

		List<Address> addresss = (List<Address>) addressRepository.findAll();
		Assert.assertEquals(addresss.size(), 1);

	}

	@Test
	public void testUpdateAddressById() {
		Address address2 = new Address();
		address2.setDoorNo(45L);
		address2.setStreet("Church Street");
		address2.setArea("MG");
		address2.setCity("Bangalore");
		address2.setState("Karnataka");
		address2.setPincode(560074L);

		Address saveInDb = testEntityManager.persist(address2);

		Address getFromDb = addressRepository.findById(address2.getAddressId()).get();

		assertThat(getFromDb).isEqualTo(saveInDb);

	}

	private Address getAddress() {
		Address address = new Address();

		address.setDoorNo(45L);
		address.setStreet("Church Street");
		address.setArea("MG");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(560074L);
		return address;

	}
}
