package com.flightBooking;

import com.flightBooking.Decorator.RoomDecorator;
import com.flightBooking.Decorator.StudentDecorator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import platform.decorator.DecoratorManager;
import platform.defined.account.helper.RoleHelper;
import platform.helper.HelperManager;

@SpringBootApplication
@ComponentScan(basePackages = {"controller", "platform.webservice.map", "platform.webservice.controller.base","ci","./src/main/java/com/flightBooking/","platform.defined.account.controller"})

public class FlightBookingSystemApplication {

    public static void main(String[] args) {
        Registry.register();


        HelperManager.getInstance().register(RoleHelper.getInstance());
        DecoratorManager.getInstance().register("student",new StudentDecorator());
        DecoratorManager.getInstance().register("room",new RoomDecorator());
        SpringApplication.run(FlightBookingSystemApplication.class, args);


    }

}
