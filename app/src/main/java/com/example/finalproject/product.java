package com.example.finalproject;

public class product {
    private String id;
    private String name;
    private String platform;
    private String actor;
    private String preview;
    private int Img;

    public product(String id, String name, String platform, int Img, String actor, String preview) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.Img = Img;
        this.actor = actor;
        this.preview = preview;
    }
    public int getImg() {return Img; }

    public String getId() {return id; }

    public void setId(String id) { this.id = id; }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getActor() {return actor; }

    public void setActor(String actor) { this.actor = actor; }

    public String getPreview() {return preview; }

    public void setPreview(String preview) { this.preview = preview  ; }
}
