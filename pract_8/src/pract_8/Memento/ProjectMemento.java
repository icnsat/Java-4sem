package pract_8.Memento;

import java.util.Date;

public class ProjectMemento {
    private String version;
    private Date date;
    public void setVersion(String ver){
        this.version = ver;
        this.date = new Date();
    }
    public Save save(){
        return new Save(this.version);
    }
    public void load(Save save){
        this.version = save.getVersion();
        this.date = save.getDate();
    }
    @Override
    public String toString() {
        return "Project:\n" +
                "Date: " + this.date +
                "\nVersion: " + this.version + "\n";
    }
}
