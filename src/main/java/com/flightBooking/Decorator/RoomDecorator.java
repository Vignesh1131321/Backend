package com.flightBooking.Decorator;

import com.flightBooking.helper.RoomHelper;
import com.flightBooking.resource.Room;
import platform.decorator.BaseDecorator;
import platform.resource.BaseResource;
import platform.util.ApplicationException;
import platform.util.ExceptionSeverity;
import platform.webservice.ServletContext;

import java.util.Objects;

public class RoomDecorator extends BaseDecorator {
    public RoomDecorator(){
        super(new Room());
    }

    @Override
    public void preAddDecorator (ServletContext stx, BaseResource _resource) throws ApplicationException {
        Room Room = (Room) _resource;
        BaseResource[] Rooms = RoomHelper.getInstance().getAll();
        for (BaseResource baseRes : Rooms) {
            Room stu = (Room) baseRes;
            if (Objects.equals(Room.getRoomnumber(), stu.getRoomnumber())) {
                throw new ApplicationException(ExceptionSeverity.ERROR, "Room number already present");
            }
        }
    }
}