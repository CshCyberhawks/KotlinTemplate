package frc.robot.subsystems

import com.revrobotics.spark.SparkMax
import com.revrobotics.spark.SparkLowLevel.MotorType.kBrushless
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj2.command.SubsystemBase
import kotlin.math.abs
import kotlin.math.max

object TankDrive: SubsystemBase() {
    private val frontleft = SparkMax(22, kBrushless)
    private val frontright = SparkMax(21, kBrushless)
    private val backleft = SparkMax(23, kBrushless)
    private val backright = SparkMax(17, kBrushless)

    private val stick = Joystick(0)

    fun gojustgogoddammit() {
        var x = stick.getX()
        var y = stick.getY()
        var lout = x - y
        var rout = -x - y
        var max = max(abs(lout), abs(rout))
        lout *= max
        rout *= -max
        frontleft.set(lout)
        backleft.set(lout)
        frontright.set(rout)
        backright.set(rout)
    }
}