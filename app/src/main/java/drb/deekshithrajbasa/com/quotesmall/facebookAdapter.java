package drb.deekshithrajbasa.com.quotesmall;

public class facebookAdapter {

    private String title,description,image;
    public facebookAdapter() {
    }
    public facebookAdapter(String title, String description) {
        this.title = title;
        this.description = description;
       // this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
