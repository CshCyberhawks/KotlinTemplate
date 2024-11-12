package frc.robot.subsystems

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX
import edu.wpi.first.wpilibj2.command.SubsystemBase

class TankDrive : SubsystemBase() {
    private val frontLeftWheel = PWMVictorSPX()
    private val frontRightWheel = PWMVictorSPX()
    private val backLeftWheel = PWMVictorSPX()
    private val backRightWheel = PWMVictorSPX()
    fun rightSideSpeed(speed : Double){
        frontRightWheel.set()
        backRightWheel.set()
    }
    fun leftSideSpeed(speed : Double){

    }


}