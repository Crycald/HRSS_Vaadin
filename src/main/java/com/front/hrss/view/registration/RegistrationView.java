package com.front.hrss.view.registration;

import com.front.hrss.dto.RecruiterHolder;
import com.front.hrss.service.RecruiterService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.*;

@Route("register")
public class RegistrationView extends Div {
    private Icon logoIcon;
    private TextField loginField;
    private PasswordField pwdField;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField phoneNumberField;
    private TextField emailField;
    private Button createAccButton;
    private VerticalLayout registerForm;
    private RecruiterService service;
    private RecruiterHolder holder = new RecruiterHolder();

    @Autowired
    public RegistrationView(RecruiterService service) {
        this.service = service;
        init();
    }

    private void init() {
        setRegisterForm();
    }

    private void setRegisterForm() {
        setLogoIconForm();
        setFormForRegistration();
        setFormForCreateButton();

        this.registerForm = new VerticalLayout();
        registerForm.add(logoIcon, loginField, pwdField, firstNameField,
                lastNameField, phoneNumberField, emailField, createAccButton);
        registerForm.setAlignItems(Alignment.CENTER);

        add(registerForm);
    }

    private void setLogoIconForm() {
        this.logoIcon = new Icon(VaadinIcon.USERS);
        logoIcon.setSize("200");
    }

    private void setFormForRegistration() {
        this.loginField = new TextField();
        loginField.setPlaceholder("Login");

        this.pwdField = new PasswordField();
        pwdField.setPlaceholder("Password");

        this.firstNameField = new TextField();
        firstNameField.setPlaceholder("First name");

        this.lastNameField = new TextField();
        lastNameField.setPlaceholder("Last name");

        this.phoneNumberField = new TextField();
        phoneNumberField.setPlaceholder("Phone number");

        this.emailField = new TextField();
        emailField.setPlaceholder("E-mail");
    }

    private void setFormForCreateButton() {
        this.createAccButton = new Button(new Icon(VaadinIcon.USER_CHECK));
        createAccButton.setText("Register");
        createAccButton.addClickListener(this::setEventForCreateButton);
    }

    private void setEventForCreateButton(ClickEvent<Button> event) {
        holder.setLogin(loginField.getValue());
        holder.setPassword(pwdField.getValue());
        holder.setFirstName(firstNameField.getValue());
        holder.setLastName(lastNameField.getValue());
        holder.setPhoneNumber(Long.valueOf(phoneNumberField.getValue()));
        holder.setEmail(emailField.getValue());
        service.create(holder);

        clearTextFields();
    }

    private void clearTextFields() {
        loginField.clear();
        pwdField.clear();
        firstNameField.clear();
        lastNameField.clear();
        phoneNumberField.clear();
        emailField.clear();
    }
}
