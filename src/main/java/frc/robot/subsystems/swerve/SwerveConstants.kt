package frc.robot.subsystems.swerve

object SwerveConstants {
    const val topRightRotationMotorID = 0
    const val topRightTranslationMotorID = 1
    const val topLeftRotationMotorID = 3
    const val topLeftTranslationMotorID = 4
    const val bottomLeftRotationMotorID = 5
    const val bottomLeftTranslationMotorID = 6
    const val bottomRightRotationMotorID = 7
    const val bottomRightTranslationMotorID = 8

    const val leftJoystickID = 0
    const val rightJoystickID = 1

    const val width = 27.5 //inches
    const val length = 27.5 // inches

    const val maxVelocity = .8 // Unit
    const val accelerationStep = 0.06 //Units
    const val acceleration = 3 //Units/s^2
    const val rotationalAcceleration = acceleration * 100 * 360 //degrees/s
    const val rotationalMaxVelocity = maxVelocity * 100 * 360 //degrees



}