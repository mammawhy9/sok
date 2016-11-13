package pl.gda.pg.skos.beans;

import pl.gda.pg.skos.entities.Task;
import pl.gda.pg.skos.utils.BackendUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "TaskBean")
@SessionScoped
public class TaskBean implements Serializable {

    private static final long serialVersionUID = 6388325946836580733L;
    private List<Task> tasks;
    private List<SelectItem> tasksSiList;

    public List<Task> getTasks() {
        if (this.tasks == null) {
            this.tasks = BackendUtils.getTasks();
        }
        return tasks;
    }

    public List<SelectItem> getTasksSiList() {
        if (this.tasksSiList == null) {
            tasksSiList = new ArrayList<>();
        }
        return this.tasksSiList;
    }
}
