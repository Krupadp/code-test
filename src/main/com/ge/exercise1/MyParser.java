package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;

public class MyParser extends Application implements Parser{
	Collection<User> users;
	Collection<Group> groups;	
	public MyParser(String id, String name) {
		super(id, name);
	}
	Application app =null; 
	public Application parseApplicationData(String data){
		try {
			 data = data.replaceAll("\\s","").replaceAll("Application", "Application:").replaceAll("\\(", "\\{").replaceAll("\\)", "\\}").replaceAll("User", "").replaceAll("Group", "");
			 data = "{"+data+"}";
			 JSONObject jsonObj = new JSONObject(data);
			 JSONObject appl= jsonObj.getJSONObject("Application");
			 this.setId(appl.get("id").toString());
			 this.setName(appl.get("name").toString());
			 setGroupsAndUsers(appl);
			 
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return this;
	}
	@Override
	public Collection<User> getUsers() {
		return this.users;
	}

	@Override
	public User getUser(String userId) {
		Iterator i = users.iterator();
		while(i.hasNext()){
			User u= (User) i.next();
			if(u.getId().equals(userId)){
				return u;
			}
		}
		return null;
	}

	@Override
	public Collection<Group> getGroups() {
		return this.groups;
	}

	@Override
	public Group getGroup(String groupId) {
		Iterator i = groups.iterator();
		while(i.hasNext()){
			Group g= (Group) i.next();
			if(g.getId().equals(groupId)){
				return g;
			}
		}
		return null;
	}
	public void setGroupsAndUsers(JSONObject json) {
		groups = new ArrayList();
		users = new HashSet();
		Group g = null;
		User u = null;
		try {
			JSONArray user = json.getJSONArray("users");			
			for (int i = 0; i < user.length(); i++) {
				 JSONObject eachUser = user.getJSONObject(i); 
				u= new UserImpl(eachUser.get("id").toString(),eachUser.get("name").toString());
				users.add(u);
			}
			JSONArray group = json.getJSONArray("groups");
			for (int i = 0; i < group.length(); i++) {
				 JSONObject eachGroup = group.getJSONObject(i); 
				g= new GroupImpl(eachGroup.get("id").toString(),eachGroup.get("name").toString());				
				int count = 0;
				JSONArray user1 = eachGroup.getJSONArray("users");				
				for (int j = 0; j < user1.length(); j++) {	
					JSONObject eachUser = user1.getJSONObject(i);
					u = new UserImpl(eachUser.get("id").toString(),eachUser.get("name").toString());
					users.add(u);
					count++;
				}
				g.size = count;
				groups.add(g);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}