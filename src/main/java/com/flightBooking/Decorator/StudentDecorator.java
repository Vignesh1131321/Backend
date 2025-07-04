package com.flightBooking.Decorator;

import com.flightBooking.helper.StudentHelper;
import com.flightBooking.resource.Student;
import platform.decorator.BaseDecorator;
import platform.resource.BaseResource;
import platform.util.ApplicationException;
import platform.util.ExceptionSeverity;
import platform.webservice.ServletContext;

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
}