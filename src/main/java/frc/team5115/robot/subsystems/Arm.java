package frc.team5115.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

public class Arm {
    public TalonSRX arm;
    public AHRS navX;

    public double max = 40; // level 3
    public double level2 = 10;
    public double level1 = -20;
    public double min = -50;
    public double level = 0;

    public Arm(){
        arm = new TalonSRX(0);
        navX = new AHRS(SerialPort.Port.kUSB);
    }

    public void stopLittleB(){arm.set(ControlMode.PercentOutput, 0);}

    public void moveArm(double throt){arm.set(ControlMode.PercentOutput, throt);}

    public void getPosition(){
        if (threshold(min)){
            level = 0;
        }
        else if(threshold(level)){
            level = 1;
        }
        else if(threshold(level2)){
            level = 2;
        }
        else if(threshold(max)){
            level = 3;
        }
       else{
           level =  -1;
        }
    }

    public boolean threshold(double zone){
        return navX.getRoll() <= zone + 2 && navX.getRoll() >= zone - 2;
    }
}
//the big brown fox jumped over the lazy dog the big brown fox jumped over the lazy dog the big brown fox jumped over the lazy dog the big brown
//the big brown fox jumped over the lazy dog the big brown fox jumped over the lazy dog the big brown fox jumped over the lazy dog the big brown
//the big brown fox jumped over the lazy dog the big brown fox jumped over the lazy dog the big brown fox jumped over the lazy dog the big brown