package com.graph.redis.core.object;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class RepositoryNode {
	@JsonIgnore
	private String cypherCreateString;

	@JsonIgnore
	private String propertyNames;

	@JsonIgnore
	private String cypherGetAllString;

	@JsonIgnore
	private String cypherUpdateString;

	public final String getCypherCreateString() {
		return getObjectString();
	}

	public final String getCypherGetAllString() {
		return buildCypherGetAllString();
	}

	public final String getCypherUpdateString(String ns) {
		return buildCypherUpdateString(ns);
	}

	public final List<String> getPropertyNames() {
		Class<? extends Object> c1 = this.getClass();
		Field[] fields = c1.getDeclaredFields();
		List<String> properties = new ArrayList<String>();
		// Check field annotation
		// If has @ID annotation generate the ID
		try {
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				properties.add(name);

			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}

	private String buildCypherGetAllString() {
		String cypherString = "";
		for (String propName : this.getPropertyNames()) {
			cypherString += " get." + propName + " as " + propName;
			cypherString += ",";
		}
		cypherString = cypherString.replaceAll(",$", " ");
		return cypherString;
	}

	private String getObjectString() {
		Class<? extends Object> c1 = this.getClass();
		String os = "{";
		Field[] fields = c1.getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				fields[i].setAccessible(true);
				if (fields[i].getAnnotation(GraphElementIdentifier.class) != null) {
					String id = UUID.randomUUID().toString();
					fields[i].set(this, id);
					System.out.println(fields[i].getName());
				}
				Object value;
				value = fields[i].get(this);
				if (value != null) {
					os += name + ":'" + value + "'";
					os += ",";
				}
			}
			os = os.replaceAll(",$", " ");
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		os += "}";
		return os;
	}

	private String buildCypherFilterString(String ns) {
		Class<? extends Object> c1 = this.getClass();
		String os = "";
		Field[] fields = c1.getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				fields[i].setAccessible(true);
				Object value;
				value = fields[i].get(this);
				if (value != null) {
					os += ns + "." + name + " = '" + value + "'";
					os += " AND ";
				}
				os = os.replaceAll(" AND $", " ");
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(os);
		return os;
	}

	private final String buildCypherUpdateString(String ns) {
		Class<? extends Object> c1 = this.getClass();
		String us = "";
		Field[] fields = c1.getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getAnnotation(GraphElementIdentifier.class) == null) {
					String name = fields[i].getName();
					fields[i].setAccessible(true);
					Object value;
					value = fields[i].get(this);
					if (value != null) {
						us += ns + "." + name + " = '" + value + "'";
						us += ", ";
					}
				}
			}
			us = us.replaceAll(", $", " ");
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(us);
		return us;
	}

	public final String getCypherFilterString(String ns) {
		return buildCypherFilterString(ns);
	}

}
