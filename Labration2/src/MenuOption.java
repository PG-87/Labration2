public class MenuOption implements MenuAction{
    String text;
    MenuAction run;

    @Override
    public String toString() {
        return text;
    }

    @Override
    public void run() {
    }
}




