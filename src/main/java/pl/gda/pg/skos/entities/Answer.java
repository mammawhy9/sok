package pl.gda.pg.skos.entities;

import java.io.Serializable;

public class Answer implements Serializable {

    private static final long serialVersionUID = -2696531522087275194L;
    private String content;
    private String token;
    private Long taskId;

    public Answer() {
    }

    public Answer(Long taskId) {
        setTaskId(taskId);
    }

    public String getContent() {
        return content;
    }

    public String getToken() {
        return token;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
}
