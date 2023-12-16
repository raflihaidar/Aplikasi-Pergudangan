package Components;

public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onAdd(int row);
}
