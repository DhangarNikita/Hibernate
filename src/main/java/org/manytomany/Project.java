package org.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emp;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmp() {
        return emp;
    }

    public void setEmp(List<Emp> emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", projectName='" + projectName + '\'' +
                ", emp=" + emp +
                '}';
    }
}
