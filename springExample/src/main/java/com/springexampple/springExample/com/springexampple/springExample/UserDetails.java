package com.springexampple.springExample.com.springexampple.springExample;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class UserDetails  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes= "The id cannot be null and is auto set")
	private Integer uId;
	@Size(min=2,message="User Name should be atleast 2 character long.")
	@ApiModelProperty(notes = "UserName minimum size = 2")
	private String userName;
	@Past
	@ApiModelProperty(notes= "Should be in past", dataType = "Date", required = false)
	private Date dateOfJoining;
	@javax.validation.constraints.NotNull
	@JsonIgnore
	private String addr;
	
	
	public UserDetails() {
		super();
	}
	public UserDetails(Integer uId, String userName, Date dateOfJoining, String addr) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.dateOfJoining = dateOfJoining;
		this.addr = addr;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getaddr() {
		return addr;
	}
	public void setaddr(String addr) {
		this.addr = addr;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserDetails [uId=" + uId + ", userName=" + userName + ", dateOfJoining=" + dateOfJoining + ", addr="
				+ addr + "]";
	}
	
}
