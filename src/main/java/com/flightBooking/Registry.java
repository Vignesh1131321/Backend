package com.flightBooking;
import platform.helper.HelperManager;
import platform.webservice.ServiceManager;
import com.flightBooking.helper.*;
import com.flightBooking.service.*;
public class Registry {
		public static void register(){
				 HelperManager.getInstance().register(AllotmentHelper.getInstance());
				 HelperManager.getInstance().register(CourseeHelper.getInstance());
				 HelperManager.getInstance().register(HostelHelper.getInstance());
				 HelperManager.getInstance().register(OccupancyHelper.getInstance());
				 HelperManager.getInstance().register(ResidentHelper.getInstance());
				 HelperManager.getInstance().register(RoomHelper.getInstance());
				 HelperManager.getInstance().register(StudentHelper.getInstance());
				 HelperManager.getInstance().register(VacatedlistHelper.getInstance());
				 ServiceManager.getInstance().register(new AllotmentService());
				 ServiceManager.getInstance().register(new CourseeService());
				 ServiceManager.getInstance().register(new HostelService());
				 ServiceManager.getInstance().register(new OccupancyService());
				 ServiceManager.getInstance().register(new ResidentService());
				 ServiceManager.getInstance().register(new RoomService());
				 ServiceManager.getInstance().register(new StudentService());
				 ServiceManager.getInstance().register(new VacatedlistService());
		}
}
