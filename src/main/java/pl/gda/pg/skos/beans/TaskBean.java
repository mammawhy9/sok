package pl.gda.pg.skos.beans;

import com.google.gson.Gson;
import pl.gda.pg.skos.entities.Answer;
import pl.gda.pg.skos.entities.Task;
import pl.gda.pg.skos.utils.BackendUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "TaskBean")
@SessionScoped
public class TaskBean implements Serializable {

    private static final long serialVersionUID = 6388325946836580733L;
    @ManagedProperty(value = "#{MainBean}")
    private MainBean mainBean;
    private List<Task> tasks;
    private List<SelectItem> tasksSiList;
    private Long selectedTaskId;
    private Task selectedTask;
    private Answer answer;
    private Gson gson = new Gson();

    public List<Task> getTasks() {
        if (this.tasks == null) {
            this.tasks = BackendUtils.getTasks();
        }
        return tasks;
    }

    public List<SelectItem> getTasksSiList() {
        if (this.tasksSiList == null) {
            this.tasksSiList = new ArrayList<>();
            for (Task task : getTasks()) {
                tasksSiList.add(new SelectItem(task.getId(), task.getTitle() + " Trudność: " + task.getDifficulty()));
            }
        }
        return this.tasksSiList;
    }

    public void onSelectedTaskChange() {
        if (getSelectedTaskId() != null) {
            for (Task task : tasks) {
                if (task.getId().equals(getSelectedTaskId())) {
                    setSelectedTask(task);
                    break;
                }
            }
            setAnswer(new Answer(getSelectedTask().getId()));
        }

    }

    public void saveTask() {
        if (getSelectedTask() != null) {
            getAnswer().setToken(getMainBean().getToken());
            String json = gson.toJson(getAnswer());
            BackendUtils.saveAnswer(json);
        }
    }

    //////////// GETTERY I SETTERY
    public Long getSelectedTaskId() {
        return this.selectedTaskId;
    }

    public void setSelectedTaskId(Long selectedTaskId) {
        this.selectedTaskId = selectedTaskId;
    }

    public Task getSelectedTask() {
        return selectedTask;
    }

    public void setSelectedTask(Task selectedTask) {
        this.selectedTask = selectedTask;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public MainBean getMainBean() {
        return mainBean;
    }

    public void setMainBean(MainBean mainBean) {
        this.mainBean = mainBean;
    }
}
