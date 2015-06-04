package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehanss on 11.05.2015.
 */
public class Command implements Cloneable {

    private static List<Command> avialableCommands;

    private int id;

    private String label;

    public Command(int id, String label){
        this.id = id;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return  id;
    }

    @Override
    public Command clone() {
        return new Command(id, label);
    }

    public static List<Command> getAviableCommands(){
        if (null == avialableCommands){
            avialableCommands = new ArrayList<Command>();
            avialableCommands.add(new Command(1, "Nach vorne gehen"));
            avialableCommands.add(new Command(2, "Nach Links gehen"));
            avialableCommands.add(new Command(3, "Nach rechts gehen"));
            avialableCommands.add(new Command(4, "Rückwärts gehen"));
            avialableCommands.add(new Command(5, "Sich nach links drehen"));
            avialableCommands.add(new Command(6, "Sich nach rechts drehen"));
            avialableCommands.add(new Command(7, "Sich umdrehen"));
            avialableCommands.add(new Command(8, "Winken"));
            avialableCommands.add(new Command(9, "Hallo sagen"));
            avialableCommands.add(new Command(10, "Linker Arm hoch"));
            avialableCommands.add(new Command(11, "Rechter Arm hoch"));
            avialableCommands.add(new Command(12, "Beide Arme hoch"));
            avialableCommands.add(new Command(13, "Rechter Arm runter"));
            avialableCommands.add(new Command(14, "Linker Arm runter"));
            avialableCommands.add(new Command(15, "Beide Arme runter"));
        }
        return avialableCommands;
    }
}

