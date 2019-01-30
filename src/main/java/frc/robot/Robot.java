package frc.robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveTrain;
import jaci.pathfinder.followers.EncoderFollower;

public class Robot extends TimedRobot {
  public static DriveTrain driveTrain;
  public static OI m_oi;

  @Override
  public void robotInit() {
    Robot.driveTrain = new DriveTrain(new VictorSP(RobotMap.BACK_LEFT_MOTOR), new VictorSP(RobotMap.FRONT_LEFT_MOTOR),
        new VictorSP(RobotMap.BACK_RIGHT_MOTOR), new VictorSP(RobotMap.FRONT_RIGHT_MOTOR),
        new Encoder(RobotMap.ENCODER_LEFT_A, RobotMap.ENCODER_LEFT_B),
        new Encoder(RobotMap.ENCODER_RIGHT_A, RobotMap.ENCODER_RIGHT_B), new AnalogGyro(RobotMap.ANALOG_GYRO),
        new EncoderFollower(PathfinderFRC.getTrajectory(PathfinderConstants.PathName + ".left"),
            new EncoderFollower(PathfinderFRC.getTrajectory(PathfinderConstants.PathName + ".right"))),
        new Notifier(this::followPath));
    m_oi = new OI();
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("Drivetrain Inverted", Robot.driveTrain.isInverted());
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
