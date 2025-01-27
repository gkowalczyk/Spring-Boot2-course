package com.example.ksb2_vaadin;

import com.example.ksb2_vaadin.manager.CarManager;
import com.example.ksb2_vaadin.model.Car;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("car-show")
public class CarShowGui extends VerticalLayout {
    private final CarManager carManager;


    public CarShowGui(CarManager carManager) {
        this.carManager = carManager;

       Grid grid = new Grid(Car.class);
       grid.setItems(carManager.getCarList());

       add(grid);

    }
}
