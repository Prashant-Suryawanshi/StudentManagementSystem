package studentManagementSystem;

public class Student {
	private String name;
	private Integer rollNo;
	private Integer standard;
	private Integer scienceMark;
	private Integer mathMark;
	private Integer englishMark;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String name, Integer rollNo, Integer standard, Integer scienceMark, Integer mathMark,
			Integer englishMark) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.standard = standard;
		this.scienceMark = scienceMark;
		this.mathMark = mathMark;
		this.englishMark = englishMark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRollNo() {
		return rollNo;
	}
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	public Integer getScienceMark() {
		return scienceMark;
	}
	public void setScienceMark(Integer scienceMark) {
		this.scienceMark = scienceMark;
	}
	public Integer getMathMark() {
		return mathMark;
	}
	public void setMathMark(Integer mathMark) {
		this.mathMark = mathMark;
	}
	public Integer getEnglishMark() {
		return englishMark;
	}
	public void setEnglishMark(Integer englishMark) {
		this.englishMark = englishMark;
	}
	
}
