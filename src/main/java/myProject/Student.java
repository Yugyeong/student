package myProject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

@Entity
@Table(name="Student_table")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long studentId;
    private String status;
    private String studentName;
    private String className;

    @PostPersist
    public void onPostPersist(){
    	
    	if(null == this.getStatus()||"".equals(this.getStatus())){
            System.out.println("##### status is null #####");
            return;
        }
    	else {
    		//myProject.external.MyClass myClass = new myProject.external.MyClass();
    		
    		Signed signed = new Signed();
            signed.setClassName(this.getClassName());
            signed.setStatus(this.getStatus());
            signed.setStudentName(this.getStudentName());
    		
    		//myClass.setClassName(this.getClassName());
    		//myClass.setStatus(this.getStatus());
    		//myClass.setStudentName(this.getStudentName());
    		//myClass.setStudentId(this.getStudentId());
            
            //StudentApplication.applicationContext.getBean(myProject.external.MyClassService.class).studentSign(myClass);
    		//StudentApplication.applicationContext.getBean(myProject.external.MyClassService.class).studentChange(myClass);
            
            BeanUtils.copyProperties(this, signed);
            signed.publishAfterCommit();
            
    	}

    }

    @PostUpdate
    public void onPostUpdate() {
    	if(this.getStatus().equals("Change")) {
    		myProject.external.MyClass myClass = new myProject.external.MyClass();
    		
    		myClass.setClassName(this.getClassName());
    		myClass.setStatus(this.getStatus());
    		myClass.setStudentName(this.getStudentName());
    		myClass.setStudentId(this.getStudentId());
    		
    		StudentApplication.applicationContext.getBean(myProject.external.MyClassService.class).studentChange(myClass);
    		
    		//Changed changed = new Changed();
            //BeanUtils.copyProperties(this, changed);
            //changed.publishAfterCommit();
    	}
    	
    	if(this.getStatus().equals("Cancel")) {
            Canceled canceled = new Canceled();
            BeanUtils.copyProperties(this, canceled);
            canceled.publishAfterCommit();
    	}
    	
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }




}
