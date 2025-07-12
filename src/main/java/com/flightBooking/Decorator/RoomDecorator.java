package com.flightBooking.Decorator;

import com.flightBooking.helper.RoomHelper;
import com.flightBooking.helper.StudentHelper;
import com.flightBooking.resource.Room;
import com.flightBooking.resource.Student;
import platform.db.Expression;
import platform.db.REL_OP;
import platform.decorator.BaseDecorator;
import platform.resource.BaseResource;
import platform.util.ApplicationException;
import platform.util.ExceptionSeverity;
import platform.util.Util;
import platform.webservice.BaseService;
import platform.webservice.ServletContext;

import java.util.Map;
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

    @Override
    public BaseResource[] getQuery(ServletContext ctx, String queryId, Map<String, Object> map, BaseService service) throws ApplicationException{
        if ("GET_ROOM_BY_ID".equalsIgnoreCase(queryId)){
            /*System.out.println(map);*/
            String id = (String) map.get(Room.FIELD_ID);
            if (Util.isEmpty(id)){

                System.out.println(id);
                throw new ApplicationException(ExceptionSeverity.ERROR, "ID not found!");
            }
            Expression e = new Expression(Room.FIELD_ID, REL_OP.EQ, id);
            return RoomHelper.getInstance().getByExpression(e);
        }
        else if("GET_ROOM_BY_ROOM_NUMBER".equalsIgnoreCase(queryId)){
            String room_number = (String) map.get(Room.FIELD_ROOMNUMBER);
            if (Util.isEmpty(room_number)){
                /*System.out.println(room_number);*/
                throw new ApplicationException(ExceptionSeverity.ERROR, "Room Number not found!");
            }
            Expression e = new Expression(Room.FIELD_ROOMNUMBER, REL_OP.EQ, room_number);
            return RoomHelper.getInstance().getByExpression(e);
        }

        return super.getQuery(ctx, queryId, map, service);
    }
}