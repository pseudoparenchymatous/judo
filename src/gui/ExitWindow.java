package gui;

public class ExitWindow implements OptionWindow {
    @Override
    public void spawnWindow() { 
        System.exit(0); 
    }
}
