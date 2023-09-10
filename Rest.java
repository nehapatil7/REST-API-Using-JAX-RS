package restapi.crud.REST;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Rest {


	private String Sname;
	private int Sid;
	
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		this.Sname = sname;
	}
	public int getSid() {
		return Sid;
	}
	public void setSid(int sid) {
		this.Sid = sid;
	}
	@Override
	public String toString() {
		return "Rest [Name=" + Sname + ", Sid=" + Sid + "]";
	}
	


}
