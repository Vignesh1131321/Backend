/*
 * Copyright 2010-2020 M16, Inc. All rights reserved.
 * This software and documentation contain valuable trade
 * secrets and proprietary property belonging to M16, Inc.
 * None of this software and documentation may be copied,
 * duplicated or disclosed without the express
 * written permission of M16, Inc.
 */

package com.flightBooking.resource;

import platform.webservice.BasePossibleValue;
import platform.webservice.Enum;

/*
 ********** This is a generated class Don't modify it.Extend this file for additional functionality **********
 * 
 */
public class Roomtype extends BasePossibleValue {
		public static String ID_single = "single";
		public static String NAME_single = "single";
		public static String ID_double = "double";
		public static String NAME_double = "double";
		public static String ID_triple = "triple";
		public static String NAME_triple = "triple";
		public Roomtype() {super("ROOMTYPE");}
		protected void populate() {
 			add(new Enum(ID_single,NAME_single));
 			add(new Enum(ID_double,NAME_double));
 			add(new Enum(ID_triple,NAME_triple));
		}
}