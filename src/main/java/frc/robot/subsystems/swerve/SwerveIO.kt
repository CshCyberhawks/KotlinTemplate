package frc.robot.subsystems.swerve

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


class SwerveIO : SubsystemBase() {
    val topRightRotationMotor = TalonFX(topRightRotationMotorID)
    val topLeftRotationMotor = PWMTalonFX(topLeftRotationMotorID)
    val bottomRightRotationMotor = PWMTalonFX(bottomRightRotationMotorID)
    val bottomLeftRotationMotor = PWMTalonFX(bottomLeftRotationMotorID)
    val topRightTranslationMotor = PWMTalonFX(topRightTranslationMotorID)
    val topLeftTranslationMotor = PWMTalonFX(topLeftTranslationMotorID)
    val bottomLeftTranslationMotor = PWMTalonFX(bottomLeftTranslationMotorID)
    val bottomRightTranslationMotor = PWMTalonFX(bottomRightTranslationMotorID)

    val rightJoystick = Joystick(rightJoystickID)
    val leftJoystick = Joystick(leftJoystickID)

    var thetaOfTopRightRotationalMotor =


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

    fun getSpeedOfTopRightRotationMotor() : Double {
        var leftX = leftJoystick.getX()
        var rightX = rightJoystick.getX()
        var rightY = rightJoystick.getY()
        var velocity = Math.sqrt(Math.pow(rightX,2.0) + Math.pow(leftX,2.0))

        return 2.0

    }

}