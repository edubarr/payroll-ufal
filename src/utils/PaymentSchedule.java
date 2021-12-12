package utils;

import java.util.ArrayList;

public class PaymentSchedule {

    public static ArrayList<String> createDefault(){
        ArrayList<String> schedules= new ArrayList<>();
        String hourlyDefault = "Semanalmente";
        String commissionedDefault = "Quinzenalmente";
        String salariedDefault = "Mensalmente";
        schedules.add(0, salariedDefault);
        schedules.add(1, commissionedDefault);
        schedules.add(2, hourlyDefault);

        return schedules;
    }
}