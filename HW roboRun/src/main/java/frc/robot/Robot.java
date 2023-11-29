// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Robot extends TimedRobot {
  VictorSPX leftMotorF = new VictorSPX(0);
  VictorSPX leftMotorB = new VictorSPX(1);
  VictorSPX rightMotorF = new VictorSPX(2);
  VictorSPX rightMotorB = new VictorSPX(3);
  TalonSRX fireMotorR = new TalonSRX(4);
  TalonSRX fireMotorL = new TalonSRX(5);
  Joystick joy1 = new Joystick(0);

  public void arcade() {

    double speed = joy1.getRawAxis(1) * 0.6;
    double turn = joy1.getRawAxis(4) * 0.3;

    double right = speed - turn;
    double left = speed + turn;

    leftMotorF.set(ControlMode.PercentOutput, left);
    leftMotorB.set(ControlMode.PercentOutput, left);
    rightMotorF.set(ControlMode.PercentOutput, -right);
    rightMotorB.set(ControlMode.PercentOutput, -right);

  }

  public void firing() {

    boolean buttonA = joy1.getRawButton(0);
    boolean buttonM = joy1.getRawButton(1);

    if (buttonA) 
    {
      fireMotorR.set(ControlMode.PercentOutput, 1);
      fireMotorL.set(ControlMode.PercentOutput, -1);
    }

    else if (buttonM) 
    {
      fireMotorR.set(ControlMode.PercentOutput, -0.5);
      fireMotorL.set(ControlMode.PercentOutput, 0.5);
    }

    else 
    {
      fireMotorR.set(ControlMode.PercentOutput, 0);
      fireMotorL.set(ControlMode.PercentOutput, 0);
    }

  }

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    arcade();
    firing();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
