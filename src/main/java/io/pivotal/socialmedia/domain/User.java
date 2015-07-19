package io.pivotal.socialmedia.domain;

import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private ArrayList <Integer> myPosts;
	
/*	@SuppressWarnings({ "unchecked", "rawtypes" })
	public User (int userId, String firstName, String lastName)
	{
		super();
		this.setUserId(new Integer(userId));
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setMyPosts(new ArrayList());
		
	}*/
	
	

	public void addPost(Integer postNumber)
	{
		if (myPosts == null)
		{
			myPosts = new ArrayList<Integer>();
		}
		
		     myPosts.add(postNumber);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getUserId() == null) ? 0 : getUserId().hashCode());
		result = prime * result
				+ ((getFirstName() == null) ? 0 : getFirstName().hashCode());
		result = prime * result
				+ ((getLastName() == null) ? 0 : getLastName().hashCode());
		result = prime * result
				+ ((getMyPosts() == null) ? 0 : getMyPosts().hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (getUserId() == null) {
			if (other.getUserId() != null)
				return false;
		} else if (!getUserId().equals(other.getUserId()))
			return false;
		if (getFirstName() == null) {
			if (other.getFirstName() != null)
				return false;
		} else if (!getFirstName().equals(other.getFirstName()))
			return false;
		if (getLastName() == null) {
			if (other.getLastName() != null)
				return false;
		} else if (!getLastName().equals(other.getLastName()))
			return false;
		/*if (getMyPosts() == null) {
			if (other.getMyPosts() != null)
				return false;
		} else if (!getMyPosts().equals(other.getMyPosts()))
			return false;*/
		return true;
	}
	
	@Override
	public String toString()
	{
		return "User [userId=" + getUserId()
				+ ", firstName=" + getFirstName() + ", lastName=" + getLastName()
				+ "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList <Integer> getMyPosts() {
		return myPosts;
	}

	public void setMyPosts(ArrayList <Integer> myPosts) {
		this.myPosts = myPosts;
	}
}
