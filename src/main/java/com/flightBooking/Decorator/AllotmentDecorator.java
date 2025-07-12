package com.flightBooking.Decorator;

import com.flightBooking.helper.RoomHelper;
import com.flightBooking.helper.AllotmentHelper;
import com.flightBooking.resource.Allotment;
import com.flightBooking.resource.Room;
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

public class AllotmentDecorator extends BaseDecorator {
    public AllotmentDecorator(){
        super(new Allotment());
    }

    @Override
    public void preAddDecorator (ServletContext stx, BaseResource _resource) throws ApplicationException {
        Allotment Allotment = (Allotment) _resource;
        BaseResource[] Allotments = AllotmentHelper.getInstance().getAll();
        for (BaseResource baseRes : Allotments) {
            Allotment all = (Allotment) baseRes;
            if (Objects.equals(Allotment.getRollnumber(), all.getRollnumber())) {
                throw new ApplicationException(ExceptionSeverity.ERROR, "Roll number already present");
            }
        }
    }

    @Override
    public BaseResource[] getQuery(ServletContext ctx, String queryId, Map<String, Object> map, BaseService service) throws ApplicationException{
        if ("GET_ALLOTMENT_BY_ID".equalsIgnoreCase(queryId)){
            System.out.println(map);
            String id = (String) map.get(Allotment.FIELD_ID);
            if (Util.isEmpty(id)){
                throw new ApplicationException(ExceptionSeverity.ERROR, "ID not found!");
            }
            Expression e = new Expression(Allotment.FIELD_ID, REL_OP.EQ, id);
            return AllotmentHelper.getInstance().getByExpression(e);
        }


        return super.getQuery(ctx, queryId, map, service);


    }
}