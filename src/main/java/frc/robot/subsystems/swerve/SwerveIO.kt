package frc.robot.subsystems.swerve

import com.ctre.phoenix6.StatusSignal
import com.ctre.phoenix6.hardware.TalonFX
import edu.wpi.first.hal.simulation.PWMDataJNI.getPosition
import edu.wpi.first.units.ImmutableMeasure.ofRelativeUnits
import edu.wpi.first.units.measure.Angle
import edu.wpi.first.units.measure.Angle.ofBaseUnits
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
import frc.robot.subsystems.swerve.SwerveConstants.*
import java.lang.Math.toRadians
import kotlin.math.*


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

    var thetaOfRobot = 90.0 //degrees
    //topRightWheel
    var velocityOfTopRightTranslationalMotorX = 0.0
    var velocityOfTopRightTranslationalMotorY = 0.0
    var desiredThetaOfTopRightRotationalMotor = 0.0
    var currentThetaOfTopRightRotationalMotor = 0.0 //degrees
    var changeInThetaOfTopRightRotationalMotor = 0.0
    //topLeftWheel
    var velocityOfTopLeftTranslationalMotorX = 0.0
    var velocityOfTopLeftTranslationalMotorY = 0.0
    var desiredThetaOfTopLeftRotationalMotor = 0.0
    var currentThetaOfTopLeftRotationalMotor = 0.0
    var changeInThetaOfTopLeftRotationalMotor = 0.0
    //bottomLeftWheel
    var velocityOfBottomLeftTranslationalMotorX = 0.0
    var velocityOfBottomLeftTranslationalMotorY = 0.0
    var desiredThetaOfBottomLeftRotationalMotor = 0.0
    var currentThetaOfBottomLeftRotationalMotor = 0.0
    var changeInThetaOfBottomLeftRotationalMotor = 0.0
    //bottomRightWheel
    var velocityOfBottomRightTranslationalMotorX = 0.0
    var velocityOfBottomRightTranslationalMotorY = 0.0
    var desiredThetaOfBottomRightRotationalMotor = 0.0
    var currentThetaOfBottomRightRotationalMotor = 0.0
    var changeInThetaOfBottomRightRotationalMotor = 0.0




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

    fun getSpeedOfTopRightRotationalMotor() : Double {









        /*var isCounterClockwise : Boolean
        if (changeInThetaOfTopRightRotationalMotor > 180) {
            isCounterClockwise = false
        } else {
            isCounterClockwise = true
        }*/
        if (abs(topRightRotationMotor.get()) < maxVelocity) {
            if (currentThetaOfTopRightRotationalMotor < desiredThetaOfTopRightRotationalMotor / 2) {
                if (topRightRotationMotor.get() >= 0) {
                    return topRightRotationMotor.get() + accelerationStep
                }
                else {
                    return topRightRotationMotor.get() -accelerationStep
                }
            } else {
                if (topRightRotationMotor.get() >= 0) {
                    return topRightRotationMotor.get() - accelerationStep
                }
                else {
                    return topRightRotationMotor.get() + accelerationStep
                }
            }
        } else if (changeInThetaOfTopRightRotationalMotor <= (rotationalMaxVelocity * (rotationalMaxVelocity/rotationalAcceleration))/2) {
            return topRightRotationMotor.get() - accelerationStep
        }

    }





    fun updateMotors() {
        velocityOfTopRightTranslationalMotorX = getXSpeedOfRobot() + length * leftJoystick.x / sqrt(2.0) * cos(toRadians(thetaOfRobot) + PI/2)
        velocityOfTopRightTranslationalMotorY = getYSpeedOfRobot() + length * leftJoystick.x / sqrt(2.0) * sin(toRadians(thetaOfRobot) + PI/2)
        desiredThetaOfTopRightRotationalMotor = if (velocityOfTopRightTranslationalMotorX < 0) atan(velocityOfTopRightTranslationalMotorY/velocityOfTopRightTranslationalMotorX) + PI else atan(velocityOfTopRightTranslationalMotorY/velocityOfTopRightTranslationalMotorX)
        changeInThetaOfTopRightRotationalMotor = desiredThetaOfTopRightRotationalMotor - currentThetaOfTopRightRotationalMotor




    }
}