package lab.mvc;

import lab.mvc.form.bean.CountryFormBean;
import lab.mvc.form.bean.UserFormBean;
import lab.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import static lombok.AccessLevel.PRIVATE;

@Log4j2
@Controller
@FieldDefaults(level = PRIVATE)
@RequestMapping("/addCountry.form")
@AllArgsConstructor
public class CountryFormController {

    private static final String ADD_USER_FORM_VIEW = "addCountryForm";
    private static final String USER_LIST_VIEW = "countryListView";

    CountryService countryService;

    @ModelAttribute("countryFormBean")
    public CountryFormBean getCountryFormBean() {
        return new CountryFormBean();
    }


}
