package frc.robot.Commands;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Subsystems.Arm;
import frc.robot.Subsystems.Intake;

public class ArmCommand extends Command {
    private Arm arm;
    private Intake intake;
    private boolean isFinished = false;
    private boolean forward;

    public ArmCommand(){
        

    }


    @Override
    public void initialize(){
        arm = Constants.arm;

    }
    @Override
    public void execute(){
        SmartDashboard.putBoolean("ArmSwitch", arm.armSwitch.get());

    
        if(Constants.alternateController.getRightTriggerAxis() > 0.2){
            arm.desiredAngle += 0.1;
        }

        else if(arm.armSwitch.get() == true){
            // arm.stall();
            return;   
        }

        else if (Constants.alternateController.getLeftTriggerAxis() > 0.2){
            arm.desiredAngle -= 0.1;
        }
        else {
            // arm.stall();
        }

        // if(Constants.alternateController.rightBumper().getAsBoolean()){
        //     Constants.arm.setDesired(Constants.arm.desiredAngle + 0.01);

        // }


        // if(Constants.alternateController.leftBumper().getAsBoolean()){
        //     Constants.arm.setDesired(Constants.arm.desiredAngle - 0.01);
        // }

        // if(Constants.swerveController.rightTrigger().getAsBoolean()){
        //     Constants.arm.currentPos += 0.01;
        // }

        // if(Constants.swerveController.leftTrigger().getAsBoolean()){
        //     Constants.arm.currentPos -= 0.01;
        // }


        Constants.arm.updateAngle();
        Constants.arm.moveArm();
        

    }

    @Override
    public void end(boolean interrupted) {
        arm.stop();

    }






}

