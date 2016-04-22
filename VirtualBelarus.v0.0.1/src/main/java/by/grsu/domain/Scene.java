package by.grsu.domain;

import java.util.List;

public class Scene {

    private Integer id;

    private String title;

    private String about;

    private SceneType sceneType;

    private Image preview;

    private List<TransitionHotSpot> transitionHotSpots;

    private List<InfoHotSpot> hotSpots;

    private List<Image> images;

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

    public SceneType getSceneType() {
        return sceneType;
    }

    public void setSceneType(SceneType sceneType) {
        this.sceneType = sceneType;
    }

    public Image getPreview() {
        return preview;
    }

    public void setPreview(Image preview) {
        this.preview = preview;
    }

    public List<TransitionHotSpot> getTransitionHotSpots() {
        return transitionHotSpots;
    }

    public void setTransitionHotSpots(List<TransitionHotSpot> transitionHotSpots) {
        this.transitionHotSpots = transitionHotSpots;
    }

    public List<InfoHotSpot> getHotSpots() {
        return hotSpots;
    }

    public void setHotSpots(List<InfoHotSpot> hotSpots) {
        this.hotSpots = hotSpots;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
