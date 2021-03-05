package packageSortingCenter.sortingSystem.roboter;

import com.google.common.eventbus.Subscribe;
import events.Subscriber;

public class Robot extends Subscriber implements IRobot {

    private boolean isOn = false;

    @Subscribe
    public void receive(RobotOn robotOn){
        turnOn();
    }

    @Subscribe
    public void receive(RobotOff robotOff){
        turnOff();
    }

    @Subscribe
    public void receive(RobotStart robotStart){

    }

    private void turnOn(){
        this.isOn = true;
    }

    private void turnOff(){
        this.isOn = false;
    }
}
