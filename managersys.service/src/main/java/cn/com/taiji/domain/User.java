package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;

import cn.com.taiji.utils.Audited;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private int age;

//	private String password;
	
	private Timestamp birthday;

	private String education;

	private String email;

	@Column(name="emp_type")
	private String empType;

	@Column(name="first_dept_desc")
	private String firstDeptDesc;

	private Timestamp hiredate;

	@Lob
	private byte[] images;

	private String phone;

	@Column(name="position_level")
	private String positionLevel;

	@Column(name="position_name")
	private String positionName;

	@Column(name="position_order")
	private String positionOrder;

	@Column(name="second_dept_desc")
	private String secondDeptDesc;

	private String sex;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_num")
	private String userNum;

	@Column(name="work_addr")
	private String workAddr;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="uid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="rid")
			}
		)
	private List<Role> roles;

	public User() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Timestamp getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmpType() {
		return this.empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getFirstDeptDesc() {
		return this.firstDeptDesc;
	}

	public void setFirstDeptDesc(String firstDeptDesc) {
		this.firstDeptDesc = firstDeptDesc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}

	public byte[] getImages() {
		return this.images;
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPositionLevel() {
		return this.positionLevel;
	}

	public void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionOrder() {
		return this.positionOrder;
	}

	public void setPositionOrder(String positionOrder) {
		this.positionOrder = positionOrder;
	}

	public String getSecondDeptDesc() {
		return this.secondDeptDesc;
	}

	public void setSecondDeptDesc(String secondDeptDesc) {
		this.secondDeptDesc = secondDeptDesc;
	}


	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getWorkAddr() {
		return this.workAddr;
	}

	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	/**
	 * @Description: 简要进行方法说明，并对基础数据类型的参数和返回值加以说明
	 * @param str void  
	 * @throws
	 * @author Administrator
	 * @date 2017年12月20日
	 */
	

}