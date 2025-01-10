package com.info.web.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;


@Entity 
@Table(name="roles")
public class RoleModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	@NotEmpty(message = "Название роли не может быть пустым")
	private String name;
	
	@CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE)
    private Set<UserModel> users = new HashSet<>();
    
	public RoleModel(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public RoleModel() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}	
}
