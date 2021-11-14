package Javaquarium;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class History {
    private final List<Action> list_action = new ArrayList<>();

    public History() {
    }



    public void addAction(ActionType actionType, String message, int indicator) {
        this.list_action.add(new Action(actionType, message, indicator));

    }

    public List<Action> getListAction() {
        return list_action;
    }




    public Action getAction(int index) {
        return list_action.get(index);
    }



    public List<Action> getActionFromIndicator(int indicator) {
        return list_action.stream().filter(i -> indicator == i.getIndicator()).collect(Collectors.toList());
    }


}




