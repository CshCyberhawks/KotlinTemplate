package frc.robot.subsystems

import kotlin.math.max
import kotlin.math.abs
import edu.wpi.first.wpilibj2.command.SubsystemBase
import edu.wpi.first.wpilibj.Joystick
import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkLowLevel.MotorType.kBrushless

object TankDrive : SubsystemBase() {
    private val frontleft=CANSparkMax(22,kBrushless)
    private val frontright=CANSparkMax(21,kBrushless)
    private val backleft =CANSparkMax(23,kBrushless)
    private val backright =CANSparkMax(17,kBrushless)

    private val stick=Joystick(0)

    fun gojustgogoddammit(){
        var x=stick.getX()
        var y=stick.getY()
        var lout=x-y
        var rout=-x-y
        var max=max(abs(lout),abs(rout))
        lout*=max
        rout*=max
        frontleft.set(lout)
        backleft.set(lout)
        frontright.set(rout)
        backright.set(rout)
    }
}