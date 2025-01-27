package com.example.ksb2_vaadin;

import com.example.ksb2_vaadin.manager.CarManager;
import com.example.ksb2_vaadin.model.Car;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route("car-adder")

public class CarAdderGui extends VerticalLayout {

    private final CarManager carManager;

       public CarAdderGui(CarManager carManager) {
        this.carManager = carManager;

        TextField mark = new TextField();
        mark.setLabel("Mark");
        TextField model = new TextField();
        model.setLabel("Model");
        Button button = new Button("Add car");


        button.addClickListener(e -> {
           Car car = new Car(mark.getValue(), model.getValue());
              carManager.addCar(car);
              carManager.getCarList().forEach(System.out::println);
        });


        add(mark, model, button);

    }
}
