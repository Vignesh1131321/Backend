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

public class StudentDecorator extends BaseDecorator {
    public StudentDecorator(){
        super(new Student());
    }

    @Override
    public void preAddDecorator (ServletContext stx, BaseResource _resource) throws ApplicationException {
        Student Student = (Student) _resource;
        BaseResource[] Students = StudentHelper.getInstance().getAll();
        for (BaseResource baseRes : Students) {
            Student stu = (Student) baseRes;
            if (Objects.equals(Student.getRollnumber(), stu.getRollnumber())) {
                throw new ApplicationException(ExceptionSeverity.ERROR, "Roll number already present");
            }
        }
    }

    @Override
    public BaseResource[] getQuery(ServletContext ctx, String queryId, Map<String, Object> map, BaseService service) throws ApplicationException{
        System.out.println("HI");
        if ("GET_STUDENT_BY_ID".equalsIgnoreCase(queryId)){
            System.out.println(map);
            String id = (String) map.get(Student.FIELD_ID);
            if (Util.isEmpty(id)){
                throw new ApplicationException(ExceptionSeverity.ERROR, "ID not found!");
            }
            Expression e = new Expression(Student.FIELD_ID, REL_OP.EQ, id);
            return StudentHelper.getInstance().getByExpression(e);
        }
        else if("GET_STUDENT_BY_ROLL_NUMBER".equalsIgnoreCase(queryId)){
            String roll_number = (String) map.get(Student.FIELD_ROLLNUMBER);
            if (Util.isEmpty(roll_number)){
                /*System.out.println(roll_number);*/
                throw new ApplicationException(ExceptionSeverity.ERROR, "Room Number not found!");
            }
            Expression e = new Expression(Student.FIELD_ROLLNUMBER, REL_OP.EQ, roll_number);
            return StudentHelper.getInstance().getByExpression(e);
        }

        return super.getQuery(ctx, queryId, map, service);


    }
}