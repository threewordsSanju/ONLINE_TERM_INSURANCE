package com.onlinetermInsurance.entity;

import javax.persistence.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
 
import com.sun.istack.NotNull;
 
@Entity
public class Admin {
 
    @Id
    @GeneratedValue
    private int adminId;
    
    @NotEmpty(message = "Name is required")
    @NotNull
    @Size(min=3,max=8)
    @Pattern(regexp="^[A-Z][a-z]",message="length must be 10") 
    private String adminName;
    @NotNull
    @Size(max=10)
    private String adminContact;
    
    public Admin() {
		// TODO Auto-generated constructor stub
	}
    
	public Admin(
			@NotEmpty(message = "Name is required") @Size(min = 3, max = 6) @Pattern(regexp = "^[A-Z][a-z]", message = "length must be 10") String adminName,
			@Size(max = 10) String adminContact) {
		super();
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact + "]";
	}
}
