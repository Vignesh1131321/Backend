/*
 * Copyright 2010-2020 M16, Inc. All rights reserved.
 * This software and documentation contain valuable trade
 * secrets and proprietary property belonging to M16, Inc.
 * None of this software and documentation may be copied,
 * duplicated or disclosed without the express
 * written permission of M16, Inc.
 */

package com.flightBooking.resource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import platform.exception.ExceptionEnum;
 import platform.resource.BaseResource;
import platform.util.*;
import org.springframework.stereotype.Component;
import platform.db.*;
import java.util.*;
import com.flightBooking.message.*;
import com.flightBooking.helper.*;
import com.flightBooking.service.*;

/*
 ********** This is a generated class Don't modify it.Extend this file for additional functionality **********
 * 
 */
@Component
 public class Room extends BaseResource {
	private String id = null;
	private String g_created_by_id = null;
	private String g_created_by_name = null;
	private String g_modified_by_id = null;
	private String g_modified_by_name = null;
	private Long g_creation_time = null;
	private Long g_modify_time = null;
	private String g_soft_delete = null;
	private String g_status = null;
	private String archived = null;
	private Long archived_time = null;
	private String roomnumber = null;
	private Long floor = null;
	private String block = null;
	private String roomtype = null;
	private Map<String, Object> extra_data = null;

	public static String FIELD_ID = "id";
	public static String FIELD_G_CREATED_BY_ID = "g_created_by_id";
	public static String FIELD_G_CREATED_BY_NAME = "g_created_by_name";
	public static String FIELD_G_MODIFIED_BY_ID = "g_modified_by_id";
	public static String FIELD_G_MODIFIED_BY_NAME = "g_modified_by_name";
	public static String FIELD_G_CREATION_TIME = "g_creation_time";
	public static String FIELD_G_MODIFY_TIME = "g_modify_time";
	public static String FIELD_G_SOFT_DELETE = "g_soft_delete";
	public static String FIELD_G_STATUS = "g_status";
	public static String FIELD_ARCHIVED = "archived";
	public static String FIELD_ARCHIVED_TIME = "archived_time";
	public static String FIELD_ROOMNUMBER = "roomnumber";
	public static String FIELD_FLOOR = "floor";
	public static String FIELD_BLOCK = "block";
	public static String FIELD_ROOMTYPE = "roomtype";
	public static String FIELD_EXTRA_DATA = "extra_data";

	private static final long serialVersionUID = 1L;
	public final static ResourceMetaData metaData = new ResourceMetaData("room");

	static {
		metaData.setCheckBeforeAdd(false);
		metaData.setCheckBeforeUpdate(false);

		metaData.setAllow_duplicate_name(false);
		Field idField = new Field("id", "String");
		idField.setRequired(true);
		metaData.addField(idField);

		Field g_created_by_idField = new Field("g_created_by_id", "String");
		g_created_by_idField.setLength(128);
		metaData.addField(g_created_by_idField);

		Field g_created_by_nameField = new Field("g_created_by_name", "String");
		g_created_by_nameField.setLength(128);
		metaData.addField(g_created_by_nameField);

		Field g_modified_by_idField = new Field("g_modified_by_id", "String");
		g_modified_by_idField.setLength(128);
		metaData.addField(g_modified_by_idField);

		Field g_modified_by_nameField = new Field("g_modified_by_name", "String");
		g_modified_by_nameField.setLength(128);
		metaData.addField(g_modified_by_nameField);

		Field g_creation_timeField = new Field("g_creation_time", "long");
		metaData.addField(g_creation_timeField);

		Field g_modify_timeField = new Field("g_modify_time", "long");
		metaData.addField(g_modify_timeField);

		Field g_soft_deleteField = new Field("g_soft_delete", "String");
		g_soft_deleteField.setDefaultValue("N");
		g_soft_deleteField.setLength(1);
		metaData.addField(g_soft_deleteField);

		Field g_statusField = new Field("g_status", "String");
		g_statusField.setIndexed(true);
		g_statusField.setLength(32);
		metaData.addField(g_statusField);

		Field archivedField = new Field("archived", "String");
		archivedField.setIndexed(true);
		archivedField.setDefaultValue("N");
		archivedField.setLength(1);
		metaData.addField(archivedField);

		Field archived_timeField = new Field("archived_time", "long");
		metaData.addField(archived_timeField);

		Field roomnumberField = new Field("roomnumber", "String");
		roomnumberField.setRequired(true);
		metaData.addField(roomnumberField);

		Field floorField = new Field("floor", "Long");
		floorField.setRequired(true);
		metaData.addField(floorField);

		Field blockField = new Field("block", "String");
		blockField.setRequired(true);
		metaData.addField(blockField);

		Field roomtypeField = new Field("roomtype", "String");
		roomtypeField.setEnum(true);
		roomtypeField.setPossible_value("Roomtype");
		metaData.addField(roomtypeField);

		Field extra_dataField = new Field("extra_data", "Map");
		extra_dataField.setValueType("Object");
		metaData.addField(extra_dataField);


		metaData.setTableName("room");

		metaData.setCluster("traveler_db");
	}

	public Room() {this.setId(Util.getUniqueId());}
	public Room(String id) {this.setId(id);}

	public Room(Room obj) {
		this.id = obj.id;
		this.g_created_by_id = obj.g_created_by_id;
		this.g_created_by_name = obj.g_created_by_name;
		this.g_modified_by_id = obj.g_modified_by_id;
		this.g_modified_by_name = obj.g_modified_by_name;
		this.g_creation_time = obj.g_creation_time;
		this.g_modify_time = obj.g_modify_time;
		this.g_soft_delete = obj.g_soft_delete;
		this.g_status = obj.g_status;
		this.archived = obj.archived;
		this.archived_time = obj.archived_time;
		this.roomnumber = obj.roomnumber;
		this.floor = obj.floor;
		this.block = obj.block;
		this.roomtype = obj.roomtype;
		this.extra_data = obj.extra_data;
	}

	public ResourceMetaData getMetaData() {
		return metaData;
	}

	private void setDefaultValues() {
		if(g_soft_delete == null)
			g_soft_delete = "N";
		if(archived == null)
			archived = "N";
	}

	public Map<String, Object> convertResourceToMap(HashMap<String, Object> map) {
		if(id != null)
			map.put("id", id);
		if(g_created_by_id != null)
			map.put("g_created_by_id", g_created_by_id);
		if(g_created_by_name != null)
			map.put("g_created_by_name", g_created_by_name);
		if(g_modified_by_id != null)
			map.put("g_modified_by_id", g_modified_by_id);
		if(g_modified_by_name != null)
			map.put("g_modified_by_name", g_modified_by_name);
		if(g_creation_time != null)
			map.put("g_creation_time", g_creation_time);
		if(g_modify_time != null)
			map.put("g_modify_time", g_modify_time);
		if(g_soft_delete != null)
			map.put("g_soft_delete", g_soft_delete);
		if(g_status != null)
			map.put("g_status", g_status);
		if(archived != null)
			map.put("archived", archived);
		if(archived_time != null)
			map.put("archived_time", archived_time);
		if(roomnumber != null)
			map.put("roomnumber", roomnumber);
		if(floor != null)
			map.put("floor", floor);
		if(block != null)
			map.put("block", block);
		if(roomtype != null)
			map.put("roomtype", roomtype);
		if(extra_data != null)
			map.put("extra_data", extra_data);
		return map;
	}

	public Map<String, Object> validateAndConvertResourceToMap(HashMap<String,Object> map,boolean add) throws ApplicationException {
		if(validateId(add))
			map.put("id", id);
		if(g_created_by_id != null)
			map.put("g_created_by_id", g_created_by_id);
		if(g_created_by_name != null)
			map.put("g_created_by_name", g_created_by_name);
		if(g_modified_by_id != null)
			map.put("g_modified_by_id", g_modified_by_id);
		if(g_modified_by_name != null)
			map.put("g_modified_by_name", g_modified_by_name);
		if(g_creation_time != null)
			map.put("g_creation_time", g_creation_time);
		if(g_modify_time != null)
			map.put("g_modify_time", g_modify_time);
		if(g_soft_delete != null)
			map.put("g_soft_delete", g_soft_delete);
		if(g_status != null)
			map.put("g_status", g_status);
		if(archived != null)
			map.put("archived", archived);
		if(archived_time != null)
			map.put("archived_time", archived_time);
		if(validateRoomnumber(add))
			map.put("roomnumber", roomnumber);
		if(validateFloor(add))
			map.put("floor", floor);
		if(validateBlock(add))
			map.put("block", block);
		if(roomtype != null)
			map.put("roomtype", roomtype);
		if(extra_data != null)
			map.put("extra_data", extra_data);
		return map;
	}

	public Map<String, Object> convertResourceToPrimaryMap(HashMap<String, Object> map) {
		return map;
	}

	@SuppressWarnings("unchecked")
	public void convertMapToResource(Map<String, Object> map) {
		id = (String) map.get("id");
		g_created_by_id = (String) map.get("g_created_by_id");
		g_created_by_name = (String) map.get("g_created_by_name");
		g_modified_by_id = (String) map.get("g_modified_by_id");
		g_modified_by_name = (String) map.get("g_modified_by_name");
		g_creation_time = (map.get("g_creation_time") == null ? null : ((Number) map.get("g_creation_time")).longValue());
		g_modify_time = (map.get("g_modify_time") == null ? null : ((Number) map.get("g_modify_time")).longValue());
		g_soft_delete = (String) map.get("g_soft_delete");
		g_status = (String) map.get("g_status");
		archived = (String) map.get("archived");
		archived_time = (map.get("archived_time") == null ? null : ((Number) map.get("archived_time")).longValue());
		roomnumber = (String) map.get("roomnumber");
		floor = (map.get("floor") == null ? null : ((Number) map.get("floor")).longValue());
		block = (String) map.get("block");
		roomtype = (String) map.get("roomtype");
		extra_data = (Map<String, Object>) map.get("extra_data");
	}

	@SuppressWarnings("unchecked")
	public void convertTypeUnsafeMapToResource(Map<String, Object> map) {
		Object idObj = map.get("id");
		if(idObj != null)
			id = idObj.toString();

		Object g_created_by_idObj = map.get("g_created_by_id");
		if(g_created_by_idObj != null)
			g_created_by_id = g_created_by_idObj.toString();

		Object g_created_by_nameObj = map.get("g_created_by_name");
		if(g_created_by_nameObj != null)
			g_created_by_name = g_created_by_nameObj.toString();

		Object g_modified_by_idObj = map.get("g_modified_by_id");
		if(g_modified_by_idObj != null)
			g_modified_by_id = g_modified_by_idObj.toString();

		Object g_modified_by_nameObj = map.get("g_modified_by_name");
		if(g_modified_by_nameObj != null)
			g_modified_by_name = g_modified_by_nameObj.toString();

		Object g_creation_timeObj = map.get("g_creation_time");
		if(g_creation_timeObj != null)
			g_creation_time = new Long(g_creation_timeObj.toString());

		Object g_modify_timeObj = map.get("g_modify_time");
		if(g_modify_timeObj != null)
			g_modify_time = new Long(g_modify_timeObj.toString());

		Object g_soft_deleteObj = map.get("g_soft_delete");
		if(g_soft_deleteObj != null)
			g_soft_delete = g_soft_deleteObj.toString();

		Object g_statusObj = map.get("g_status");
		if(g_statusObj != null)
			g_status = g_statusObj.toString();

		Object archivedObj = map.get("archived");
		if(archivedObj != null)
			archived = archivedObj.toString();

		Object archived_timeObj = map.get("archived_time");
		if(archived_timeObj != null)
			archived_time = new Long(archived_timeObj.toString());

		Object roomnumberObj = map.get("roomnumber");
		if(roomnumberObj != null)
			roomnumber = roomnumberObj.toString();

		Object floorObj = map.get("floor");
		if(floorObj != null)
			floor = new Long(floorObj.toString());

		Object blockObj = map.get("block");
		if(blockObj != null)
			block = blockObj.toString();

		Object roomtypeObj = map.get("roomtype");
		if(roomtypeObj != null)
			roomtype = roomtypeObj.toString();

		extra_data = (Map<String, Object>) map.get("extra_data");
	}

	public void convertPrimaryMapToResource(Map<String, Object> map) {
	}

	public void convertTypeUnsafePrimaryMapToResource(Map<String, Object> map) {
	}

	public String getId() {
		return id;
	}

	public String getIdEx() {
		return id != null ? id : "";
	}

	public void setId(String id) {
		this.id = id;
	}

	public void unSetId() {
		this.id = null;
	}

	public boolean validateId(boolean add) throws ApplicationException {
		if(add && id == null)
			throw new ApplicationException(ExceptionSeverity.ERROR, "Requierd validation Failed[id]");
		return id != null;
	}

	public String getG_created_by_id() {
		return g_created_by_id;
	}

	public String getG_created_by_idEx() {
		return g_created_by_id != null ? g_created_by_id : "";
	}

	public void setG_created_by_id(String g_created_by_id) {
		this.g_created_by_id = g_created_by_id;
	}

	public void unSetG_created_by_id() {
		this.g_created_by_id = null;
	}

	public String getG_created_by_name() {
		return g_created_by_name;
	}

	public String getG_created_by_nameEx() {
		return g_created_by_name != null ? g_created_by_name : "";
	}

	public void setG_created_by_name(String g_created_by_name) {
		this.g_created_by_name = g_created_by_name;
	}

	public void unSetG_created_by_name() {
		this.g_created_by_name = null;
	}

	public String getG_modified_by_id() {
		return g_modified_by_id;
	}

	public String getG_modified_by_idEx() {
		return g_modified_by_id != null ? g_modified_by_id : "";
	}

	public void setG_modified_by_id(String g_modified_by_id) {
		this.g_modified_by_id = g_modified_by_id;
	}

	public void unSetG_modified_by_id() {
		this.g_modified_by_id = null;
	}

	public String getG_modified_by_name() {
		return g_modified_by_name;
	}

	public String getG_modified_by_nameEx() {
		return g_modified_by_name != null ? g_modified_by_name : "";
	}

	public void setG_modified_by_name(String g_modified_by_name) {
		this.g_modified_by_name = g_modified_by_name;
	}

	public void unSetG_modified_by_name() {
		this.g_modified_by_name = null;
	}

	public Long getG_creation_time() {
		return g_creation_time;
	}

	public long getG_creation_timeEx() {
		return g_creation_time != null ? g_creation_time : 0L;
	}

	public void setG_creation_time(long g_creation_time) {
		this.g_creation_time = g_creation_time;
	}

	@JsonIgnore
	public void setG_creation_time(Long g_creation_time) {
		this.g_creation_time = g_creation_time;
	}

	public void unSetG_creation_time() {
		this.g_creation_time = null;
	}

	public Long getG_modify_time() {
		return g_modify_time;
	}

	public long getG_modify_timeEx() {
		return g_modify_time != null ? g_modify_time : 0L;
	}

	public void setG_modify_time(long g_modify_time) {
		this.g_modify_time = g_modify_time;
	}

	@JsonIgnore
	public void setG_modify_time(Long g_modify_time) {
		this.g_modify_time = g_modify_time;
	}

	public void unSetG_modify_time() {
		this.g_modify_time = null;
	}

	public String getG_soft_delete() {
		return g_soft_delete != null ? g_soft_delete : "N";
	}

	public void setG_soft_delete(String g_soft_delete) {
		this.g_soft_delete = g_soft_delete;
	}

	public void unSetG_soft_delete() {
		this.g_soft_delete = "N";
	}

	public String getG_status() {
		return g_status;
	}

	public String getG_statusEx() {
		return g_status != null ? g_status : "";
	}

	public void setG_status(String g_status) {
		this.g_status = g_status;
	}

	public void unSetG_status() {
		this.g_status = null;
	}

	public String getArchived() {
		return archived != null ? archived : "N";
	}

	public void setArchived(String archived) {
		this.archived = archived;
	}

	public void unSetArchived() {
		this.archived = "N";
	}

	public Long getArchived_time() {
		return archived_time;
	}

	public long getArchived_timeEx() {
		return archived_time != null ? archived_time : 0L;
	}

	public void setArchived_time(long archived_time) {
		this.archived_time = archived_time;
	}

	@JsonIgnore
	public void setArchived_time(Long archived_time) {
		this.archived_time = archived_time;
	}

	public void unSetArchived_time() {
		this.archived_time = null;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public String getRoomnumberEx() {
		return roomnumber != null ? roomnumber : "";
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public void unSetRoomnumber() {
		this.roomnumber = null;
	}

	public boolean validateRoomnumber(boolean add) throws ApplicationException {
		if(add && roomnumber == null)
			throw new ApplicationException(ExceptionSeverity.ERROR, "Requierd validation Failed[roomnumber]");
		return roomnumber != null;
	}

	public Long getFloor() {
		return floor;
	}

	public void setFloor(Long floor) {
		this.floor = floor;
	}

	public void unSetFloor() {
		this.floor = null;
	}

	public boolean validateFloor(boolean add) throws ApplicationException {
		if(add && floor == null)
			throw new ApplicationException(ExceptionSeverity.ERROR, "Requierd validation Failed[floor]");
		return floor != null;
	}

	public String getBlock() {
		return block;
	}

	public String getBlockEx() {
		return block != null ? block : "";
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public void unSetBlock() {
		this.block = null;
	}

	public boolean validateBlock(boolean add) throws ApplicationException {
		if(add && block == null)
			throw new ApplicationException(ExceptionSeverity.ERROR, "Requierd validation Failed[block]");
		return block != null;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public String getRoomtypeEx() {
		return roomtype != null ? roomtype : "";
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public void unSetRoomtype() {
		this.roomtype = null;
	}

	public Map<String, Object> getExtra_data() {
		return extra_data;
	}

	public Object getExtra_data(String key) {
		return extra_data == null ? null : extra_data.get(key);
	}

	public void setExtra_data(Map<String, Object> extra_data) {
		this.extra_data = extra_data;
	}

	public void setExtra_data(String key, Object value) {
		if(extra_data == null)
			extra_data = new HashMap<String, Object>();
		extra_data.put(key, value);
	}

	public void unSetExtra_data() {
		this.extra_data = null;
	}
	public String getCluster() {
		return "traveler_db";
	}
	public String getClusterType() {
		return "REPLICATED";
	}
	public  Class<?> getResultClass() {return RoomResult.class;};
	public  Class<?> getMessageClass() {return RoomMessage.class;};
	public  Class<?> getHelperClass() {return RoomHelper.class;};
	public  Class<?> getServiceClass() {return RoomService.class;};
}