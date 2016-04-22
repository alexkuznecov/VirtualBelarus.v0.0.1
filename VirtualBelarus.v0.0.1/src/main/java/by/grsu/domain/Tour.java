package by.grsu.domain;

import java.util.List;

public class Tour {

    private Integer id;

    private String title;

    private String about;

    private Location location;

    private Image preview;

    private List<Scene> scenes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Image getPreview() {
        return preview;
    }

    public void setPreview(Image preview) {
        this.preview = preview;
    }

    public List<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(List<Scene> scenes) {
        this.scenes = scenes;
    }
}
