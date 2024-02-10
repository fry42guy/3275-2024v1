// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import java.util.HashMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;
import frc.lib.util.COTSFalconSwerveConstants;
import frc.lib.util.SwerveModuleConstants;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final double stickDeadband = 0.05;

public static class Arm{

  public static final int LeftPivotID = 49;
  public static final int RightPivotID = 47;
  public static final int EncoderPWMID = 9;
  public static final double ArmUpSpeed = .50;
  public static final double ArmDownSpeed = -.50;

  public static final double MAX_CURRENT_DRAW = 25;

}


  public static class Intake{

    public static final int IntakeMotorID = 44;
 
  public static final Double FWDSpeed = 1.0; 
  public static final Double REVSpeed = -1.0;
  public static boolean IsInverted = false;

  }

public static class Shooter{

  public static final int LeftShooterID = 40;
  public static final int RightShooterID = 46;

  public static final Double SlowSpeed = .375;
  public static final Double FastSpeed = .50;
  public static final Double SameSpeed = .75; //Not Used
  public static final Double TopSpeed = 0.6; //Not used
  public static final Double BottomSpeed = 0.4;//Not used
}

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
  public static final class Swerve {
    
    // public static final int pigeonID = 1;
     public static final boolean invertGyro = true; // Always ensure Gyro is CCW+ CW- // I belive Navx is true
     
     public static final String CANivore = "CANt_open_file";// name of the canivore
 
     public static final COTSFalconSwerveConstants chosenModule =  //TODO: This must be tuned to specific robot
         COTSFalconSwerveConstants.SDSMK4(COTSFalconSwerveConstants.driveGearRatios.SDSMK4_L2);
 
     /* Drivetrain Constants */
     public static final double trackWidth = 0.58; // 20.5 in -> meters
     public static final double wheelBase = 0.595; // meters
     public static final double wheelCircumference = chosenModule.wheelCircumference;
 
     /* Swerve Kinematics 
      * No need to ever change this unless you are not doing a traditional rectangular/square 4 module swerve */
      public static final SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
         new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
         new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
         new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
         new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));
 
     /* Module Gear Ratios */
     public static final double driveGearRatio = chosenModule.driveGearRatio;
     public static final double angleGearRatio = chosenModule.angleGearRatio;
 
     /* Motor Inverts */
     public static final boolean angleMotorInvert = chosenModule.angleMotorInvert;
     public static final boolean driveMotorInvert = chosenModule.driveMotorInvert;
 
     /* Angle Encoder Invert */
     public static final boolean canCoderInvert = chosenModule.canCoderInvert;
 
     /* Swerve Current Limiting */
     public static final int angleContinuousCurrentLimit = 25;
     public static final int anglePeakCurrentLimit = 40;
     public static final double anglePeakCurrentDuration = 0.1;
     public static final boolean angleEnableCurrentLimit = true;
 
     public static final int driveContinuousCurrentLimit = 35;
     public static final int drivePeakCurrentLimit = 60;
     public static final double drivePeakCurrentDuration = 0.1;
     public static final boolean driveEnableCurrentLimit = true;
 
     /* These values are used by the drive falcon to ramp in open loop and closed loop driving.
      * We found a small open loop ramp (0.25) helps with tread wear, tipping, etc */
     public static final double openLoopRamp = 0.25;
     public static final double closedLoopRamp = 0.0;
 
     /* Angle Motor PID Values */
     public static final double angleKP = chosenModule.angleKP;
     public static final double angleKI = chosenModule.angleKI;
     public static final double angleKD = chosenModule.angleKD;
     public static final double angleKF = chosenModule.angleKF;
 
     /* Drive Motor PID Values */
     public static final double driveKP = 0.45; //TODO: This must be tuned to specific robot
     public static final double driveKI = 0.0;
     public static final double driveKD = 0.0;
     public static final double driveKF = 0.0;
 
     /* Drive Motor Characterization Values 
      * Divide SYSID values by 12 to convert from volts to percent output for CTRE */
     public static final double driveKS = (0.1724 / 12); // TUNED
     public static final double driveKV = (2.0434 / 12);
     public static final double driveKA = (0.72651 / 12);
 
     /* Swerve Profiling Values */
     /** Meters per Second */
     public static final double maxSpeed = 4; //TODO: This must be tuned to specific robot
     /** Radians per Second */
     public static final double maxAngularVelocity = 4; //TODO: This must be tuned to specific robot #############################################
 
     /* Neutral Modes */
     public static final NeutralMode angleNeutralMode = NeutralMode.Coast;
     public static final NeutralMode driveNeutralMode = NeutralMode.Brake;
 
     /* Module Specific Constants */
     /* Front Left Module - Module 0 */
     public static final class Mod0 { //TODO: This must be tuned to specific robot
 
         public static final int driveMotorID = 8;
         public static final int angleMotorID = 7;
         public static final int canCoderID = 4;
         public static final Rotation2d angleOffset = Rotation2d.fromDegrees(118.65+180);
         
         public static final SwerveModuleConstants constants = 
             new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
     }
 
     /* Front Right Module - Module 1 */
     public static final class Mod1 { //TODO: This must be tuned to specific robot
 
         public static final int driveMotorID = 6;
         public static final int angleMotorID = 5;
         public static final int canCoderID = 3;
         public static final Rotation2d angleOffset = Rotation2d.fromDegrees(53.6); //+180
 
         public static final SwerveModuleConstants constants = 
             new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
     }
     
     /* Back Left Module - Module 2 */
     public static final class Mod2 { //TODO: This must be tuned to specific robot
 
         public static final int driveMotorID = 2;
         public static final int angleMotorID = 1;
         public static final int canCoderID = 1;
         public static final Rotation2d angleOffset = Rotation2d.fromDegrees(298);//113.104+180
 
         public static final SwerveModuleConstants constants = 
             new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
     }
 
     /* Back Right Module - Module 3 */
     public static final class Mod3 { //TODO: This must be tuned to specific robot
 
         public static final int driveMotorID = 4;
         public static final int angleMotorID = 3;
         public static final int canCoderID = 2;
         public static final Rotation2d angleOffset = Rotation2d.fromDegrees(5.09+180-180);
         public static final SwerveModuleConstants constants = 
             new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, angleOffset);
     }
 }
}
