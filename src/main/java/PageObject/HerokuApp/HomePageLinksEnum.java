package PageObject.HerokuApp;

public enum HomePageLinksEnum {
    DYNAMIC_CONTROLS("Dynamic Controls");

    String link;

    HomePageLinksEnum(String link) {
        this.link = link;
    }

    public String getLinkText() {
        return link;
    }
}
