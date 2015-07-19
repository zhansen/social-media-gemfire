package io.pivotal.socialmedia.domain;

import java.io.Serializable;
import java.util.Date;


public class Post implements Serializable{
	
	private static final long serialVersionUID = 2961696719604447073L;
	
	
	private Integer postNumber;
	//private Date    postDate;
	private Integer userId;
	private String  myPost;
	
	public Post(Integer postNumber, 
			//Date postDate, 
			String myPost, 
			Integer userId
			)
	{
		super();
		this.setPostNumber(postNumber);
		//this.setPostDate(postDate);
		this.setUserId(userId);
		this.setMyPost(myPost);
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((getPostNumber() == null) ? 0 : getPostNumber().hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (getPostNumber() == null)
		{
			if (other.getPostNumber() != null)
				return false;
		} else if (!getPostNumber().equals(other.getPostNumber()))
			return false;
		return true;
	}
	

	@Override
	public String toString()
	{
		return "Post [postNumber=" + getPostNumber()
				+ ", post=" + getMyPost() + ", userId=" + getUserId()
				+ "]";
	}

	public Integer getPostNumber() {
		return postNumber;
	}

	private void setPostNumber(Integer postNumber) {
		this.postNumber = postNumber;
	}
/*
	private Date getPostDate() {
		return postDate;
	}

	private void setPostDate(Date postDate) {
		this.postDate = postDate;
	}*/

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMyPost() {
		return myPost;
	}

	private void setMyPost(String myPost) {
		this.myPost = myPost;
	}
}
