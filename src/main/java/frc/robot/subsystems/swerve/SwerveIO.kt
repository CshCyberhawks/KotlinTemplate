package frc.robot.subsystems.swerve

import com.ctre.phoenix6.hardware.TalonFX
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.robot.subsystems.swerve.SwerveConstants.bottomLeftRotationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.bottomLeftTranslationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.bottomRightRotationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.bottomRightTranslationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.rightJoystickID
import frc.robot.subsystems.swerve.SwerveConstants.topLeftRotationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.topLeftTranslationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.topRightRotationMotorID
import frc.robot.subsystems.swerve.SwerveConstants.topRightTranslationMotorID
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.motorcontrol.Talon
import frc.robot.subsystems.swerve.SwerveConstants.leftJoystickID


object SwerveIO : SubsystemBase() {
    val topRightRotationMotor = TalonFX(topRightRotationMotorID)
    val topLeftRotationMotor = TalonFX(topLeftRotationMotorID)
    val bottomRightRotationMotor = TalonFX(bottomRightRotationMotorID)
    val bottomLeftRotationMotor = TalonFX(bottomLeftRotationMotorID)
    val topRightTranslationMotor = TalonFX(topRightTranslationMotorID)
    val topLeftTranslationMotor = TalonFX(topLeftTranslationMotorID)
    val bottomLeftTranslationMotor = TalonFX(bottomLeftTranslationMotorID)
    val bottomRightTranslationMotor = TalonFX(bottomRightTranslationMotorID)

    val rightJoystick = Joystick(rightJoystickID)
    val leftJoystick = Joystick(leftJoystickID)

    var thetaOfRobot = 0 //degrees
    var velocityOfTopRIghtRotationalMotor = getXSpeedOfRobot() +
    var desiredThetaofTopRightMotor = Math.atan()

    fun setSpeedOfAllMotors(topRightRotationMotorSpeed : Double, topRightTranslationMotorSpeed : Double, topLeftRotationMotorSpeed : Double, topLeftTranslationMotorSpeed : Double, bottomLeftRotationMotorSpeed : Double, bottomLeftTranslationMotorSpeed : Double, bottomRightRotationMotorSpeed : Double, bottomRightTranslationMotorSpeed : Double) {
        topRightRotationMotor.set(topRightRotationMotorSpeed)
        topRightTranslationMotor.set(topRightTranslationMotorSpeed)
        topLeftRotationMotor.set(topLeftRotationMotorSpeed)
        topLeftTranslationMotor.set(topLeftTranslationMotorSpeed)
        bottomLeftRotationMotor.set(bottomLeftRotationMotorSpeed)
        bottomLeftTranslationMotor.set(bottomLeftTranslationMotorSpeed)
        bottomRightRotationMotor.set(bottomRightRotationMotorSpeed)
        bottomRightTranslationMotor.set(bottomRightTranslationMotorSpeed)
    }

    fun getXSpeedOfRobot() : Double {
        return rightJoystick.x
    }

    fun getYSpeedOfRobot() : Double {
        return rightJoystick.y
    }

    fun getSpeedOfTopRightRotationalMotor() {

    }



    fun makeRobotMove() {
    }
}