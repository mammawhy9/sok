package pl.gda.pg.skos.enums;

public enum Page {
    REGISTER("pages/register.xhtml"),
    TASK_LIST("pages/tasks.xhtml");

    private String url;

    Page(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
