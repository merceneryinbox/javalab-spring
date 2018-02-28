package lab.mvc;

import lab.model.User;
import lab.model.simple.SimpleUser;
import lab.mvc.form.bean.UserFormBean;
import lab.service.UserService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;

@Log4j2
@Controller
@FieldDefaults(level = PRIVATE)
@RequestMapping("/addUser.form")
@AllArgsConstructor
public class UserFormController {

    private static final String ADD_USER_FORM_VIEW = "addUserForm";
    private static final String USER_LIST_VIEW = "userListView";

    UserService userService;

    @ModelAttribute("userFormBean")
    public UserFormBean getUserFormBean() {
        return new UserFormBean();
    }

    @GetMapping
    public String get() {
        return ADD_USER_FORM_VIEW;
    }

    @PostMapping
    public ModelAndView processSubmit(@Valid UserFormBean userFormBean, Errors errors) {

        if (errors.hasErrors()) {
            log.info("AddUserForm validation failed!");
            return new ModelAndView(ADD_USER_FORM_VIEW);
        } else {
            User user = SimpleUser.builder()
                    .firstName(userFormBean.getFirstName())
                    .lastName(userFormBean.getLastName())
                    .build();

            log.info("Adding new {}", user);

            userService.saveUser(user);

            return new ModelAndView(
                    USER_LIST_VIEW,
                    "userList",
                    userService.loadAllUsers());
        }
    }
}