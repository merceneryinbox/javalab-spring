package lab.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("apubar")
public class ApuBar implements Bar {

    @Override
	public Squishee sellSquishee(Person customer)  {
        if (customer.isBroke())
            throw new CustomerBrokenException();

        System.out.println("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}