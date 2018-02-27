package lab.model.simple;

import lab.model.Bar;
import lab.model.CustomerBrokenException;
import lab.model.Person;
import lab.model.Squishee;
import org.springframework.stereotype.Service;

@Service
public class ApuBar implements Bar {

    @Override
	public Squishee sellSquishee(Person customer)  {
        if (customer.isBroke())
            throw new CustomerBrokenException();

        System.out.println("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}