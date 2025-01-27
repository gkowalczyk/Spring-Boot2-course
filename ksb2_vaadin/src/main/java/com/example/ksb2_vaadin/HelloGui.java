package com.example.ksb2_vaadin;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
public class HelloGui extends VerticalLayout {

    public HelloGui() {
        TextField textField = new TextField();
        textField.setLabel("Your name:");

        Button button = new Button("Say hello",
                new Icon(VaadinIcon.HANDSHAKE));
                    button.setIconAfterText(true);


        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("150px");

        button.addClickListener(e -> {
                    dialog.add(new Text("Hello, " + textField.getValue()));
                    dialog.open();

                });
        add(textField);
        add(button);
    }
}
