package se.tr1golf.classes;

public class Course {
	private int courseId;
	private String courseName;

	public Course(Builder builder) {
		this.courseId = builder.courseId;
		this.courseName = builder.courseName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public static class Builder{
		private int courseId;
		private String courseName;
		
		public Builder setCourseId(int courseId){
			this.courseId = courseId;
			return this;
		}
		
		public Builder setCourseName(String courseName){
			this.courseName = courseName;
			return this;
		}
		
		public Course build(){
			Course course = new Course(this);
			validate(course);
			return course;
		}

		private void validate(Course course) {
			// TODO Auto-generated method stub
			
		}
	}

}
