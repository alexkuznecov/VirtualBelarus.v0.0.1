package by.grsu.domain;

public class TransitionHotSpot {

    private Integer id;

    private Integer sceneId;

    private InfoHotSpot infoHotSpot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public InfoHotSpot getHotSpot() {
        return infoHotSpot;
    }

    public void setHotSpot(InfoHotSpot infohotSpot) {
        this.infoHotSpot = infohotSpot;
    }
}
