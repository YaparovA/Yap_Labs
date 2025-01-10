package com.info.web.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Data 
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity 
@Table(name="users")
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	@NotEmpty(message = "Имя пользователя не может быть пустым")
	private String name;
	
	@Min(value = 1, message = "Возраст не может быть меньше 1")
    @Max(value = 120, message = "Возраст не может превышать 120 лет")
	@NotNull(message = "У пользователя должен быть возраст")
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private RoleModel role;
	
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private CityModel city;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime updatedOn;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<AccessRightsModel> access_rights = new HashSet<>();
	
	public long getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	
	public CityModel getCity() {
		return city;
	}
	public void setCity(CityModel city) {
		this.city = city;
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
