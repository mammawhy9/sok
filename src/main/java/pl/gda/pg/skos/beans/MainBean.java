package pl.gda.pg.skos.beans;

import pl.gda.pg.skos.entities.Candidate;
import pl.gda.pg.skos.enums.Page;
import pl.gda.pg.skos.utils.BackendUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean(name = "MainBean")
@SessionScoped
public class MainBean implements Serializable {

    private static final long serialVersionUID = -3621459338416079996L;
    private Page currentPage = Page.REGISTER;
    private String token;
    private Candidate user;

    public MainBean() {
        this.token = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("token");
        if (getToken() != null) {
            this.user = BackendUtils.getCandidateFromToken(getToken());
            if (this.user != null) {
                this.currentPage = Page.TASK_LIST;
            }
        }
    }

    public void goToMainPage() {
        if (this.user != null) {
            this.currentPage = Page.TASK_LIST;
        } else {
            this.currentPage = Page.REGISTER;
        }
    }

    public void goToContactPage() {
        this.currentPage = Page.CONTACT;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Candidate getUser() {
        return user;
    }

    public void setUser(Candidate user) {
        this.user = user;
    }
}