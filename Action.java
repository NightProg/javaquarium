package Javaquarium;

public class Action {
    private int indicator;
    private String msg;
    private ActionType actionType;

    public Action(ActionType actionType, String msg, int indicator) {
        this.actionType = actionType;
        this.msg = msg;
        this.indicator = indicator;
    }

    public int getIndicator() {
        return this.indicator;
    }

    public String getMsg() {
        return this.msg;
    }

    public ActionType getActionType() {
        return this.actionType;
    }

    protected void setIndicator(int indicator) {
        this.indicator = indicator;
    }

    protected void setMsg(String msg) {
        this.msg = msg;
    }

    protected void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }
}
