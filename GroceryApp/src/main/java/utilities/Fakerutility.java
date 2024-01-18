package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.Internet;

public class Fakerutility {

	public String getFakeFirstName() {

		Faker faker = new Faker();

		Address address =faker.address();

		String text=address.firstName();

		return text;

	}

	

	public String getFakeLastName() {

		Faker faker = new Faker();

		Address address =faker.address();

		String text=address.lastName();

		return text;

	}

	

	public String getFakeCityName() {

		Faker faker = new Faker();

		Address address =faker.address();

		String text=address.cityName();

		return text;

	}

	

	

	public String getFakeEmailAddress() {

		Faker faker = new Faker();

		Internet internet= faker.internet();

		String text=internet.emailAddress();

		return text;

	}


}
