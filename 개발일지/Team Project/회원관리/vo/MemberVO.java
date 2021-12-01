package mc.sn.team.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String sub_name;
	private String birth;
	private String num;
	private String email;
	private String si;
	private String doe;
	private String gu;
	private String detail_address;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String id, String pwd, String name, String sub_name, String birth, String num, String email,
			String si, String doe, String gu, String detail_address) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.sub_name = sub_name;
		this.birth = birth;
		this.num = num;
		this.email = email;
		this.si = si;
		this.doe = doe;
		this.gu = gu;
		this.detail_address = detail_address;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", sub_name=" + sub_name + ", birth=" + birth
				+ ", num=" + num + ", email=" + email + ", si=" + si + ", doe=" + doe + ", gu=" + gu
				+ ", detail_address=" + detail_address + "]";
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getSi() {
		return si;
	}
	public void setSi(String si) {
		this.si = si;
	}
	public String getDoe() {
		return doe;
	}
	public void setDoe(String doe) {
		this.doe = doe;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getDetail_address() {
		return detail_address;
	}
	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
	
	
}
